package Optional.Program;

import Optional.Entities.School;
import Optional.Entities.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                            if(assignedStudents.size() == problem.getStudents().length){
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

}
