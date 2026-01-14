package collections;

import java.util.*;

public class Employee {

    String name;
    String department;
    double salary;

    @Override
    public String toString() {
        return name;

    }

    public Employee(String name, String department, double salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees){

        Map<String, List<Employee>> resultMap = new HashMap<>();


        for(Employee e : employees){
            // get list for department, or create new one
            List<Employee> deptEmployees = resultMap.getOrDefault(e.department, new ArrayList<>());

            // add employee to list
            deptEmployees.add(e);

            // put back in map
            resultMap.put(e.department, deptEmployees);

        }
        return resultMap;
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Alex", "IT", 75000.45);
        Employee emp2 = new Employee("Brian", "Sales", 45000);
        Employee emp3 = new Employee("Cassey", "Sales", 32000);
        Employee emp4 = new Employee("Diane", "HR", 44000);
        Employee emp5 = new Employee("Elyse", "IT", 65000);

        List<Employee> employees = Arrays.asList(emp1, emp2, emp3, emp4, emp5);

        Map<String, List<Employee>> grouped = groupByDepartment(employees);

        for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
