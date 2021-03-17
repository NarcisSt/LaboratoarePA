package Optional;

import Optional.Entities.School;
import Optional.Entities.Student;
import Optional.Program.Problem;
import Optional.Program.Solution;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Student[] students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);

        School[] schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("H" + i))
                .toArray(School[]::new);

        schools[0].setCapacity(1);
        schools[1].setCapacity(2);
        schools[2].setCapacity(2);

        students[0].setSchoolPreferences(new LinkedList<>(Arrays.asList(schools[0], schools[1], schools[2])));
        students[1].setSchoolPreferences(new LinkedList<>(Arrays.asList(schools[0], schools[1], schools[2])));
        students[2].setSchoolPreferences(new LinkedList<>(Arrays.asList(schools[0], schools[1])));
        students[3].setSchoolPreferences(new LinkedList<>(Arrays.asList(schools[0], schools[2])));

        schools[0].setStudentsPreferences(new LinkedHashSet<>(Arrays.asList(students[3], students[0], students[1], students[2])));
        schools[1].setStudentsPreferences(new LinkedHashSet<>(Arrays.asList(students[0], students[2], students[1])));
        schools[2].setStudentsPreferences(new LinkedHashSet<>(Arrays.asList(students[0], students[1], students[3])));

        Problem problem = new Problem(students, schools);

        Solution solution = new Solution(problem);

        solution.createMatching();
        solution.displaySolution();

    }
}
