package Optional.Program;

import Optional.Entities.School;
import Optional.Entities.Student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The Solution class gives a solution to an instance of the Problem class.
 */
public class Solution {
    private Problem problem;

    public Solution(Problem problem) {
        this.problem = problem;
    }

    List<Student> assignedStudents;

    Map<Student, School> pairs;

    /**
     * The method creates a solution, but only taking in consideration the preferences of the students and of the schools.
     * This method "deal" with first two points from the Optional part.
     */
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

    /**
     * Method that creates a solution, but by the score of the students.
     */
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

    /**
     * Method that displays the solution
     * @param showScore means what solution we want to display, if it s True, the solution with scores will pe displayed, else, the solution without score will be displayed.
     */
    public void displaySolution(boolean showScore) {
        for (Map.Entry<Student, School> node : pairs.entrySet()) {
            if (showScore) {
                System.out.println(node.getKey().getName() + " - " + node.getKey().getScore() + " - " + node.getValue().getName());

            } else {
                System.out.println(node.getKey().getName() + " - " + node.getValue().getName());
            }
        }
    }

    /**
     * Method that displays, using a query, all the students who wants to go to the schools from the list(the students who find acceptable a given list of schools).
     * @param schools a list of schools
     */
    public void displayStudentsWhoAcceptSchools(School[] schools) {
        List<School> target = Arrays.asList(schools);
        Arrays.asList(problem.getStudents()).stream()
                .filter(std -> std.getSchoolPreferences().containsAll(target))
                .forEach(System.out::println);
    }

    /**
     * Method that displays, using a query, the schools that have this student as their top preference
     * @param student a student
     */
    public void displaySchoolsWhoAcceptStudents(Student student) {
        Arrays.asList(problem.getSchools()).stream()
                .filter(sch -> sch.getStudentsPreferences().stream().findFirst().get() == student)
                .forEach(System.out::println);
    }
}
