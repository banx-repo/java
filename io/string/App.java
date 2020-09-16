package io.string;

public class App {
    String concatString() {
        String s = "Hello";
        for (int i = 0; i < 20000; i++) {
            s = s + " World";
        }
        return s;
    }

    StringBuffer concatBuffer() {
        StringBuffer s = new StringBuffer("Hello");
        for (int i = 0; i < 20000; i++) {
            s.append(" World");
        }
        return s;
    }

    StringBuilder concatBuilder() {
        StringBuilder s = new StringBuilder("Hello");
        for (int i = 0; i < 20000; i++) {
            s.append(" World");
        }
        return s;
    }

    public static void main(String[] args) {
        App app = new App();

        long start = System.currentTimeMillis();
        app.concatString();
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        app.concatBuffer();
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        app.concatBuilder();
        System.out.println(System.currentTimeMillis() - start);
    }
}