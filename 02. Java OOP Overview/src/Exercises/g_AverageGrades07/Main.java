package Exercises.g_AverageGrades07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Student> students = new ArrayList<>();
        int numOfStudents = Integer.parseInt(bf.readLine());

        for (int i = 0; i < numOfStudents; i++) {
            String[] line = bf.readLine().split("\\s+");
           double[] grades = new double[line.length-1];
           int cnt = 0;
            for (int j = 1; j <line.length ; j++) {
                grades[cnt++] = Double.parseDouble(line[j]);
            }
            Student student = new Student(line[0], grades);
            students.add(student);
        }
        students.stream().filter(student -> student.getAverageGrade() >= 5.00)
                .sorted(comparing(Student::getName).thenComparing((comparing(Student::getAverageGrade)).reversed()))
                .forEach(student -> System.out.printf("%s -> %.2f%n", student.getName(),student.getAverageGrade()));
    }
}
