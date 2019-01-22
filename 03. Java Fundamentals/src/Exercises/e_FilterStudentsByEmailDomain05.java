package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class e_FilterStudentsByEmailDomain05 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Student3> students = new ArrayList<>();

        String[] line = bf.readLine().split("\\s+");

        while (!line[0].equalsIgnoreCase("end")){
            students.add(new Student3(line[0],line[1],line[2]));

            line = bf.readLine().split("\\s+");
        }

        students.stream().
                filter(s -> s.getEmail().contains("@gmail.com"))
                .forEach(System.out::println);
    }
}

class Student3{
    private String firstName;
    private String lastName;
    private String email;

    public Student3(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
