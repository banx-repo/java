package vn.bank;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bank {
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

        System.out.println("Tài khoản hoặc mật khẩu không hợp lệ!");
        return null;
    }

    public void openAccount(String uid, String name, String username, String password) {
        for (Customer c : customers) {
            if (c.getUID().equals(uid) || c.getUsername().equals(username)) {
                System.out.println("ID hoặc tài khoản đã tồn tại!");
            }
        }

        Customer c = new Customer(uid, name, username, password);
        this.customers.add(c);
        PaymentAccount p = new PaymentAccount(uid);
        this.paymentAccounts.add(p);
        c.setPaymentAccount(p);
        System.out.println("Tạo tài khoản thành công!");
    }

    public void openSavingAccount(Customer c, long value, int period) {
        try {
            c.getPaymentAccount().withdraw(value);
            SavingAccount s = new SavingAccount(c.getUID() + (c.getSavingAccounts().size() + 1), c.getUID(), value,
                    period, LocalDate.now());
            c.setSavingAccounts(s);
            this.savingAccounts.add(s);
            System.out.println("Mở tài khoản tiết kiệm thành công.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void openSavingAccount(String uid, long balance, float interestRate, int period) {
        for (Customer c : customers) {
            if (c.getUID().equals(uid)) {
                String aid = c.getUID() + (c.getSavingAccounts().size() + 1);
                SavingAccount s = new SavingAccount(aid, uid, balance, interestRate, period, LocalDate.now());
                c.setSavingAccounts(s);
                this.savingAccounts.add(s);
                System.out.println("Mở tài khoản tiết kiệm thành công.");
                return;
            }
        }

        System.out.println("Chưa có tài khoản, yêu cầu mở tài khoản trước.");
        return;
    }

    public void showPaymentAccount(String uid) {
        for (PaymentAccount p : paymentAccounts) {
            if (p.getUID().equals(uid)) {
                PaymentAccount.title();
                p.details();
                return;
            }
        }

        System.out.println("Tài khoản không tồn tại!");
        return;
    }

    public void showSavingAccounts(String uid) {
        Boolean hasAccount = false;
        for (SavingAccount a : savingAccounts) {
            if (a.getUID().equals(uid)) {
                hasAccount = true;
                break;
            }
        }

        if (hasAccount) {
            SavingAccount.title();
            for (SavingAccount a : savingAccounts) {
                a.details();
            }
        } else {
            System.out.println("Chưa có tài khoản tiết kiệm nào!");
        }
    }

    public void deposit(String uid, long value) {
        for (PaymentAccount p : paymentAccounts) {
            if (p.getUID().equals(uid)) {
                p.deposit(value);
                System.out.println("Gửi tiền vào tài khoản thành công!");
                return;
            }
        }
        System.out.println("Nạp tiền thất bại, kiểm tra lại tài khoản.");
        return;
    }

    public void withdraw(String uid, long value) {
        for (PaymentAccount p : paymentAccounts) {
            if (p.getUID().equals(uid)) {
                try {
                    p.withdraw(value);
                    System.out.println("Rút tiền thành công!");
                    return;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
        }
        System.out.println("Rút tiền thất bại, kiểm tra lại số tài khoản.");
        return;
    }

    public void getInterest(String uid, String aid) {
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

        Double interest = account.getInterest();

        if (interest != null) {
            customer.getPaymentAccount().deposit(interest.longValue());
            System.out.println("Lĩnh tiền lãi oke");
        }
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