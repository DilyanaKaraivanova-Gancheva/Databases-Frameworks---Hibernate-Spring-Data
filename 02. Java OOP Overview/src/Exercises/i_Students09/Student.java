package Exercises.i_Students09;

public class Student {
    private String name;
    public static int count;

    public Student(String name) {
        this.name = name;
        count++;
    }
}
