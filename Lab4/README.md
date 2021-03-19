# PA Lab 4

Author: Barat Narcis Stefan

## Compulsory
- &#9745; Create an object-oriented model of the problem. You should have at least the following classes: Student, School and the main class.
- &#9745; Create all the objects in the example using streams.
- &#9745; Create a list of students, using LinkedList implementation. Sort the students, using a comparator.
- &#9745; Create a set of schools, using a TreeSet implementation. Make sure that School objects are comparable.
- &#9745; Create two maps (having different implementations) describing the students and the school preferences and print them on the screen.

The checkedboxes means that the problem was solved.

### Example
```bash
Student{name='S1'} - School{name='H0'} School{name='H1'} School{name='H2'} 
Student{name='S2'} - School{name='H0'} School{name='H1'} 
Student{name='S0'} - School{name='H0'} School{name='H1'} School{name='H2'} 
Student{name='S3'} - School{name='H0'} School{name='H2'} 

School{name='H0'} - Student{name='S3'} Student{name='S0'} Student{name='S1'} Student{name='S2'} 
School{name='H1'} - Student{name='S0'} Student{name='S2'} Student{name='S1'} 
School{name='H2'} - Student{name='S0'} Student{name='S1'} Student{name='S3'} 
```

## Optional
- &#9745; Create a class that describes the problem and one that describes a solution (a matching) to this problem.
- &#9745; Using Java Stream API, write queries that display the students who find acceptable a given list of schools, and the schools that have a given student as their top preference.
- &#9745; Use a third-party library in order to generate random fake names for students and schools.
- &#9745; Implement an algorithm for creating a matching, considering that each student has a score obtained at the evaluation exam and the schools rank students based on this score.
- &#9745; Test your algorithm.

The checkedboxes means that the problem was solved.

### Example
```bash
Miss Jarvis Kuvalis - Langosh school
Dorotha Wolff Jr. - Schmitt school
Petrina Tromp - Langosh school
Ina Hodkiewicz - Donnelly school

Miss Jarvis Kuvalis - 91 - Donnelly school
Dorotha Wolff Jr. - 8 - Langosh school
Petrina Tromp - 43 - Langosh school
Ina Hodkiewicz - 70 - Schmitt school

Student{name='Miss Jarvis Kuvalis', score=91}
Student{name='Dorotha Wolff Jr.', score=8}
Student{name='Petrina Tromp', score=43}
School{name='Donnelly school', capacity=1} 
```

## Bonus
- &#9745; Consider the case in which a school can rank the students based on their specific criteria.
- &#9745; Implement the Gale Shapley algorithm in order to find a stable matching. 
- Consider the case in which preferences are not necessarily strict. Some consecutive preferences in an element's list may form a tie.
- For example S1: H1, [H2,H3] means that S1 prefers H1 over H2 and H3, but H2 and H3 have no precedence one over the other.
- Prove that in the case of SAP with ties, a problem may have multiple stable matchings, not all of the same size.
- Check out other examples of matching in practice.

The checkedboxes means that the problem was solved.

### Example
```bash
Miss Jarvis Kuvalis - Langosh school
Dorotha Wolff Jr. - Schmitt school
Petrina Tromp - Langosh school
Ina Hodkiewicz - Donnelly school
```