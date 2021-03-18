package Optional.Program;

import Optional.Entities.School;
import Optional.Entities.Student;

/**
 * Class Problem describes the dates of problem, contains all the students and all the schools
 */
public class Problem {
    private Student[] students;
    private School[] schools;

    public Problem(Student[] students, School[] schools) {
        this.students = students;
        this.schools = schools;
    }

    public Student[] getStudents() {
        return students;
    }

    public School[] getSchools() {
        return schools;
    }
}
