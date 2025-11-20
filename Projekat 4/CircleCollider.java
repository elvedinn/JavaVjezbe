
public class CircleCollider implements Collidable {
	  private int x, y;
	  private int radius;
	  
	  
	  
	  public int getX() {return x;}
	  public void setX(int x) {
		  this.x = x;
	  }

	  public int getY() {return y;}
	  public void setY(int y) {
		  this.y = y;
	  }

	  public int getRadius() {return radius;}
	  public void setRadius(int radius) {
		  this.radius = radius;
	  }

	  public CircleCollider(int x, int y, int radius) {
		  if (radius <= 0)
			  throw new IllegalArgumentException("Poluprečnik mora biti veći od 0.");
		  this.x = x;
	      this.y = y;
	      this.radius = radius;
	    }

	@Override
	public boolean intersects(Collidable other) {
		// TODO Auto-generated method stub
		return false;
	}

}
