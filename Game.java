import java.util.ArrayList;

class Player{
	
	private String name;
    private int x, y;
    private int width, height;
    private int health;
    
    // konstruktor
    public Player(String name, int x, int y, int width, int height, int health) {
    	this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.health = health;
    }
    
    //getteri i setteri
    public String getName() {return name;}
    public void setName() {
    	if (name == null || name.isEmpty()) {
            this.name = "Unknown";
        }
    }
    
    public int getX() { return x;}
    public void setX(int x) {this.x = x;}
    
    public int getY() { return y; }
    public void setY(int y) {this.y = y;}
    
    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width;}
    
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height;}
    
    public int getHealth() { return health; }
    public void setHealth(int health) {
        if (health < 0) this.health = 0;
        else if (health > 100) this.health = 100;
        else this.health = health;
    }
    
    //toString metoda
    @Override
    public String toString() {
        return "Player[" + name + "] @ (" + x + "," + y + ") " + width + "x" + height + " HP=" + health;
    }
    
}

class Enemy {
    private String type;
    private int x, y;
    private int width, height;
    private int damage;

    // Konstruktor
    public Enemy(String type, int x, int y, int width, int height, int damage) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.damage = damage;
    }
    

    // Getteri i setteri
    public String getType() { return type; }
    public void setType(String type) {
        if (type == null || type.isEmpty()) {
            this.type = "Unknown";
            }
        }
    
    public int getX() { return x; }
    public void setX(int x) { this.x = x;}
    
    public int getY() { return y; }
    public void setY(int y) { this.y = y;}
    
    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width;}
    
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height;}
    
    public int getDamage() { return damage; }
    public void setDamage(int damage) {
        if (damage < 0) this.damage = 0;
        else if (damage > 100) this.damage = 100;
        else this.damage = damage;
    }

    // toString metoda
    @Override
    public String toString() {
        return "Enemy[" + type + "] @ (" + x + "," + y + ") " + width + "x" + height + " DMG=" + damage;
    }

}


public class Game {
	private Player player;
    private ArrayList<Enemy> enemies;
    private ArrayList<String> eventLog;
    
 // Dodavanje neprijatelja
    public void addEnemy(Enemy e) {
        enemies.add(e);
        eventLog.add("Dodano: " + e);
    }

    public Game(Player player) {
        this.player = player;
        enemies = new ArrayList<>();
        eventLog = new ArrayList<>();
    }
	
	public static void main(String[] args) {
		Player p = new Player("Ognjen", 10, 5, 32, 32, 85);
        Game g = new Game(p);

        Enemy e1 = new Enemy("Goblin", 12, 5, 16, 16, 20);

	}

}
