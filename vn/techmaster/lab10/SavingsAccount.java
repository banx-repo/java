package vn.techmaster.lab10;

public class SavingsAccount extends Account {
    private double yearlyInterestRate;

    SavingsAccount(long id, double value, double yearlyInterestRate) {
        super(id, value);
        setYearlyInterestRate(yearlyInterestRate);
    }

    private void setYearlyInterestRate(double yearlyInterestRate) {
        this.yearlyInterestRate = yearlyInterestRate;
    }

    @Override
    public double calMIR() {
        return (getValue() * getYearlyInterestRate() / 12);
    }

    private double getYearlyInterestRate() {
        return yearlyInterestRate;
    }
}
