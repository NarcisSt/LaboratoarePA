package Compulsory;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * The School class implements the Comparable interface and has the name of the school and a list of preferences regarding the students.
 * Also has the overridden compareTo and toString methods from the Object class.
 */
public class School implements Comparable<School> {
    private String name;
    private Set<Student> studentsPreferences = new TreeSet<>();
    private int capacity;

    public School(String name) {
        this.name = name;
    }

    public School(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity >= 0) {
            this.capacity = capacity;
        } else {
            new Exception("Capacity must be at least 0");
        }
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
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(name, school.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

