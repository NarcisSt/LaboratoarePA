# PA Lab 1

Author: Barat Narcis Stefan

## Compulsory

Write a Java application that implements the following operations:
- &#9745; Display on the screen the message "Hello World!". Run the application. If it works, go to step 2 :)
- &#9745; Define an array of strings languages, containing {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}
- &#9745; Generate a random integer n: int n = (int) (Math.random() * 1_000_000)
- &#9745; Compute the result obtained after performing the following calculations:
    - &#9745; multiply n by 3;
    - &#9745; add the binary number 10101 to the result;
    - &#9745; add the hexadecimal number FF to the result;
    - &#9745; multiply the result by 6;
- &#9745; Compute the sum of the digits in the result obtained in the previous step. This is the new result. While the new result has more than one digit, continue to sum the digits of the result.
- &#9745; Display on the screen the message: "Willy-nilly, this semester I will learn " + languages[result].

The checkboxes means that the problem was soveld.

### Example
```bash
Hello world!
442118
1326354
21
1326375
255
1326630
7959780
9
Willy-nilly, this semester i will learn Java
```

## Optional

- &#9745; Let n be an integer given as a command line argument. Validate the argument!
- &#9745; Create a n x n matrix, representing the adjacency matrix of a random graph.
- &#9745; Display on the screen the generated matrix (you might want to use the geometric shapes from the Unicode chart to create a "pretty" representation of the matrix).
- &#9745; Verify if the generated graph is connected and display the connected components (if it is not).
- &#9745; Assuming that the generated graph is connected, implement an algorithm that creates a partial tree of the graph. Display the adjacency matrix of the tree.
- &#9745; For larger n display the running time of the application in nanoseconds (DO NOT display the matrices). Try n > 30_000. You might want to adjust the JVM Heap Space using the VM options -Xms4G -Xmx4G.
- &#9745; Launch the application from the command line, for example: java Lab1 100.

The checkboxes means that the problem was soveld.

### Compile:

```bash
javac -d "classes" Matrix.java
javac -d "classes" Node.java
javac -d "classes" -classpath "classes" Graph.java
javac -d "classes" -classpath "classes" Tree.java
javac -d "classes" -classpath "classes" Main.java
```

### Execute
```bash
java -classpath "classes" Optional.Main 4
java -Xms4G -Xmx4G -classpath "classes" Optional.Main 30000
```

### Example
```bash
java -classpath "classes" Optional.Main 4

The adjacency matrix of the graph:
0 0 1 1
0 0 1 0
1 1 0 0
1 0 0 0
The component number 1:
0 2 3 1
The graph is connected

Node: 0
Connected to: 2 3
Node: 1
Connected to: 2
Node: 2
Connected to: 0 1
Node: 3
Connected to: 0

The adjacency matrix of the partial tree:
0 0 1 1
0 0 1 0
1 1 0 0
1 0 0 0
The application execution time in nanoseconds is: 21758900
```

## Bonus

- &#9745; Implement an efficient algorithm that generates a random rooted tree. Create and display a textual representation of the tree, for example:

The checkboxes means that the problem was soveld.

```bash
+node0
  +node1
    -node2
  +node3
    -node4
    -node5
```


### Example
```bash
+node0 | node0.0
  +node1 | node1.0
    +node2 | node2.0
      +node3 | node3.0
        +node4 | node4.0
          +node5 | node5.0
            -node6 | node6.0
            -node7 | node6.1
        -node8 | node4.1
      +node9 | node3.1
        +node10 | node4.0
          +node11 | node5.0
            +node12 | node6.0
              +node13 | node7.0
                +node14 | node8.0
                  +node15 | node9.0
                    -node16 | node10.0
                  +node17 | node9.1
                    -node18 | node10.0
                    -node19 | node10.1
              -node20 | node7.1

Generated 21 nodes
```
