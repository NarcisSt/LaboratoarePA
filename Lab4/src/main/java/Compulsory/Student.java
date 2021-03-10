package Compulsory;

import java.util.LinkedList;
import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    List<School> schoolPreferences = new LinkedList<>();

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
