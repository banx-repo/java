package vn.test.lambda;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Drawable {
    public void draw();
}

@FunctionalInterface
interface Sayable {
    public String say(String name);
}

@FunctionalInterface
interface Addable {
    public int add(int a, int b);
}

class Main {
    public static void main(String[] args) {
        int width = 10;

        Drawable d = () -> {
            System.out.println("Drawing " + width);
        };

        d.draw();

        Sayable sayable = (name) -> {
            return "Hello, " + name;
        };

        System.out.println(sayable.say("Ba"));

        // no return
        Addable addable = (a, b) -> a + b;
        System.out.println(addable.add(1, 3));

        List<String> list = new ArrayList<String>();
        list.add("Ba");
        list.add("Thu");
        list.forEach(s -> System.out.println(s));

        System.out.println((long) (0.5F * 1000));
    }
}
