package streams;

import java.util.*;
import java.util.stream.*;

public class Employee {
    private String name;
    private String department;
    private int salary;

    public Employee(String name, String department, int salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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
                "salary=" + salary +
                '}';
    }
}

class EmpMain {
    public static void main(String[] args) {
        List<Employee> employee = Arrays.asList(
                new Employee("Alice", "IT", 4500),
                new Employee("Bob", "HR", 4000),
                new Employee("Charlie", "IT", 5600),
                new Employee("David", "HR", 3800),
                new Employee("Eva", "Finance", 4000)
        );


        //Group employees by department using streams.
        Map<String, List<Employee>> employeeByDept = employee.stream()
                .collect(Collectors.groupingBy(n -> n.getDepartment()));

        System.out.println("Employees by Department:");
        employeeByDept.forEach((dept, empList) -> {
            System.out.println("Department: " + dept);
            empList.forEach(emp -> System.out.println("   " + emp.getName()));
        });


        //Find employees with salary greater than X using streams.
        List<Employee> empSal = employee.stream()
                .filter(n -> n.getSalary() > 4000)
                .collect(Collectors.toList());
        System.out.println("Employees with salary greater than 4000: " + empSal);

        //Find the highest-paid employee using streams.
        Optional<Employee> highestPaid = employee.stream()
                .max(Comparator.comparingInt(n-> n.getSalary()));
        highestPaid.ifPresentOrElse(value -> System.out.println("Highest Paid: " + value.getName() + " , " + value.getSalary()), ()-> System.out.println("Not found"));

        //Find the average salary of employees using streams.
        OptionalDouble avgSal = employee.stream()
                .mapToDouble(n->n.getSalary())
                .average();
        avgSal.ifPresentOrElse(value-> System.out.println("Average Salary: " + value), () -> System.out.println("Not found"));

        //Group employees by department.
        Map<String, List<Employee>> empDpt = employee.stream()
                .collect(Collectors.groupingBy(n->n.getDepartment()));

        empDpt.forEach((department, empList) -> {
            System.out.println("Department: " + department);
            empList.forEach(emp -> System.out.println("  " + emp.getName() + " - " + emp.getSalary()));
        });


        //Count employees in each department.
        Map<String, Long> empCountDept = employee.stream()
                .collect(Collectors.groupingBy(n->n.getDepartment(), Collectors.counting()));  //Collectors.counting() returns Long.

        empCountDept.forEach((department, count)->{
            System.out.println("Department: " + department + " , Count: " + count);
        });


        //Sort employees by salary.
        List<Employee> sortBySal = employee.stream()
                .sorted((a,b) -> Integer.compare(a.getSalary(),b.getSalary()))
                .collect(Collectors.toList());
        sortBySal.forEach(emp -> System.out.println(emp.getName() + " - " + emp.getSalary()));


        //Find employee with minimum salary.
        Optional<Employee> lowestPaid = employee.stream()
                .min(Comparator.comparingInt(n-> n.getSalary()));
        lowestPaid.ifPresentOrElse(n-> System.out.println("Lowest paid: " + n.getName() + " - " + n.getSalary()), () -> System.out.println("Not present"));


        //Find the second highest salary employee.
        Optional<Employee> secondHighest = employee.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();
        secondHighest.ifPresentOrElse(n-> System.out.println("Second highest salary: " + n.getName() + " - " + n.getSalary()), ()-> System.out.println("Not present"));


        //Find all employee names using map().
        List<String> enames = employee.stream()
                .map(n->n.getName())
                .collect(Collectors.toList());
        enames.forEach(name -> System.out.println(name));


        // Increase salary of all employees by 10% using streams.
        List<Employee> incrementSal = employee.stream()
                .map(emp -> {
                    emp.setSalary(emp.getSalary() * 110 / 100); // 10% increase
                    return emp;                                // return SAME object
                })
                .collect(Collectors.toList());
        incrementSal.forEach(n-> System.out.println("New salary " + n.getName() + " - " + n.getSalary()));

    }
}
