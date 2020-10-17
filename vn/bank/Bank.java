package vn.bank;

import java.util.ArrayList;

public class Bank {
    private float interestRate = 7.0F;
    private ArrayList<PaymentAccount> paymentAccounts = new ArrayList<>();
    private ArrayList<SavingAccount> savingAccounts = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Staff> staffs = new ArrayList<>();
    private Load loader = new Load(paymentAccounts, savingAccounts, customers, staffs);
    private Save saver;

    Bank() {
        this.init();
        if (staffs.size() <= 0) {
            staffs.add(new Staff("1", "Administrator", "admin", "admin"));
            this.save();
        }
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    private void init() {
        loader.start();

        synchronized (loader) {
            try {
                System.out.println("Loading data...\nPlease wait a second!");
                loader.wait();
                System.out.println("Done...\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void save() {
        this.saver = new Save(paymentAccounts, savingAccounts, customers, staffs);
        saver.start();
    }

    public User signin(String username, String password) {
        for (Customer c : customers) {
            if (c.getUsername().equals(username) && c.getPassword().equals(password)) {
                System.out.println("Đăng nhập thành công!");
                return c;
            }
        }

        for (Staff s : staffs) {
            if (s.getUsername().equals(username) && s.getPassword().equals(password)) {
                System.out.println("Đăng nhập thành công");
                return s;
            }
        }

        System.out.println("Tài khoản hoặc mật khẩu không đúng!");
        return null;
    }

    public boolean exists(String uid, String username) {
        for (Customer c : customers) {
            if (c.getUID().equals(uid) || c.getUsername().equals(username)) {
                return true;
            }
        }

        return false;
    }

    public void addCustomer(Customer c) {
        this.customers.add(c);
        this.paymentAccounts.add(c.getPaymentAccount());
    }

    public void addSavingAccount(SavingAccount sa) {
        this.savingAccounts.add(sa);
    }

    public Customer getCustomer(String uid) {
        for (Customer c : customers) {
            if (c.getUID().equals(uid)) {
                return c;
            }
        }

        return null;
    }

    public void closeSavingAccount(String uid, String aid) {
        Customer customer = null;
        SavingAccount account = null;

        for (Customer c : customers) {
            if (c.getUID().equals(uid)) {
                customer = c;
                break;
            }
        }

        if (customer == null) {
            System.out.println("Tài khoản không tồn tại");
            return;
        }

        for (SavingAccount a : customer.getSavingAccounts()) {
            if (a.getAID().equals(aid)) {
                account = a;
            }
        }

        if (account == null) {
            System.out.println("Số tài khoản tiết kiệm không đúng");
            return;
        }

        customer.getPaymentAccount().deposit(account.finalSettlement());
        customer.getSavingAccounts().remove(account);
        account.setState("close");
        System.out.println("Tất toán tài khoản tiết kiệm thành công");
    }
}