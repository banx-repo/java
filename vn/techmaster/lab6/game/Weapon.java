package vn.techmaster.lab6.game;

import java.util.Scanner;

import vn.techmaster.lab6.game.weapon.Attackable;

public abstract class Weapon implements Attackable {
    private int count = 0;
    private int id;
    private String name;
    private long damage;

    protected int newId() {
        return this.count++;
    }

    protected int total() {
        return this.count;
    }

    protected int getId() {
        return this.id;
    }

    protected String getName() {
        return this.name;
    }

    protected long getDamage() {
        return this.damage;
    }

    protected void setId() {
        this.id = this.getId();
    }

    protected boolean setName(Scanner in) {
        String s = "";
        boolean err = false;

        while (true) {
            System.out.println("Create New Weapon!!!");

            if (err) {
                System.out.println("'" + s + "' invalid!");
            }

            System.out.print("Weapon Name: ");
            s = in.nextLine().trim().replaceAll("\\s+", " ");

            if (s.equalsIgnoreCase("c")) {
                return false;
            }

            if (s.length() == 0) {
                err = true;
                System.out.println("Invalid Name!!!");
                continue;
            }

            this.name = s;
            return true;
        }
    }

    protected boolean setDamage(Scanner in) {
        String s = "";
        boolean err = false;

        while (true) {
            System.out.println("Create New Weapon!!!");

            if (err) {
                System.out.println("'" + s + "' invalid!");
            }

            System.out.print("Weapon Damage: ");
            s = in.nextLine().trim().replaceAll("\\s+", " ");

            if (s.equalsIgnoreCase("c")) {
                return false;
            }

            try {
                this.damage = Long.parseLong(s);
                return true;
            } catch (NumberFormatException e) {
                err = true;
            }
        }
    }

    protected boolean create(Scanner in) {
        if (this.setName(in) && this.setDamage(in)) {
            this.setId();
            return true;
        }

        return false;
    };
}
