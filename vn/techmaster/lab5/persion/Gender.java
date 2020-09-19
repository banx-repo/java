package vn.techmaster.lab5.persion;

public enum Gender {
    MALE(1), FERMALE(2), OTHER(3);

    private int gender;

    Gender(int gender) {
        this.gender = gender;
    }

    int get() {
        return this.gender;
    }
}
