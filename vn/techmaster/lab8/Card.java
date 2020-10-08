package vn.techmaster.lab8;

public class Card extends Ticket {
    // constructor
    Card(double balance) {
        super(balance);
    }

    // method
    @Override
    public void changeBalance(double value) {
        this.setBalance(this.getBalance() + value);
    }

    @Override
    public void updateValid() {
        this.setValid(this.getBalance() > 0);
    }
}
