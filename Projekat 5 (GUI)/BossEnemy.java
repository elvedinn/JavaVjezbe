
public class BossEnemy extends Enemy {

    public BossEnemy(int x, int y, int damage, Collidable collider) {
        super(x, y, damage, collider);
    }

    @Override
    public int getEffectiveDamage() {
        return getDamage() * 2;
    }

    @Override
    public String getDisplayName() {
        return "BossEnemy";
    }

    @Override
    public String toString() {
        return "BossEnemy (baseDamage=" + getDamage() +
               ", effectiveDamage=" + getEffectiveDamage() + ")";
    }
}