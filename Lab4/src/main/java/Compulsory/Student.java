package Compulsory;

import java.util.LinkedList;
import java.util.List;

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
}
