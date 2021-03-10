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