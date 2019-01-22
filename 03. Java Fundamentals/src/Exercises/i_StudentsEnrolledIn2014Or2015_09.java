package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class i_StudentsEnrolledIn2014Or2015_09 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Student7> students = new ArrayList<>();

        String[] line = bf.readLine().split("\\s+");

        while (!line[0].equalsIgnoreCase("end")){
            List<Integer> grades = new ArrayList<>();
            for (int i = 1; i < line.length; i++) {
                grades.add(Integer.valueOf(line[i]));
            }
            students.add(new Student7(line[0],grades));

            line = bf.readLine().split("\\s+");
        }

        students.stream().
                filter(s-> s.getFacNum().endsWith("14")|| s.getFacNum().endsWith("15"))
                .forEach(System.out::println);
    }
}


class Student7 {
    private String facNum;
    private List<Integer> grades;

    public Student7(String facNum, List<Integer> grades) {
        this.facNum = facNum;
        this.grades = grades;
    }

    public String getFacNum() {
        return facNum;
    }

    @Override
    public String toString() {
        return this.grades.toString().replaceAll("]","").replaceAll("\\[","")
                .replaceAll(",","");
    }
}
