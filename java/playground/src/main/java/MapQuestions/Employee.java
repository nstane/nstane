package MapQuestions;

import java.time.LocalDate;
import java.util.Objects;

public final class Employee {
    private final String name;
    private final double salary;
    private final LocalDate joiningDate;
    private final Address address;

    public Employee(final String name, final double salary, LocalDate joiningDate, Address address) {
        this.name = name;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate.plusDays(0);
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                name.equals(employee.name) &&
                joiningDate.equals(employee.joiningDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}
