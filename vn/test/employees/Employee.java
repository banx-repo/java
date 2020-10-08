package vn.test.employees;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
    private static int total = 1;
    private int id;
    private String name;
    private LocalDate birthday;

    public static int getTotal() {
        return total - 1;
    }

    private int newId() {
        return total++;
    }

    public int getId() {
        return id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    private void setName(String name) {
        this.name = name;
    }

    Employee(String name, LocalDate date) {
        setId(newId());
        setName(name);
        setBirthday(date);
    }

    public static void printHeader() {
        System.out.println(String.format("%-3s %-10s %s", "ID", "Birthday", "Name"));
    }

    @Override
    public String toString() {
        String birthday = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(getBirthday());
        return String.format("%03d %10s %s", getId(), birthday, getName());
    }

    public void update(String name) {
        setName(name);
    }

    public void update(LocalDate date) {
        setBirthday(date);
    }

    public void update(String name, LocalDate date) {
        setName(name);
        setBirthday(date);
    }
}
