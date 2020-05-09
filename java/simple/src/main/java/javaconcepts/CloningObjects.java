package javaconcepts;


import MapQuestions.Address;
import MapQuestions.Employee;

import java.time.LocalDate;
import java.util.Objects;

public class CloningObjects {

    public static void main(String[] args) {
        Address address = new Address("S1","HR","IND");
        Employee emp = new Employee("Narender", 233, LocalDate.now(), address);

        Employee empClone = new Employee(emp.getName(), emp.getSalary(), emp.getJoiningDate(), emp.getAddress());

        System.out.println(Objects.equals(empClone, emp));

        System.out.println(Objects.deepEquals(empClone, emp));

        System.out.println(empClone == emp);

        System.out.println(empClone.equals(emp));


    }
}
