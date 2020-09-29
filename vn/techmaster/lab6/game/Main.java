package vn.techmaster.lab6.game;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main extends Thread {
    static Character character;
    static final AtomicBoolean running = new AtomicBoolean(false);

    public void run() {
        running.set(true);

        while (running.get()) {
            character.attack();

            try {
                Thread.sleep((long) (character.getWeapon().getAttackSpeed() * 1000));
            } catch (InterruptedException e) {

            }
        }

        Thread.yield();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;

        Weapon sword = new Weapon("Sword", 999, 2F);
        Weapon bow = new Weapon("Bow", 666, 1.5F);
        Weapon dagger = new Weapon("Dagger", 333, 0.5F);

        character = new Character("Dark Knight");
        character.changeWeapon(sword);

        Main m = new Main();
        m.start();

        while (true) {
            s = in.next();

            if ("q".equalsIgnoreCase(s)) {
                System.out.println("Quit...");
                running.set(false);
                m.interrupt();
                break;
            }

            switch (s) {
                case "1":
                    if (character.getWeapon() != sword) {
                        System.out.println("Change weapon to Sword");
                        character.changeWeapon(sword);
                    }
                    break;
                case "2":
                    if (character.getWeapon() != bow) {
                        System.out.println("Change weapon to Bow");
                        character.changeWeapon(bow);
                    }
                    break;
                case "3":
                    if (character.getWeapon() != dagger) {
                        System.out.println("Change weapon to Dagger");
                        character.changeWeapon(dagger);
                    }
                    break;
            }
        }

        in.close();
    }
}
