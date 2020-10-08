package vn.techmaster.lab10;

public class Account {
    private long id;
    private double value;

    protected Account(long id, double value) {
        setId(id);
        setValue(value);
    }

    public long getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    private void setId(long id) {
        this.id = id;
    }

    private void setValue(double value) {
        this.value = value;
    }

    public double calMIR() {
        return 0.0;
    }

    public void addValue(double value) {
        setValue(getValue() + value);
    }

    public void subValue(double value) throws IllegalArgumentException {
        if (getValue() < value) {
            throw new IllegalArgumentException("Not enough money!!!");
        } else {
            setValue(getValue() - value);
        }
    }
}
