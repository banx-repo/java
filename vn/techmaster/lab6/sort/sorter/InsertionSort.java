package vn.techmaster.lab6.sort.sorter;

import java.util.ArrayList;
import vn.techmaster.lab6.sort.Employee;

public class InsertionSort implements Sortable {
    public void sort(ArrayList<Employee> al) {
        Employee min;
        for (int i = 1; i < al.size(); i++) {
            min = al.get(i);

            int j = i - 1;
            while ((j > -1) && (al.get(j).id < min.id)) {
                al.set(j + 1, al.get(j));
                j--;
            }

            al.set(j + 1, min);
        }
    }
}
