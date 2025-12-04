
public class MeleeEnemy extends Enemy {

    public MeleeEnemy(int x, int y, int damage, Collidable collider) {
        super(x, y, damage, collider);
    }

    @Override
    public String getDisplayName() {
        return "MeleeEnemy";
    }

    @Override
    public String toString() {
        return "MeleeEnemy (damage=" + getDamage() + ")";
    }
}