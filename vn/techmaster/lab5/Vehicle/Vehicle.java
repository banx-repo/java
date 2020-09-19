package vn.techmaster.lab5.Vehicle;

public class Vehicle {
    int speed = 100;

    Vehicle() {
        System.out.println("Vehicle is create");
    }

    void hello() {
        System.out.println("Vehicle LoL");
    }

    Vehicle get() {
        return this;
    }
}
