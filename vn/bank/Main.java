package vn.bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        User user = null;
        Help help = new Help();
        Parser parser = new Parser();
        Scanner in = new Scanner(System.in);
        String s;
        String prompt = "$ ";

        System.out.println("Ngân hàng nhà nước Việt Nam");
        System.out.println("Gõ 'help' để xem hướng dẫn thao cmn tác");
        System.out.println("Gõ 'quit' để thoát");

        while (true) {
            System.out.print(prompt);
            s = in.nextLine().trim().toLowerCase().replaceAll("\\s+", " ");

            if ("".equals(s)) {
                continue;
            }

            if ("quit".equals(s)) {
                break;
            }

            if ("help".equals(s)) {
                help.print(user);
                continue;
            }

            String command = parser.command(s);

            if (command == null) {
                continue;
            }

            String uid;
            String aid;
            String name;
            String username;
            String password;
            String value;
            String period;
            String rate;
            String show;

            switch (command) {
                case "signin":
                    if (user != null) {
                        System.out.println("Unauthorized");
                        break;
                    }

                    username = parser.username(s);
                    password = parser.password(s);

                    if (username != null && password != null) {
                        user = bank.signin(username, password);
                    }

                    break;

                case "signout":
                    if (user == null) {
                        System.out.println("Unauthorized");
                        break;
                    }

                    user = null;
                    System.out.println("Đăng xuất thành công");
                    break;

                case "create":
                    if (user == null || user.getRole() == Role.CUSTOMER) {
                        System.out.println("Unauthorized");
                        break;
                    }

                    uid = parser.uid(s);
                    name = parser.name(s);
                    username = parser.username(s);
                    password = parser.password(s);

                    if (uid != null && name != null && username != null && password != null) {
                        String[] temp = name.split(" ");

                        for (int i = 0; i < temp.length; i++) {
                            temp[i] = temp[i].substring(0, 1).toUpperCase() + temp[i].substring(1);
                        }

                        name = String.join(" ", temp);
                        bank.openAccount(uid, name, username, password);
                        bank.save();
                    }

                    break;

                case "show":
                    if (user == null) {
                        System.out.println("Unauthorized");
                        break;
                    }

                    show = parser.show(s);

                    if (show == null) {
                        System.out.println("Syntax error");
                        break;
                    }

                    if (user.getRole() == Role.CUSTOMER) {
                        Customer customer = (Customer) user;
                        if ("-s".equals(show)) {
                            customer.showSavingAccounts();
                        } else {
                            customer.showPaymentAccount();
                        }
                    } else {
                        uid = parser.uid(s);

                        if (uid == null) {
                            System.out.println("Syntax error");
                            break;
                        }

                        if ("-s".equals(show)) {
                            bank.showSavingAccounts(uid);
                        } else {
                            bank.showPaymentAccount(uid);
                        }
                    }

                    break;

                case "deposit":
                    if (user == null || user.getRole() == Role.CUSTOMER) {
                        System.out.println("Unauthorized");
                        break;
                    }

                    uid = parser.uid(s);
                    value = parser.value(s);

                    if (uid != null && value != null) {
                        bank.deposit(uid, Long.parseLong(value));
                        bank.save();
                    }

                    break;

                case "withdraw":
                    if (user == null) {
                        System.out.println("Unauthorized");
                        break;
                    }

                    if (user.getRole() == Role.CUSTOMER) {
                        Customer c = (Customer) user;
                        value = parser.value(s);
                        c.withdraw(Long.parseLong(value));
                        bank.save();
                    } else {
                        uid = parser.uid(s);
                        value = parser.value(s);

                        if (uid != null && value != null) {
                            bank.withdraw(uid, Long.parseLong(value));
                            bank.save();
                        }
                    }

                    break;

                case "saving":
                    if (user == null) {
                        System.out.println("Unauthorized");
                        break;
                    }

                    if (user.getRole() == Role.CUSTOMER) {
                        value = parser.value(s);
                        period = parser.period(s);
                        if (value != null && period != null) {
                            Customer c = (Customer) user;
                            bank.openSavingAccount(c, Long.parseLong(value), Integer.parseInt(period));
                            bank.save();
                        }

                        break;
                    }

                    uid = parser.uid(s);
                    value = parser.value(s);
                    period = parser.period(s);
                    rate = parser.rate(s);

                    if (uid != null && value != null && period != null && rate != null) {
                        bank.openSavingAccount(uid, Long.parseLong(value), Float.parseFloat(rate),
                                Integer.parseInt(period));
                        bank.save();
                    }

                    break;

                case "getinterest":
                    if (user == null) {
                        System.out.println("Unauthorized");
                        break;
                    }

                    if (user.getRole() == Role.CUSTOMER) {
                        aid = parser.aid(s);
                        if (aid != null) {
                            Customer c = (Customer) user;
                            c.getInterest(aid);
                            bank.save();
                        }
                        break;
                    } else {
                        uid = parser.uid(s);
                        aid = parser.aid(s);

                        if (uid != null && aid != null) {
                            bank.getInterest(uid, aid);
                            bank.save();
                        }
                    }

                    break;

                case "closesaving":
                    if (user == null) {
                        System.out.println("Unauthorized");
                        break;
                    }

                    if (user.getRole() == Role.CUSTOMER) {
                        Customer c = (Customer) user;
                        aid = parser.aid(s);
                        
                        if (aid != null) {
                            c.closeSavingAccount(aid);
                            bank.save();
                        }
                    } else {
                        uid = parser.uid(s);
                        aid = parser.aid(s);

                        if (uid != null && aid != null) {
                            bank.closeSavingAccount(uid, aid);
                            bank.save();
                        }
                    }

                    break;

                default:
                    System.out.println("Lệnh '" + command + "' không hợp lệ!");
            }
        }
        in.close();
    }
}
