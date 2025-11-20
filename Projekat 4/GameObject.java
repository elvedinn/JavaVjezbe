
public abstract class GameObject {
    private int x, y;
    protected Collidable collider;

    public GameObject(int x, int y, Collidable collider) {
        this.setX(x);
        this.setY(y);
        this.setCollider(collider);
    }
    public int getX() {return x;}
    public void setX(int x) {
    	this.x = x;
    	}
    
    public int getY() {return y;}
    public void setY(int y) {
    	this.y = y;
    	}
    
    public Collidable getCollider() {return collider;}
    public void setCollider(Collidable c) {
        if (c == null)
            throw new IllegalArgumentException("Collider ne može biti null.");
        this.collider = c;
    }

    
    public boolean intersects(GameObject other) {
        return this.collider.intersects(other.collider);
    }

    @Override
    public String toString() {
        return "GameObject at (" + x + "," + y + ")";
    }

    public abstract String getDisplayName();
    
}