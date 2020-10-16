package vn.bank;

public class Staff extends User {
    Staff(String uid, String name, String username, String password) {
        super(uid, name, username, password, Role.STAFF);
    }
}
