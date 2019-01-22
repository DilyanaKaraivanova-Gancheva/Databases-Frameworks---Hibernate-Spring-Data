package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends Person{
    private Double averageGrade;
    private String attendance;
    private Set<Course> courses;

    public Student() {
    }

    @Column(name = "average_grade")
    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Column(name = "attendance")
    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    @ManyToMany(mappedBy = "students",targetEntity = Course.class)
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
