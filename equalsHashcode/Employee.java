package equalsHashcode;

import java.util.Comparator;

public class Employee {

    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class SalaryComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee e1, Employee e2){
        return (int) (e2.getSalary() - e1.getSalary());
    }
}

class AgeNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2){
        int ageOrder = (e1.getAge() - e2.getAge());
        if(ageOrder != 0){
            return ageOrder;
        }

        return e1.getName().compareTo(e2.getName());
    }
}

