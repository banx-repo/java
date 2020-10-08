package vn.techmaster.lab8;

public abstract class Ticket {
    private static int count = 0;
    private int id;
    private Gate origin = null;
    private boolean valid;
    private double balance;

    // static
    public static int total() {
        return count;
    }

    // get
    private int newId() {
        return count++;
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public Gate getOrigin() {
        return this.origin;
    }

    public boolean isValid() {
        return this.valid;
    };

    // set
    private void setId(int id) {
        this.id = id;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void setOrigin(Gate origin) {
        this.origin = origin;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    };

    // constructor
    Ticket(double balance) {
        this.setId(this.newId());
        this.setValid(true);
        this.setBalance(balance);
    }

    // method
    @Override
    public String toString() {
        return "Gate: " + (origin != null ? origin.getName() : "");
    }

    public void changeBalance(double value) {
        System.out.println("Do not support this method!");
    }

    public abstract void updateValid();
}
