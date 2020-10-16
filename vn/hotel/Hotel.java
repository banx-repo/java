package vn.hotel;

import java.util.ArrayList;

public class Hotel {
    String name;
    String address;
    ArrayList<Room> rooms;

    Hotel(String name, String address) {
        setName(name);
        setAddress(address);
    }

    public void setRooms() {
        rooms.add(new Room(10.0));
        rooms.add(new Room(15.0));
        rooms.add(new Room(5.0));
    }

    public User register(User user) {
        return null;
    }

    public User login(User user) {
        return null;
    }

    public boolean checkAccount(User user) {
        return false;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
