package vn.techmaster.lab6.game;

public class Character {
    private static int count = 0;
    private int id;
    private String name;
    private Weapon weapon;

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

    private void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void changeWeapon(Weapon weapon) {
        this.setWeapon(weapon);
    }

    public void attack() {
        this.getWeapon().attack();
    }

    Character(String name) {
        this.setId();
        this.setName(name);
    }
}
