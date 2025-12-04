
public class Player extends GameObject {
	private String name;
    private int health;

    public Player(String name, int x, int y, Collidable collider) {
        super(x, y, collider);
        setName(name);
        setHealth(100);
    }
    
    public void setName(String name) {
        if (name == null) 
            throw new IllegalArgumentException("Ime ne može biti null.");

        name = name.trim().replaceAll("\\s+", " ");
        if (name.isEmpty())
            throw new IllegalArgumentException("Ime ne smije biti prazno.");

        String[] parts = name.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String p : parts) {
            sb.append(Character.toUpperCase(p.charAt(0)))
              .append(p.substring(1).toLowerCase())
              .append(" ");
        }
        this.name = sb.toString().trim();
    }
    
    
    public void setHealth(int h) {
        if (h < 0 || h > 100)
            throw new IllegalArgumentException("Health mora biti između 0 i 100.");
        this.health = h;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String getDisplayName() {
        return "Player: " + name;
    }

    @Override
    public String toString() {
        return getDisplayName() + " (" + health + " HP)";
    }
}


