package vn.test.employees;

import java.time.LocalDate;
import java.util.ArrayList;

public class HumanResource {
    private ArrayList<Employee> employees = new ArrayList<>();

    public Employee create(String name, LocalDate date) {
        Employee e = new Employee(name, date);
        employees.add(e);
        return e;
    }

    public Employee read(Integer id) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                return e;
            }
        }

        return null;
    }

    public Employee update(Integer id, String name, LocalDate date) {
        Employee employee = null;

        for (Employee e : employees) {
            if (e.getId() == id) {
                employee = e;
                break;
            }
        }

        if (employee == null) {
            return null;
        }

        if (name != null && date != null) {
            employee.update(name, date);
        } else if (name != null) {
            employee.update(name);
        } else {
            employee.update(date);
        }

        return employee;
    }

    public Employee delete(Integer id) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                employees.remove(e);
                return e;
            }
        }

        return null;
    }

    public void printAll() {
        Employee.printHeader();
        for (Employee e : employees) {
            System.out.println(e);
        }

        System.out.println("Total " + employees.size());
    }
}
