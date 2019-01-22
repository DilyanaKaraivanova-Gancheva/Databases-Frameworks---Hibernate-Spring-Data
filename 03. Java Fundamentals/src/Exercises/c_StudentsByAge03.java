package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class c_StudentsByAge03 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Student1> students = new ArrayList<>();

        String[] line = bf.readLine().split("\\s+");

        while (!line[0].equalsIgnoreCase("end")){
            students.add(new Student1(line[0],line[1], Integer.parseInt(line[2])));

            line = bf.readLine().split("\\s+");
        }

        students.stream().
                filter(s -> s.getAge() >= 18 && s.getAge() <= 24)
                .forEach(System.out::println);
    }
}
class Student1{
    private String firstName;
    private String lastName;
    private Integer age;

    public Student1(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.age;
    }
}

