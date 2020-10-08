package vn.techmaster.lab9;

public class Employee implements Comparable<Employee> {
    private static int count = 1;
    int id;
    String name;

    Employee(String name) {
        this.id = count++;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee " + id + "'s name is " + name;
    }

    @Override
    public int compareTo(Employee o) {
        if (this.name.compareTo(o.name) != 0) {
            return this.name.compareTo(o.name);
        } else {
            return this.id - o.id;
        }
    }
}
