package Exercises.j_GroupByGroup10;

public class Person {
    private String name;
    private Integer group;

    public Person(String name, Integer group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public Integer getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
