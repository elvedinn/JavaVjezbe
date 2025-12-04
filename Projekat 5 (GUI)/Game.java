import java.util.ArrayList;

public class Game {

    private Player player;
    private ArrayList<Enemy> enemies;
    private ArrayList<String> eventLog;

    public Game(Player player) {
        if (player == null)
            throw new IllegalArgumentException("Player cannot be null.");

        this.player = player;
        this.enemies = new ArrayList<>();
        this.eventLog = new ArrayList<>();
    }
    
    
    
    public boolean checkCollision(Player p, Enemy e) {
        if (p == null || e == null)
            throw new IllegalArgumentException("Arguments cannot be null.");

        return p.intersects(e);
    }
    
    
    
    public void decreaseHealth(Player p, Enemy e) {
        if (p == null || e == null)
            throw new IllegalArgumentException("Player or enemy is null.");

        int before = p.getHealth();
        int dmg = e.getEffectiveDamage();
        int after = Math.max(0, before - dmg);
        p.setHealth(after);

        eventLog.add("HIT: Player by " + e.getDisplayName() +
                     " for " + dmg + " -> HP " + before + " > " + after);
    }
    
    
    
    
    
    public void addEnemy(Enemy e) {
        if (e == null)
            throw new IllegalArgumentException("Enemy cannot be null.");
        enemies.add(e);
        eventLog.add("Added enemy: " + e.getDisplayName());
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    
    
    
    
    public ArrayList<Enemy> findByType(String query) {
        ArrayList<Enemy> result = new ArrayList<>();
        String q = query.toLowerCase();

        for (Enemy e : enemies) {
            if (e.getDisplayName().toLowerCase().contains(q))
                result.add(e);
        }

        return result;
    }
    
    
    
    
    public ArrayList<Enemy> collidingWithPlayer() {
        ArrayList<Enemy> list = new ArrayList<>();

        for (Enemy e : enemies) {
            if (checkCollision(player, e))
                list.add(e);
        }

        return list;
    }
    
    
    
    
    
    public void resolveCollisions() {
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                decreaseHealth(player, e);
            }
        }
    }

    public ArrayList<String> getEventLog() {
        return eventLog;
    }
    
    
    
    
    
    
    public static Enemy parseEnemy(String line) {

        if (line == null || line.isEmpty())
            throw new IllegalArgumentException("Line cannot be empty.");

        try {
            String[] parts = line.split(";");

            if (parts.length != 5)
                throw new IllegalArgumentException("Invalid format: must contain 5 sections.");

            String typeName = parts[0].trim();

            String[] coords = parts[1].split(",");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);

            Collidable collider;

            if (parts[2].contains("x")) {
                String[] wh = parts[2].split("x");
                int w = Integer.parseInt(wh[0]);
                int h = Integer.parseInt(wh[1]);
                collider = new RectangleCollider(x, y, w, h);
            } else {
                int r = Integer.parseInt(parts[2]);
                collider = new CircleCollider(x, y, r);
            }

            int damage = Integer.parseInt(parts[3]);

            String type = parts[4].trim().toLowerCase();

            if (type.equals("boss"))
                return new BossEnemy(x, y, damage, collider);
            return new MeleeEnemy(x, y, damage, collider);

        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Invalid number format in line: " + line);
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot parse enemy: " + e.getMessage());
        }
    }
    
    
    public static void main(String[] args) {
        Player p = new Player(
                "  peTar   petrovic ",
                10, 10,
                new RectangleCollider(10, 10, 32, 32)
        );

        Game game = new Game(p);

        
        
        Enemy gob1 = new MeleeEnemy(
                12, 5,
                20,
                new RectangleCollider(12, 5, 16, 16)
        );
        game.addEnemy(gob1);

        
        Enemy gob2 = Game.parseEnemy("Goblin;15,18;10;15;boss");
        game.addEnemy(gob2);

        System.out.println("All enemies:");
        for (Enemy e : game.getEnemies()) {
            System.out.println("  - " + e);
        }

        
        System.out.println("\nEnemies containing 'gob':");
        for (Enemy e : game.findByType("gob")) {
            System.out.println("  - " + e);
        }

        
        System.out.println("\nPlayer before: " + p);

        
        game.resolveCollisions();

        
        System.out.println("Player after: " + p);

        
        System.out.println("\nEvent Log:");
        for (String log : game.getEventLog()) {
            System.out.println(log);
        }
    }



	public static ArrayList<Enemy> loadEnemiesFromCSV(String string) {
		return null;
	}
}