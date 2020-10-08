package vn.techmaster.lab10;

public class CurrentPlusAccount extends Account {
    private double fixedFee;
    private double minValue;
    private double yearlyInterestRate;

    CurrentPlusAccount(long id, double value, double fixedFee, double minValue, double yearlyInterestRate) {
        super(id, value);
        setFixedFee(fixedFee);
        setYearlyInterestRate(yearlyInterestRate);
        setMinValue(minValue);
    }

    @Override
    public void subValue(double value) throws IllegalArgumentException {
        super.subValue(value + getFixedFee());
    }

    private void setFixedFee(double fixedFee) {
        this.fixedFee = fixedFee;
    }

    private void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    private void setYearlyInterestRate(double yearlyInterestRate) {
        this.yearlyInterestRate = yearlyInterestRate;
    }

    public double getFixedFee() {
        return fixedFee;
    }

    public double getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    public double getMinValue() {
        return minValue;
    }
}
