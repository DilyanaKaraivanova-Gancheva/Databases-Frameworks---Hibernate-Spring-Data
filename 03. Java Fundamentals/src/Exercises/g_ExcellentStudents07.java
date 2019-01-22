package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class g_ExcellentStudents07 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Student5> students = new ArrayList<>();

        String[] line = bf.readLine().split("\\s+");

        while (!line[0].equalsIgnoreCase("end")){
            List<Integer> grades = new ArrayList<>();
            for (int i = 2; i < line.length; i++) {
                grades.add(Integer.valueOf(line[i]));
            }
            students.add(new Student5(line[0],line[1],grades));

            line = bf.readLine().split("\\s+");
        }

        students.stream().
                filter(s -> s.getGrades().contains(6))
                .forEach(System.out::println);
    }
}

class Student5 {
    private String firstName;
    private String lastName;
    private List<Integer> grades;

    public Student5(String firstName, String lastName, List<Integer> grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    public List<Integer> getGrades() {
        return grades;
    }


    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}


