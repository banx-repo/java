package vn.test.demo;

public interface Speakable {
    void speak();

    default void blame() {
        System.out.println("LoL");
    }

    static void whisper() {
        System.out.println("Whisper...");
    }
}
