package vn.techmaster.lab9;

import java.util.ArrayList;

public class HumanResource {
    ArrayList<Employee> employees;

    HumanResource() {
        employees = new ArrayList<>();
    }

    Employee add(Employee e) {
        employees.add(e);
        return e;
    }
}
