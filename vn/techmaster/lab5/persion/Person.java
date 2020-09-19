package vn.techmaster.lab5.persion;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Person {
    private boolean cancelConstructor;
    private static int count = 1;
    private int id;
    private String fullName; // limit 30
    private Gender gender;
    private LocalDate birthday;
    private String address; // limit 100

    private final String REG = "[a-zA-z àáãạảăắằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ]";

    // auto increment
    public static int getTotalId() {
        return count - 1;
    }

    // get auto id
    public static int getNewId() {
        return count++;
    }

    // getter
    public int getId() {
        return this.id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public Gender getGender() {
        return this.gender;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public String getAddress() {
        return this.address;
    }

    // setter
    public boolean setFullName(String fullName) {
        if (fullName.equalsIgnoreCase("c")) {
            cancelConstructor = true;
            return true;
        }

        if (Pattern.matches(REG + "{1,30}", fullName)) {
            this.fullName = fullName;
            return true;
        }

        System.out.println("\n'" + fullName + "' không hợp lệ!!!\n");
        return false;
    }

    public boolean setGender(String gender) {
        if (gender.equalsIgnoreCase("c")) {
            cancelConstructor = true;
            return true;
        }

        if (Pattern.matches("[0-9]{1,}", gender)) {
            for (Gender g : Gender.values()) {
                if (Integer.parseInt(gender) == g.get()) {
                    this.gender = g;
                    return true;
                }
            }
        }

        System.out.println("\n'" + gender + "' không hợp lệ!!!\n");
        return false;
    }

    public boolean setBirthday(String birthday) {
        if (birthday.equalsIgnoreCase("c")) {
            cancelConstructor = true;
            return true;
        }

        if (Pattern.matches("[0-9]{2} [0-9]{2} [0-9]{4}", birthday)) {
            String[] arr = birthday.split(" ");

            try {
                this.birthday = LocalDate.of(Integer.parseInt(arr[2]), Integer.parseInt(arr[1]),
                        Integer.parseInt(arr[0]));

                return true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println("\n'" + birthday + "' không hợp lệ!!!\n");
        return false;
    }

    public boolean setAddress(String address) {
        if (address.equalsIgnoreCase("c")) {
            cancelConstructor = true;
            return true;
        }

        if (Pattern.matches(".{1,100}", address)) {
            this.address = address;
            return true;
        }

        System.out.println("\n'" + address + "' không hợp lệ!!!\n");
        return false;
    }

    public boolean setPerson(Scanner in) {
        System.out.println("\nTạo hồ sơ cá nhân mới!!! ID: " + getTotalId() + "\n");
        System.out.println("Nhập 'c' để hủy bỏ.\n");

        while (!cancelConstructor) {
            System.out.print("Họ tên (tối đa 30 ký tự, không chứa số và ký tự đặc biệt): ");
            if (setFullName(in.nextLine().trim().replaceAll("\\s+", " "))) {
                break;
            }
        }

        System.out.printf(!cancelConstructor ? "\n" : "");

        while (!cancelConstructor) {
            System.out.print("Giới tính (Số - 1 MALE, 2 FERMALE, 3 OTHER): ");
            if (setGender(in.nextLine().trim().replaceAll("\\s+", " "))) {
                break;
            }
        }

        System.out.printf(!cancelConstructor ? "\n" : "");

        while (!cancelConstructor) {
            System.out.print("Ngày sinh (DD MM YYYY): ");
            if (setBirthday(in.nextLine().trim().replaceAll("\\s+", " "))) {
                break;
            }
        }

        System.out.printf(!cancelConstructor ? "\n" : "");

        while (!cancelConstructor) {
            System.out.print("Địa chỉ (tối đa 100 ký tự): ");
            if (setAddress(in.nextLine().trim().replaceAll("\\s+", " "))) {
                break;
            }
        }

        return !cancelConstructor;
    }

    {
        cancelConstructor = false;
    }

    Person(Scanner in) {
        if (!setPerson(in)) {
            throw new IllegalArgumentException("\n!!! Đã hủy hàm tạo");
        }

        this.id = getNewId();
    }

    void hello() {
        System.out.printf("%-3s %-30s %-8s %-12s %s\n", getId(), getFullName(), getGender(), getBirthday(),
                getAddress());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Person[] persons = new Person[100];

        try {
            persons[Person.getTotalId()] = new Person(in);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            persons[Person.getTotalId()] = new Person(in);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.printf("%-3s %-30s %-8s %-12s %s\n", "ID", "Full Name", "Gender", "Birthday", "Address");
        for (Person p : persons) {
            if (p == null) {
                break;
            }
            p.hello();
        }
    }
}
