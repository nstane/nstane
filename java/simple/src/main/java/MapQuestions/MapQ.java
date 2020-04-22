package MapQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.System.out;

public class MapQ {
    private int i = 20;

    private static class InnerClass {

        public void get() {
            //out.println(i); non static can't access in static class or method
        }
    }
    public static void main(String[] args) {

        run();
    }

    private static void run() {
        Map<Employee, String> map = new HashMap();

        Employee employee = new Employee("Narender", 123);

        Employee employee2 = new Employee("Narender", 123);

        map.put(employee, "Narender");

        out.println(map.get(employee2));

        /*
        if don't implement hashCode this will return null
        because every time a new hash code will get generated this will cause memory leak

        if you return same hash for all and no equals method then also it return null
        because no equals method so not able to reach to exact location

        not if equals always true and hasCode == 1 return same then it will keep override element.
        */

        map.put(employee2, "Narender");

        out.println(employee.hashCode() ==employee2.hashCode());

        out.println(employee.equals(employee2));

        out.println(map.size());

        out.println(Objects.equals(employee, employee2));

        out.println(Objects.deepEquals(employee, new Employee("ttt", 2222)));

        out.println(Objects.equals(Integer.valueOf(12), Integer.valueOf(122)));

        out.println(Objects.deepEquals(employee, new Employee("ttt", 2222)));
    }
}

class Employee {
    private final String name;
    private final double salary;
    public Employee(final String name, final int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        /*if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name);*/

        return true;
        // map or set will size of one if equals return always true and hashCode return same hash always
    }

    @Override
    public int hashCode() {
        return 1;//Objects.hash(name, salary);
    }
}
