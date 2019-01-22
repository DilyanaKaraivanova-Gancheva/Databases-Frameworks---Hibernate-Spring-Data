package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class f_FilterStudentsByPhone06 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Student4> students = new ArrayList<>();

        String[] line = bf.readLine().split("\\s+");

        while (!line[0].equalsIgnoreCase("end")){
            students.add(new Student4(line[0],line[1],line[2]));

            line = bf.readLine().split("\\s+");
        }

        students.stream().
                filter(s -> s.getPhoneNumber().startsWith("02") || s.getPhoneNumber().startsWith("+3592"))
                .forEach(System.out::println);
    }
}
class Student4{
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Student4(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
