package streams;

import java.util.*;
import java.util.stream.*;

public class Employee {
    private String name;
    private String department;

    public Employee(String name, String department){
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

class EmpMain{
    public static void main(String[] args) {
        List<Employee> employee = Arrays.asList(
                new Employee("Alice", "IT"),
                new Employee("Bob", "HR"),
                new Employee("Charlie", "IT"),
                new Employee("David", "HR"),
                new Employee("Eva", "Finance")
        );


        Map<String, List<Employee>> employeeByDept = employee.stream()
                .collect(Collectors.groupingBy(n-> n.getDepartment()));

        System.out.println("Employees by Department:");
        employeeByDept.forEach((dept, empList) -> {
            System.out.println("Department: " + dept);
            empList.forEach(emp -> System.out.println("   " + emp.getName()));
        });
    }
}
