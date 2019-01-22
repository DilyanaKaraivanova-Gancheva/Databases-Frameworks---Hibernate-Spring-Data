package Exercises.g_AverageGrades07;

public class Student {
    private String name;
    private double[] grades;
    private double averageGrade;

    public Student(String name, double[] grades) {
        this.name = name;
        this.grades = grades;
        this.averageGrade = calculateAverageGrade(this.grades);
    }

    private double calculateAverageGrade(double[] grades) {
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return sum/grades.length;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public String getName() {
        return name;
    }
}
