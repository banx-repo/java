package vn.techmaster.lab5.person;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Person {
    private static int count = 1;
    private static String pf = "%-3s %-20s %-10s %-12s %s\n";

    protected boolean cancelConstructor;
    private int id;
    private String fullName;
    private Gender gender;
    private LocalDate birthday;
    private String address;

    private final String REG = "[a-zA-z àáãạảăắằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ]";

    // auto increment
    public static int getTotalId() {
        return count - 1;
    }

    // get auto id
    private int getNewId() {
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
    private boolean setFullName(String fullName) {
        if (fullName.equalsIgnoreCase("c")) {
            cancelConstructor = true;
            return true;
        }

        if (Pattern.matches(REG + "{1,20}", fullName)) {
            this.fullName = fullName;
            return true;
        }

        System.out.println("'" + fullName + "' không hợp lệ!!!");
        return false;
    }

    private boolean setGender(String gender) {
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

        System.out.println("'" + gender + "' không hợp lệ!!!");
        return false;
    }

    private boolean setBirthday(String birthday) {
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

        System.out.println("'" + birthday + "' không hợp lệ!!!");
        return false;
    }

    private boolean setAddress(String address) {
        if (address.equalsIgnoreCase("c")) {
            cancelConstructor = true;
            return true;
        }

        if (Pattern.matches(".{1,100}", address)) {
            this.address = address;
            return true;
        }

        System.out.println("'" + address + "' không hợp lệ!!!");
        return false;
    }

    protected boolean create(Scanner in) {
        while (!cancelConstructor) {
            System.out.print("Họ tên (tối đa 20 ký tự, không chứa số và ký tự đặc biệt): ");
            if (setFullName(in.nextLine().trim().replaceAll("\\s+", " "))) {
                break;
            }
        }

        while (!cancelConstructor) {
            System.out.print("Giới tính (Số - 1 MALE, 2 FERMALE, 3 OTHER): ");
            if (setGender(in.nextLine().trim().replaceAll("\\s+", " "))) {
                break;
            }
        }

        while (!cancelConstructor) {
            System.out.print("Ngày sinh (DD MM YYYY): ");
            if (setBirthday(in.nextLine().trim().replaceAll("\\s+", " "))) {
                break;
            }
        }

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

    Person() {
    }

    Person(Scanner in) {
        System.out.println("Tạo hồ sơ cá nhân mới!");
        System.out.println("Nhập 'C' để hủy bỏ.");
        System.out.println("ID: " + (getTotalId() + 1));

        if (!create(in)) {
            throw new IllegalArgumentException("Đã hủy...");
        }

        this.id = getNewId();
    }

    /**
     * 
     * <pre>
     * ID    FullName  Gender  Birthday  Address
     * </pre>
     * 
     * <pre>
     * %-3s  %-20s     %-10s   %-12s     %s
     * </pre>
     * 
     */
    public void print() {
        System.out.printf(pf, getId(), getFullName(), getGender(), getBirthday(), getAddress());
    }
}
