package Compulsory;

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

    public Student(String name) {
        this.name = name;
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(schoolPreferences, student.schoolPreferences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, schoolPreferences);
    }
}
