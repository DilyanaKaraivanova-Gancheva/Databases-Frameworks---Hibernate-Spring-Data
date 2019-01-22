package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class d_SortStudents04 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Student2> students = new ArrayList<>();

        String[] line = bf.readLine().split("\\s+");

        while (!line[0].equalsIgnoreCase("end")){
            students.add(new Student2(line[0],line[1]));

            line = bf.readLine().split("\\s+");
        }

        students.stream().
                sorted(comparing(Student2::getLastName)
                        .thenComparing((comparing(Student2::getFirstName)).reversed()))
                .forEach(System.out::println);
    }
}

class Student2{
    private String firstName;
    private String lastName;

    public Student2(String firstName, String lastName) {
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
