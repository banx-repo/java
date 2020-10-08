package vn.techmaster.lab10;

public class CurrentAccount extends Account {
    private double fixedFee;

    CurrentAccount(long id, double value, double fixedFee) {
        super(id, value);
        setFixedFee(fixedFee);
    }

    @Override
    public void subValue(double value) throws IllegalArgumentException {
        super.subValue(value + getFixedFee());
    }

    public double getFixedFee() {
        return fixedFee;
    }

    private void setFixedFee(double fixedFee) {
        this.fixedFee = fixedFee;
    }
}
