package Optional.Program;

import Optional.Entities.School;
import Optional.Entities.Student;

import java.util.*;

public class Solution {
    private Problem problem;

    public Solution(Problem problem) {
        this.problem = problem;
    }

    List<Student> assignedStudents = new ArrayList<>();

    Map<Student, School> pairs = new HashMap<>();

    public void createMatching() {
        for (School school : problem.getSchools()) {
            int count = school.getCapacity();
            while (count > 0) {
                for (Student student : school.getStudentsPreferences()) {
                    if (!assignedStudents.contains(student)) {
                        if (student.getSchoolPreferences().contains(school)) {
                            assignedStudents.add(student);
                            pairs.put(student, school);
                            count--;
                            if (count == 0) {
                                break;
                            }
                            if (assignedStudents.size() == problem.getStudents().length) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public void displaySolution() {
        for (Map.Entry<Student, School> node : pairs.entrySet()) {
            System.out.println(node.getKey().getName() + " - " + node.getValue().getName());
        }
    }

    public void displayStudentsWhoAcceptSchools(School[] schools) {
        List<School> target = Arrays.asList(schools);
        Arrays.asList(problem.getStudents()).stream()
                .filter(std -> std.getSchoolPreferences().containsAll(target))
                .forEach(System.out::println);
    }

    public void displaySchoolsWhoAcceptStudents(Student student){
        Arrays.asList(problem.getSchools()).stream()
                .filter(sch -> sch.getStudentsPreferences().stream().findFirst().get() == student)
                .forEach(System.out::println);
    }
}
