package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class h_WeakStudents08 {
    public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    List<Student6> students = new ArrayList<>();

    String[] line = bf.readLine().split("\\s+");

    while (!line[0].equalsIgnoreCase("end")){
        List<Integer> grades = new ArrayList<>();
        for (int i = 2; i < line.length; i++) {
            grades.add(Integer.valueOf(line[i]));
        }
        students.add(new Student6(line[0],line[1],grades));

        line = bf.readLine().split("\\s+");
    }

    students.stream().
            filter(Student6::weakMarks)
            .forEach(System.out::println);
}
}

class Student6 {
    private String firstName;
    private String lastName;
    private List<Integer> grades;

    public Student6(String firstName, String lastName, List<Integer> grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    public boolean weakMarks(){
        int weakMarks = 0;
        for (Integer grade : this.grades) {
            if (grade <= 3){
                weakMarks++;
            }
            if(weakMarks >= 2){
                return true;
            }
        }

        return false;
    }


    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
