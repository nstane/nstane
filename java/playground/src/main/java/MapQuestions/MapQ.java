package MapQuestions;

import java.time.LocalDate;
import java.util.*;

import static java.lang.System.out;

public class MapQ {
    private int i = 20;

    private static class InnerClass {

        public void get() {
            //out.println(i); non static can't access in static class or method
        }
    }
    public static void main(String[] args) {
        treeMap();
        //run();
    }

    /**
     * Object/class to be added in tree set or map should implements Comparable
     */
    private static void treeMap() {
        Address address = new Address("","","");
        TreeSet<Employee> set = new TreeSet<>();
        set.add(new Employee("Narender", 123, LocalDate.now().minusYears(1), address));
        set.add(new Employee("Akshay", 788, LocalDate.now().minusYears(2), address));
        set.add(new Employee("Harry", 12333, LocalDate.now().minusYears(1), address));
        set.add(new Employee("Nainu", 4356, LocalDate.now().minusYears(5), address));
        set.add(new Employee("Sita", 676, LocalDate.now().minusYears(7), address));
        set.add(new Employee("Ram", 34324, LocalDate.now().minusYears(1), address));
        out.println(set);
    }

    private static void run() {
        Address address = new Address("", "", "");
        Map<Employee, Employee> map = new HashMap();

        Employee employee = new Employee("Narender", 123, LocalDate.now().minusYears(1), address);

        Employee employee2 = new Employee("Narender", 123, LocalDate.now().minusYears(1), address);

        map.put(employee, employee);

        out.println(map.get(employee2));


        //employee.getJoiningDate().plusYears(2);

        /*
        if don't implement hashCode this will return null
        because every time a new hash code will get generated this will cause memory leak

        if you return same hash for all and no equals method then also it return null
        because no equals method so not able to reach to exact location

        not if equals always true and hasCode == 1 return same then it will keep override element.
        */

        map.put(employee2, employee2);


        out.println(employee.hashCode() ==employee2.hashCode());

        out.println(employee.equals(employee2));

        out.println(map.size());

        out.println(Objects.equals(employee, employee2));

        out.println(Objects.deepEquals(employee, new Employee("ttt", 2222, LocalDate.now().minusYears(2), address)));

        out.println(Objects.equals(Integer.valueOf(12), Integer.valueOf(122)));

        out.println(Objects.deepEquals(employee, new Employee("ttt", 2222, LocalDate.now().minusYears(2), address)));
    }
}
