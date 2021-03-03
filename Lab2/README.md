# PA Lab 2

Author: Barat Narcis Stefan

## Compulsory

 - &#9745; Create an object-oriented model of the problem. You should have (at least) the following classes:Source, Destination, Problem.
    The sources and the destinations have names. The sources will also have the property type. The available types will be implemented as an enum . For example:

```bash
public enum SourceType {
WAREHOUSE, FACTORY;
}
```
Assume S1 is a factory and S2, S3 are warehouses.
 - &#9745; Each class should have appropriate constructors, getters and setters.
Use the IDE features for code generation, such as generating getters and setters.
 - &#9745; The toString method form the Object class must be properly overridden for all the classes.
Use the IDE features for code generation, for example (in NetBeans) press Alt+Ins or invoke the context menu, select "Insert Code" and then "toString()" (or simply start typing "toString" and then press Ctrl+Space).
 - &#9745; Create and print on the screen the instance of the problem described in the example.

The checkedboxes means that the problem was solved.

### Example
```bash
Source{name='S1', type=FACTORY}
Source{name='S2', type=WAREHOUSE}
Source{name='S3', type=WAREHOUSE}
Destination{name='D1'}
Destination{name='D2'}
Destination{name='D3'}
Problem{
sources=[Source{name='S1', type=FACTORY}, Source{name='S2', type=WAREHOUSE}, Source{name='S3', type=WAREHOUSE}]
destinations=[Destination{name='D1'}, Destination{name='D2'}, Destination{name='D3'}]
supply=[10, 35, 25]
demand=[20, 25, 25]
cost=[[2, 3, 1], [5, 4, 8], [5, 6, 8]]}
}
```

## Optional + Bonus

 - &#9745; Override the equals method form the Object class for the Source, Destination classes. The problem should not allow adding the same source or destination twice.
 - &#9745; Instead of using an enum, create dedicated classes for warehouses and factories. Source will become abstract.
 - &#9745; Create a class to describe the solution.
 - &#9745; Implement a simple algorithm for creating a feasible solution to the problem (one that satisfies the supply and demand constraints).
 - &#9745; Write doc comments in your source code and generate the class documentation using javadoc.
 - &#9745;Implement an algorithm in order to minimize the total cost.
 - &#9745; Generate large random instances and analyze the performance of your algorithm (running times, memory consumption). Identify the hot-spots in your code.

The checkedboxes means that the problem was solved.

### Example
```bash
The minimized cost is: 2850
Performance of the program:
Time of execution: 9316200 nanoseconds
Free memory: 122,594 mb
Allocated memory: 125,952 mb
Max memory: 1,846,272 mb
Total free memory: 1,842,914 mb
```
 