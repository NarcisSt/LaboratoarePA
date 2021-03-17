package Optional.Program;

import Optional.Entities.School;
import Optional.Entities.Student;

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
