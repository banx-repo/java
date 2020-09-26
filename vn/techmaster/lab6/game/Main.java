package vn.techmaster.lab6.game;

import java.util.Scanner;

import vn.techmaster.lab6.game.weapon.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Weapon weapon;
        Character character;

        try {
            weapon = new Sword(in);
            character = new Character(weapon);
            character.attack();
        } catch (IllegalArgumentException e) {
            System.out.println("Đã hủy tạo vũ khí!");
        }
    }
}
