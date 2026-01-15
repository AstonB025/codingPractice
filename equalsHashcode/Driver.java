package equalsHashcode;

import java.util.*;

public class Driver {
    public static void main(String[] args) {
//        Person p1 = new Person("Alex", "Smith", new Date(), "alex@example.com");
//        Person p2 = new Person("Alex", "Johnson", new Date(), "alex@example.com");
//        Person p3 = new Person("Brian", "Smith", new Date(), "brian@example.com");
//
//        Set<Person> people = new HashSet<>();
//        people.add(p1);
//        people.add(p2); // duplicate email, should not be added
//        people.add(p3);
//
//        System.out.println("People in set: " + people.size()); // should print 2
//
//        for (Person p : people) {
//            System.out.println(p.getFirstName() + " - " + p.getEmail());
//        }


        List<Employee> employees = Arrays.asList(
                new Employee("Alex", 30, 5000),
                new Employee("Brian", 25, 7000),
                new Employee("Cassey", 25, 6000),
                new Employee("Diane", 30, 5000)
        );

        Collections.sort(employees, new SalaryComparator());
        System.out.println("Salary by descending order");
        for(Employee e : employees){
            System.out.println(e.getName() + " - " + e.getSalary());
        }

        System.out.println();
        Collections.sort(employees, new AgeNameComparator());
        System.out.println("By age ascending, then name: ");
        for(Employee e : employees){
            System.out.println(e.getName() + " - " + e.getAge());
        }
    }
}
