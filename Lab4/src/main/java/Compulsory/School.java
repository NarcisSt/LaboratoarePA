package Compulsory;

import java.util.Set;
import java.util.TreeSet;

/**
 * The School class implements the Comparable interface and has the name of the school and a list of preferences regarding the students.
 * Also has the overridden compareTo and toString methods from the Object class.
 */
public class School implements Comparable<School> {
    private String name;
    private Set<Student> studentsPreferences = new TreeSet<>();

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
