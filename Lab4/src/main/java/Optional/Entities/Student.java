package Optional.Entities;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * The Student class implements the Comparable interface and has the name of the student and a list of preferences regarding the schools.
 * Also has the overridden compareTo and toString methods from the Object class.
 */
public class Student implements Comparable<Student> {
    private String name;
    private List<School> schoolPreferences = new LinkedList<>();
    private int score;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<School> getSchoolPreferences() {
        return schoolPreferences;
    }

    public void setSchoolPreferences(List<School> schoolPreferences) {
        this.schoolPreferences = schoolPreferences;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student student) {
        if (this.name != null) {
            return this.name.compareTo(student.name);
        } else {
            new Exception("The name is null!");
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
