package vn.test.demo;

public class Dog implements Speakable {
    String name;
    int age;
    String color;

    @Override
    public void speak() {
        System.out.println("Gogogo...");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.speak();
    }
}