package vn.techmaster.lab6.game;

public class Character {
    private Weapon weapon;

    Character(Weapon weapon) {
        this.weapon = weapon;
    }

    void attack() {
        weapon.attack();
    }

    void changeWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
