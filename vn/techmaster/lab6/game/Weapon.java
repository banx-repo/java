package vn.techmaster.lab6.game;

public class Weapon {
    private static int count = 0;
    private int id;
    private String name;
    private long damage;
    private float attackSpeed;

    public static int getTotal() {
        return count;
    }

    private int getNewId() {
        return count++;
    }

    private void setId() {
        this.id = this.getNewId();
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setDamage(long damage) {
        this.damage = damage;
    }

    private void setAttackSpeed(float attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public long getDamage() {
        return this.damage;
    }

    public float getAttackSpeed() {
        return this.attackSpeed;
    }

    public void attack() {
        System.out.print("Attack by " + this.getName() + "... ");
        System.out.println("Deals damage " + this.getDamage());
    };

    Weapon(String name, long damage, float attackSpeed) {
        this.setId();
        this.setName(name);
        this.setDamage(damage);
        this.setAttackSpeed(attackSpeed);
    }
}
