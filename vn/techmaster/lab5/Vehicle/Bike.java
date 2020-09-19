package vn.techmaster.lab5.Vehicle;

public class Bike extends Vehicle {
    int speed = 1000;

    Bike() {
        System.out.println("Bike is create");
    }

    void display() {
        System.out.println("Super Speed: " + super.speed);
        System.out.println("Bike Speed: " + this.speed);
    }

    void hello() {
        System.out.println("Bike LoL");
    }

    void superHello() {
        super.hello();
    }

    public static void main(String[] args) {
        Bike b = new Bike();
        b.display();
        b.hello();
        b.superHello();
    }
}
