package Optional.Program;

import Optional.Entities.School;
import Optional.Entities.Student;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private Problem problem;

    public Solution(Problem problem) {
        this.problem = problem;
    }

    List<Student> assignedStudents;

    Map<Student, School> pairs;

    public void createMatchingWithoutScore() {
        assignedStudents = new ArrayList<>();
        pairs = new HashMap<>();

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

    public void createMatchingWithScore() {
        assignedStudents = new ArrayList<>();
        pairs = new HashMap<>();

        for (School school : problem.getSchools()) {
            int count = school.getCapacity();
            while (count > 0) {
                List<Student> sortedStudents = school.getStudentsPreferences().stream().sorted(Comparator.comparing(Student::getScore).reversed()).collect(Collectors.toList());
                for (Student student : sortedStudents) {
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

    public void displaySolution(boolean showScore) {
        for (Map.Entry<Student, School> node : pairs.entrySet()) {
            if (showScore) {
                System.out.println(node.getKey().getName() + " - " + node.getKey().getScore() + " - " + node.getValue().getName());

            } else {
                System.out.println(node.getKey().getName() + " - " + node.getValue().getName());
            }
        }
    }

    public void displayStudentsWhoAcceptSchools(School[] schools) {
        List<School> target = Arrays.asList(schools);
        Arrays.asList(problem.getStudents()).stream()
                .filter(std -> std.getSchoolPreferences().containsAll(target))
                .forEach(System.out::println);
    }

    public void displaySchoolsWhoAcceptStudents(Student student) {
        Arrays.asList(problem.getSchools()).stream()
                .filter(sch -> sch.getStudentsPreferences().stream().findFirst().get() == student)
                .forEach(System.out::println);
    }
}
