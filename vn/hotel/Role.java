package vn.hotel;

public enum Role {
    USER(1), MEMBER(2), ADMIN(3);

    private Integer role;

    Role(Integer role) {
        this.role = role;
    }

    public Integer getRole() {
        return role;
    }
}
