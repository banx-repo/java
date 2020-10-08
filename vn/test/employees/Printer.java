package vn.test.employees;

public class Printer {
    public static String group = "  %s\n";
    public static String opt = "    %-20s%s\n";

    public static void printEmployee(Employee e, Integer id) {
        if (e == null) {
            System.out.println("No employee ID " + id);
        } else {
            Employee.printHeader();
            System.out.println(e);
        }
    }

    public static void help() {
        create();
        read();
        update();
        delete();
        quit();
    }

    public static void create() {
        System.out.println("Create new employee");
        System.out.printf(group, "add name=string date=dd/mm/yyyy");
        System.out.printf(opt, "name=string", "Name");
        System.out.printf(opt, "date=dd/mm/yyyy", "Date of birth");
    }

    public static void read() {
        System.out.println("Get employee's info");
        System.out.printf(group, "get all | id=number");
        System.out.printf(opt, "all", "All employees");
        System.out.printf(opt, "id=number", "Get by employee's ID");
    }

    public static void update() {
        System.out.println("Update employee's info");
        System.out.printf(group, "update id=number name=string date=dd/mm/yyyy");
        System.out.printf(opt, "id=number", "Get by employee's ID");
        System.out.printf(opt, "name=string", "Update employee's name");
        System.out.printf(opt, "date=dd/mm/yyyy", "Update employee's date of birth");
    }

    public static void delete() {
        System.out.println("Delete employee");
        System.out.printf(group, "delete id=number");
        System.out.printf(opt, "id=number", "Delete by employee's ID");
    }

    public static void quit() {
        System.out.printf("  %-12s%s\n", "quit", "Quit program");
    }
}
