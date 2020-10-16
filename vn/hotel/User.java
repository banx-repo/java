package vn.hotel;

public class User {
    private String id;
    private String name;
    private String password;
    private String email;
    private String address;
    private String phone;
    private String cardNumber;

    Role role;

    User(String id, String name, String password, String email, String address, String phone, String cardNumber,
            Role role) {
        setId(id);
        setName(name);
        setPassword(password);
        setEmail(email);
        setAddress(address);
        setPhone(phone);
        setRole(role);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
