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

    public double getAverageGrade(){

        double sum = 0.0;
        for(int marks : grades.values()){
            sum = sum + marks;
        }
        return (double )sum/grades.size();
    }


        public char getLetterGrade(){
            double average = getAverageGrade();

            if(average >= 90){
                return 'A';
            } else if(average >=80){
                return 'B';
            } else if(average >= 70){
                return 'C';
            }else if(average >= 60){
                return 'D';
            } else {
                return 'F';
            }
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
