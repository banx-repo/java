package vn.techmaster.lab6.sort.sorter;

import java.util.ArrayList;
import vn.techmaster.lab6.sort.Employee;

public class SelectionSort implements Sortable {
    public void sort(ArrayList<Employee> al) {
        Employee min;
        int index;
        for (int i = 0; i < al.size() - 1; i++) {
            min = al.get(i);
            index = i;

            for (int j = i + 1; j < al.size(); j++) {
                if (min.id < al.get(j).id) {
                    min = al.get(j);
                    index = j;
                }
            }

            if (index != i) {
                al.set(index, al.get(i));
                al.set(i, min);
            }
        }
    }
}
