package vn.techmaster.lab4;

public class Room {
    private static int count = 1;
    private int id;
    private String name;
    private String address;

    Room(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    static int getNewId() {
        return count++;
    }

    static int getTotal() {
        return count - 1;
    }

    int getId() {
        return this.id;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getAddress() {
        return this.address;
    }

    void setAddress(String address) {
        this.address = address;
    }
}
