package vn.techmaster.lab9;

public class Security extends Employee {
    Security(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Security - " + super.toString();
    }
}
