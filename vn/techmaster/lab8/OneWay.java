package vn.techmaster.lab8;

public class OneWay extends Ticket {
    OneWay(Gate origin, double balance) {
        super(balance);
        this.setOrigin(origin);
    }

    @Override
    public String toString() {
        return "Gate: " + (this.getOrigin() != null ? this.getOrigin().getName() : "");
    }

    @Override
    public void updateValid() {
        this.setValid(false);
    }
}
