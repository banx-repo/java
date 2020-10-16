package vn.hotel;

public class Room {
    private static int roomId = 1;
    private int id;
    private double price;
    private boolean isAvailable;

    private int newId() {
        return roomId++;
    }

    Room(double price) {
        setId(this.newId());
        setPrice(price);
    }

    public Room view() {
        return this;
    }

    // public Room update() {}

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setId(int id) {
        this.id = id;
    }

    private void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void available() {
        this.setAvailable(true);
    }

    public void unavailable() {
        this.setAvailable(false);
    }
}
