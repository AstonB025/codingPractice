package interviewStreams;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

class Employees {
    private int id;
    private String name;
    private String department;
    private int age;
    private double salary;
    private LocalDate hireDate;

    Employees(int id, String name, String department, int age, double salary, LocalDate hireDate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public LocalDate getHireDate() { return hireDate; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                '}';
    }
}



public class EmployeesClassRelated {
    public static void main(String[] args) {


        // Employees List
        List<Employees> employeesList = Arrays.asList(
                new Employees(1, "Alex", "IT", 33, 75000.00, LocalDate.of(2023, 6, 15)),
                new Employees(2, "Brian", "IT", 30, 66000.45, LocalDate.of(2022, 8, 25)),
                new Employees(3, "Charles", "HR", 45, 82000.00, LocalDate.of(2020, 3, 10)),
                new Employees(4, "Diana", "Finance", 29, 90000.00, LocalDate.of(2024, 1, 5)),
                new Employees(5, "Eve", "Finance", 41, 88000.00, LocalDate.of(2019, 11, 20)),
                new Employees(6, "Alex", "HR", 38, 72000.00, LocalDate.of(2021, 5, 18)),   // duplicate name
                new Employees(7, "Frank", "IT", 26, 60000.00, LocalDate.of(2024, 7, 1)),
                new Employees(8, "Grace", "Marketing", 35, 70000.00, LocalDate.of(2022, 2, 14)),
                new Employees(9, "Helen", "Marketing", 42, 78000.00, LocalDate.of(2018, 9, 30)),
                new Employees(10, "Brian", "Finance", 34, 95000.00, LocalDate.of(2023, 10, 12)) // duplicate name
        );

        System.out.println("___________________________________________________");
        // 1. Find employees with salary greater than X
        double X = 80000;
        List<Employees> empSalGreater = employeesList.stream()
                .filter(emp -> emp.getSalary() > X)
                .collect(Collectors.toList());
        System.out.println("Employees with salary > " + X + ": " + empSalGreater);

        System.out.println("___________________________________________________");
        // 2. Find the highest-paid employee
        Optional<Employees> empHighest = employeesList.stream()
                .max(Comparator.comparingDouble(Employees::getSalary));
        empHighest.ifPresentOrElse(
                e -> System.out.println("Highest-paid employee: " + e.getName()),
                () -> System.out.println("Not found")
        );

        System.out.println("___________________________________________________");
        // 3. Average salary
        OptionalDouble avgSal = employeesList.stream()
                .mapToDouble(Employees::getSalary)
                .average();
        avgSal.ifPresentOrElse(
                value -> System.out.println("Average Salary: " + value),
                () -> System.out.println("Not found")
        );

        System.out.println("___________________________________________________");
        // 4. Group employees by department
        Map<String, List<Employees>> empDepartment = employeesList.stream()
                .collect(Collectors.groupingBy(emp -> emp.getDepartment()));
        System.out.println("Employees by department: " + empDepartment);

        System.out.println("___________________________________________________");
        // 5. Count employees in each department
        Map<String, Long> empDptCount = employeesList.stream()
                .collect(Collectors.groupingBy(emp -> emp.getDepartment(), Collectors.counting()));
        System.out.println("Employee count by department: " + empDptCount);

        System.out.println("___________________________________________________");
        // 6. Sort employees by salary
        List<Employees> empBySal = employeesList.stream()
                .sorted(Comparator.comparingDouble(Employees::getSalary))
                .collect(Collectors.toList());
        System.out.println("Employees sorted by salary: " + empBySal);

        System.out.println("___________________________________________________");
        // 7. Employee with minimum salary
        Optional<Employees> empMinSal = employeesList.stream()
                .min(Comparator.comparingDouble(Employees::getSalary));
        empMinSal.ifPresentOrElse(
                e -> System.out.println("Employee with minimum salary: " + e.getName()),
                () -> System.out.println("Not found")
        );

        System.out.println("___________________________________________________");
        // 8. Second highest salary employee
        Optional<Employees> empSecondHigh = employeesList.stream()
                .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                .skip(1)
                .findFirst();
        empSecondHigh.ifPresentOrElse(
                e -> System.out.println("Second highest salary employee: " + e.getName()),
                () -> System.out.println("Not found")
        );

        System.out.println("___________________________________________________");
        // 9. Find all employee names using map()
        List<String> employeeNames = employeesList.stream()
                .map(emp -> emp.getName())
                .collect(Collectors.toList());
        System.out.println("Employee Names: " + employeeNames);

        System.out.println("___________________________________________________");
        // 10. Increase salary of all employees by 10%
        List<Employees> increasedSalaryList = employeesList.stream()
                .map(emp -> new Employees(
                        emp.getId(),
                        emp.getName(),
                        emp.getDepartment(),
                        emp.getAge(),
                        emp.getSalary() * 1.10,
                        emp.getHireDate()
                ))
                .collect(Collectors.toList());
        increasedSalaryList.forEach(emp ->
                System.out.println(emp.getName() + ": " + emp.getSalary())
        );

        System.out.println("___________________________________________________");
        //11. Find the top 3 highest-paid employees
        List<String> top3high = employeesList.stream()
                .sorted((a,b) -> Double.compare(b.getSalary(), a.getSalary()))
                .limit(3)
                .map(e -> e.getName())
                .collect(Collectors.toList());
        System.out.println("Top 3 highest paid employees: " + top3high);

        System.out.println("___________________________________________________");
        //12. Find employees whose names start with a specific letter.
        List<String> empNamesWith = employeesList.stream()
                .filter( e -> e.getName().startsWith("D"))
                .map( e -> e.getName())
                .collect(Collectors.toList());
        System.out.println("Employee names starting with S: " + empNamesWith);


        System.out.println("___________________________________________________");
        //13. Find the department with the most employees.
        Map<String, Long> deptCount = employeesList.stream()
                .collect(Collectors.groupingBy(
                        n -> n.getDepartment(),
                        Collectors.counting()
                ));
        System.out.println(deptCount);

        Optional<Map.Entry<String, Long>> result = deptCount.entrySet()
                .stream()
                .max((a, b) -> Long.compare(a.getValue(), b.getValue()));
        result.ifPresentOrElse(entry -> System.out.println(
                        "Department with most employees: "
                                + entry.getKey()
                                + " (" + entry.getValue() + " employees)"
                ),
                () -> System.out.println("No employees found")
        );


        System.out.println("___________________________________________________");
        //14. Find the oldest employee in each department.
        Map<String, Optional<Employees>> oldestInDept = employeesList.stream()
                .collect(Collectors.groupingBy(
                        Employees::getDepartment,
                        Collectors.maxBy(Comparator.comparingInt(Employees::getAge))
                ));
        oldestInDept.forEach((dept, emp) ->
                System.out.println("Oldest in dept: " + dept + " -> " + emp.map(Employees::getName).orElse("No employee")));

        System.out.println("___________________________________________________");
        //15. Sort employees by salary descending, then by name ascending (multiple comparators).
        List<Employees> sortedEmployees = employeesList.stream()
                .sorted(Comparator.comparingDouble(Employees::getSalary).reversed().thenComparing(Employees::getName))
                .collect(Collectors.toList());

        sortedEmployees.forEach(e ->
                System.out.printf("%-10s | %-10s | $%,.2f%n", e.getName(), e.getDepartment(), e.getSalary()));
            /* Quick printf cheat sheet since interviewers sometimes ask about formatting:
            %-10s → left-aligned string, 10 chars wide
            %,.2f → comma-separated decimal, 2 decimal places
            %n → platform-independent newline */

        System.out.println("___________________________________________________");
        //16. Find employees hired in the last 2 years (use LocalDate).
        List<Employees> recentHires = employeesList.stream()
                .filter(e -> e.getHireDate().isAfter(LocalDate.now().minusYears(2)))
                .collect(Collectors.toList());

        recentHires.forEach(e ->
                System.out.printf("%-10s | %s%n", e.getName(), e.getHireDate()));


        System.out.println("___________________________________________________");
        //17. Calculate total salary expense by department.
        Map<String, Double> totalSalaryByDept = employeesList.stream()
                .collect(Collectors.groupingBy(
                        Employees::getDepartment,
                        Collectors.summingDouble(Employees::getSalary)
                ));
        // groupingBy with summingDouble as the downstream collector.
        /*Know the alternatives if asked:

        Collectors.summarizingDouble() — gives you count, sum, min, avg, max all at once
        Collectors.reducing() — more flexible but verbose*/

        totalSalaryByDept.forEach((dept, total) ->
                System.out.printf("%-10s | $%,.2f%n", dept, total));

        System.out.println("____________________18_______________________________");
        //18. Find employees with duplicate names.
        Map<String, List<Employees>> duplicates = employeesList.stream()
                .collect(Collectors.groupingBy(Employees::getName))
                .entrySet().stream()
                .filter(e -> e.getValue().size() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        duplicates.forEach((name, emps) -> {
            System.out.println(name + ":");
            emps.forEach(e -> System.out.printf("  %-10s | %-10s%n", e.getDepartment(), e.getSalary()));
        });
        /*What's happening:**
            1. Group by name
            2. Stream over the entry set
            3. Keep only entries where the list has more than 1 employee
            4. Collect back into a map
        */

        System.out.println("___________________________________________________");
        //19. Create a Map of department → list of employee names.
        Map<String, List<String>> deptEmpList = employeesList.stream()
                .collect(Collectors.groupingBy(
                        Employees::getDepartment,
                        Collectors.mapping(Employees::getName, Collectors.toList())
                ));

        deptEmpList.forEach((dept, names) ->
                System.out.printf("%-10s | %s%n", dept, names));


        System.out.println("___________________________________________________");
        //20. Find employees with salary above department average.

        // Step 1: Get department averages
        Map<String, Double> deptAvg = employeesList.stream()
                .collect(Collectors.groupingBy(
                        Employees::getDepartment,
                        Collectors.averagingDouble(Employees::getSalary)
                ));

        // Step 2: Filter employees above their department's average
        List<Employees> aboveAvg = employeesList.stream()
                .filter(e -> e.getSalary() > deptAvg.get(e.getDepartment()))
                .collect(Collectors.toList());

        aboveAvg.forEach(e ->
                System.out.printf("%-10s | %-10s | $%,.2f | Dept Avg: $%,.2f%n",
                        e.getName(), e.getDepartment(), e.getSalary(), deptAvg.get(e.getDepartment())));


    }
}
