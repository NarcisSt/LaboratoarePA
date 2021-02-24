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

The checkboxes means that the problem was soveld.

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