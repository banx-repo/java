package vn.bank;

public class Help {
    public void print(User user) {
        if (user == null) {
            System.out.println("Đăng nhập: signin -u username -p password");

        } else if (user.getRole() == Role.CUSTOMER) {
            System.out.println("Nhập 'signout' để đăng xuất");
            System.out.println("Xem tài khoản thanh toán: show -p");
            System.out.println("Xem tài khoản tiết kiệm: show -s");
            System.out.println("Rút tiền từ tài khoản: withdraw -v value");
            System.out.println("Mở tài khoản tiết kiệm: saving -v value -pr period");
            System.out.println("Lĩnh tiền lãi từ tài khoản tiết kiệm: getinterest -aid aid");
            System.out.println("Tất toán tài khoản tiết kiệm: closesaving -aid aid");

        } else if (user.getRole() == Role.STAFF) {
            System.out.println("Nhập 'signout' để đăng xuất");
            System.out.println("Tạo tài khoản: create -uid uid -n name -u username -p password");
            System.out.println("Xem tài khoản thanh toán: show -p -uid uid");
            System.out.println("Xem tài khoản tiết kiệm: show -s -uid uid");
            System.out.println("Gửi tiền vào tài khoản: deposit -uid uid -v value");
            System.out.println("Rút tiền từ tài khoản: withdraw -uid uid -v value");
            System.out.println("Mở tài khoản tiết kiệm: saving -uid id -v value -ir interestRate -pr period");
            System.out.println("Lĩnh tiền lãi từ tài khoản tiết kiệm: getinterest -uid uid -aid aid");
            System.out.println("Tất toán tài khoản tiết kiệm: closesaving -uid uid -aid aid");
        }
    }
}
