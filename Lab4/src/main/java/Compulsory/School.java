package Compulsory;

import java.util.Set;
import java.util.TreeSet;

public class School implements Comparable<School> {
    private String name;
    Set<Student> studentsPreferences = new TreeSet<>();

    public School(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(School school) {
        if (this.name != null) {
            return this.name.compareTo(school.name);
        } else {
            new Exception("The name is null!");
            return -1;
        }
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                '}';
    }
}
