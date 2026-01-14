package oopsClasses;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private int studentId;
    private String name;
    private Map<String, Integer> grades;

    public Student(int studentId, String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.studentId = studentId;
        this.name = name;
        this.grades = new HashMap<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }


    public void addGrade(String subject, int marks){

        if(subject == null || subject.isEmpty()){
            throw new IllegalArgumentException("Subject cannot be empty");
        }
        if(marks < 0 || marks > 100){
            throw new IllegalArgumentException("marks cannot be less than 0 or more than 100");
        }

        grades.put(subject, marks);
    }

    public int getGrade(String subject){
        return grades.getOrDefault(subject, -1);
    }




    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }
}
