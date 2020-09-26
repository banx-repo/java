package vn.techmaster.Lab8;

public class Card extends Ticket {
    private double _balance;

    double getBalance() {
        return this._balance;
    }

    boolean isAtive() {
        return this._balance <= 0;
    }

    Card(double balance) {
        this._balance = balance;
    }
}
