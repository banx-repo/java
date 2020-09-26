package vn.techmaster.lab6.game.weapon;

import java.util.Scanner;

import vn.techmaster.lab6.game.Weapon;

public class Sword extends Weapon {
    public Sword(Scanner in) {
        if (!this.create(in)) {
            throw new IllegalArgumentException("Đã hủy");
        }
    }

    public void attack() {
        System.out.println("Attack by Sword... Deals " + this.getDamage() + " damages.");
    }
}
