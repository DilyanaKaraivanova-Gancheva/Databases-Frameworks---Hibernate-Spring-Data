package Exercises.i_Students09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String name = bf.readLine();

        while (!name.equalsIgnoreCase("end")){
            Student student = new Student(name);

            name = bf.readLine();
        }

        System.out.println(Student.count);
    }
}
