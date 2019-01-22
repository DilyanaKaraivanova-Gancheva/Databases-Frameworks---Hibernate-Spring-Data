package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b_StudentsByFirstAndLastName02 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

       List<Student> students = new ArrayList<>();

        String[] line = bf.readLine().split("\\s+");

        while (!line[0].equalsIgnoreCase("end")){
            students.add(new Student(line[0],line[1]));

            line = bf.readLine().split("\\s+");
        }

        students.stream().
                filter(s -> s.getFirstName().compareTo(s.getLastName()) < 0)
                .forEach(System.out::println);
    }
}

    class Student{
        private String firstName;
        private String lastName;

        public Student(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return this.firstName + " " + this.lastName;
        }
    }
