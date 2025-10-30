import java.util.ArrayList;

class GameObject {
	private int x;
	private int y;
	private int width, height;
	
	// konstruktor
    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
	//get i set
    public int getX() { return x;}
    public void setX(int x) {this.x = x;}
    
    public int getY() { return y; }
    public void setY(int y) {this.y = y;}
    
    public int getWidth() { return width; }
    public void setWidth(int width) {
    	if (width > 0)
    		this.width = width;
    	}
    
    public int getHeight() { return height; }
    public void setHeight(int height) {
    	if (height > 0)
    		this.height = height;
    	}
    @Override
    public String toString() {
        return "@ (" + x + "," + y + ")" + width + "x" + height;
    }
}
class Player extends GameObject {
	private String name;
    private int health;

    public Player(String name, int x, int y, int width, int height, int health) {
        super(x, y, width, height);
        this.name = name;
        this.health =health;
        }
  //getteri i setteri
    public String getName() {return name;}
    public void setName() {
    	if (name == null || name.isEmpty()) {
            this.name = "Unknown";
        }
    }
    public int getHealth() { return health; }
    public void setHealth(int health) {
        if (health < 0) this.health = 0;
        else if (health > 100) this.health = 100;
        else this.health = health;
    }
    @Override
    public String toString() {
        return "Player[" + name + "]" + super.toString() + " HP=" + health;
    }
}

class Enemy extends GameObject {
    private String type;
    private int damage;
    private int health;

    public Enemy(String type, int x, int y, int width, int height, int damage, int health) {
        super(x, y, width, height);
        this.type = type;
        this.damage = damage;
        this.health = health;
    }
    // Getteri i setteri
    public String getType() { return type; }
    public void setType(String type) {
        if (type == null || type.isEmpty()) {
            this.type = "Unknown";
            }
        }
    public int getDamage() { return damage; }
    public void setDamage(int damage) {
        if (damage < 0) this.damage = 0;
        else if (damage > 100) this.damage = 100;
        else this.damage = damage;
    }
    public int getHealth() { return health; }
    public void setHealth(int health) {
        if (health < 0) this.health = 0;
        else if (health > 100) this.health = 100;
        else this.health = health;
    }
	
    @Override
    public String toString() {
        return "Enemy[" + type + "]" + super.toString() + " DMG=" + damage + " HP=" + health;
    }
}
	
class MeleeEnemy extends Enemy {
    public MeleeEnemy(String type, int x, int y, int width, int height, int damage, int health) {
        super(type, x, y, width, height, damage, health);
    }

    @Override
    public String toString() {
        return "MeleeEnemy" + super.toString().substring(5);
    }
}

class BossEnemy extends Enemy {
    public BossEnemy(String type, int x, int y, int width, int height, int damage, int health) {
        super(type, x, y, width, height, damage, health);
    }

    @Override
    public String toString() {
        return "BossEnemy[" + getType() + "]" + "@ (" + getX() + "," + getY() + ")" + 
               getWidth() + "x" + getHeight() + " DMG=" + (getDamage() * 2) + " HP=" + getHealth();
    }
}



public class Game { 
	private static ArrayList<Enemy> enemies = new ArrayList<>();
    private static ArrayList<String> eventLog = new ArrayList<>();
    
    public static void addEnemy(Enemy e) {
        enemies.add(e); 
        eventLog.add("Enemy added: " + e.getType() + " at (" + e.getX() + "," + e.getY() + ")");
    }
    public static void printEventLog() {
        System.out.println("Event Log");
        for (String event : eventLog) {
            System.out.println(event);
        }
    }
	
	public static boolean checkColision(Player p, Enemy e) {
	    return p.getX() < e.getX() + e.getWidth() &&      
	           p.getX() + p.getWidth() > e.getX() &&      
	           p.getY() < e.getY() + e.getHeight() &&     
	           p.getY() + p.getHeight() > e.getY();
	}
	
	public static Enemy findByType(Enemy[] enemies, String type) {
	    for (Enemy e : enemies) {
	        if (e.getType().toLowerCase().contains(type.toLowerCase())) {
	            return e;
	        }
	    }
	    return null;
	}
	
	public static void main(String[] args) {
		addEnemy(new Enemy("Goblin", 10, 5, 16, 16, 15, 50));
        addEnemy(new Enemy("Orc", 20, 8, 20, 20, 25, 70));
        addEnemy(new BossEnemy("Goblin King", 12, 3, 32, 32, 25, 120));
	}
	
	

}