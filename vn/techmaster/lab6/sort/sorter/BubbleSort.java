package vn.techmaster.lab6.sort.sorter;

import java.util.ArrayList;
import vn.techmaster.lab6.sort.Employee;

public class BubbleSort implements Sortable {
    public void sort(ArrayList<Employee> al) {
        Employee min;
        for (int i = 0; i < al.size() - 1; i++) {
            min = al.get(i);
            for (int j = i + 1; j < al.size(); j++) {
                if (min.id > al.get(j).id) {
                    al.set(i, al.get(j));
                    al.set(j, min);
                    min = al.get(i);
                }
            }
        }
    }
}
