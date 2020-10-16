package vn.test;

public enum Option {
    ALL("all"), ID("-i"), NAME("-n"), BIRTHDAY("-b"), PHONE("-p"), EMAIL("-e");

    private String s;
    private static Option[] create = new Option[] { NAME, BIRTHDAY, EMAIL, PHONE };
    private static Option[] read = new Option[] { ALL, ID };
    private static Option[] update = new Option[] { ID, NAME, BIRTHDAY, PHONE };
    private static Option[] delete = new Option[] { ID };

    Option(String s) {
        this.s = s;
    }

    public String getOption() {
        return s;
    }

    public static boolean create(String s) {
        for (Option o : create) {
            if (o.getOption().equals(s)) {
                return true;
            }
        }

        return false;
    }

    public static boolean read(String s) {
        for (Option o : read) {
            if (o.getOption().equals(s)) {
                return true;
            }
        }

        return false;
    }

    public static boolean update(String s) {
        for (Option o : update) {
            if (o.getOption().equals(s)) {
                return true;
            }
        }

        return false;
    }

    public static boolean delete(String s) {
        for (Option o : delete) {
            if (o.getOption().equals(s)) {
                return true;
            }
        }

        return false;
    }
}
