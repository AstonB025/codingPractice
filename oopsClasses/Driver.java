package oopsClasses;

public class Driver {
    public static void main(String[] args) {


        Student s1 = new Student(1, "Alex");
        Student s2 = new Student(2, "Brian");
        Student s3 = new Student(3, "Cassey");

        s1.addGrade("Math", 95);
        s1.addGrade("Science", 88);
        s1.addGrade("History", 72);

        s2.addGrade("Math", 85);
        s2.addGrade("Science", 98);
        s2.addGrade("History", 82);

        s3.addGrade("Math", 75);
        s3.addGrade("Science", 98);
        s3.addGrade("History", 92);


        System.out.println(s1);
        System.out.println(s1.getGrade("Math"));
        System.out.println(s1.getAverageGrade());
        System.out.println(s1.getLetterGrade());
        System.out.println("___________________________________________");
        System.out.println(s2);
        System.out.println(s2.getGrade("Math"));
        System.out.println(s2.getAverageGrade());
        System.out.println(s2.getLetterGrade());
        System.out.println("___________________________________________");
        System.out.println(s3);
        System.out.println(s3.getGrade("Math"));
        System.out.println(s3.getAverageGrade());
        System.out.println(s3.getLetterGrade());
        System.out.println("___________________________________________");



    }
}