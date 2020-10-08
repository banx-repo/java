package vn.techmaster.lab10;

public class Main {
    public static void main(String[] args) {
        Account a = new SavingsAccount(163225606, 100000, 5.0);

        a.addValue(100000);

        a.subValue(1000);

        a.calMIR();

        System.out.println(a.calMIR());
    }
}
