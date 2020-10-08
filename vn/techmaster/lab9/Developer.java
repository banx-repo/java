package vn.techmaster.lab9;

public class Developer extends Employee {
    Developer(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Developer - " + super.toString();
    }
}
