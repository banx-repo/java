package vn.test.demo;

public class Employee extends Person implements Codeable {
    String name;

    @Override
    void hello() {
        System.out.println("Hello, my name is " + name);
    }

    @Override
    public void speak() {
        System.out.println("I'm speaking...");
    }

    @Override
    public void code() {
        System.out.println("I'm coding...");
    }

    public static void main(String[] args) {
        Employee e = new Employee();
        e.hello();
        e.speak();
        e.code();
        e.blame();
        Speakable.whisper();
    }
}
