# PA Lab 7

Author: Barat Narcis Stefan

Concurrency

Write a program that simulates the following positional game between a given number of players (TSP Game).

- At the beginning of the game the board contains a number of tokens, each token containing a distinct pair of numbers between 1 and n, and a specific positive value.
- Each player extracts tokens successively from the board and must create with them a a closed sequence, that is t1=(i1,i2), t2=(i2,i3),...,tk=(ik,i1), where ti are tokens.
- The value of a sequences may be evaluated in various modes: the sum of the token values, the number of tokens, etc. A special bonus may be given if the length of the sequence is n.
- The game ends when all tokens have been removed from the board and each player receives a number of points equal to the the value of its largest sequence, or equal to the sum of its sequences, etc.
- The players might take turns (or not...) and a time limit might be imposed (or not...).

## Compulsory
- &#9745; Create classes in order to model the problem. You may assume that all possible tokens are initially available, having random values.
- &#9745; Each player will have a name and they must perform in a concurrent manner, extracting repeatedly tokens from the board.
- &#9745; Simulate the game using a thread for each player.
  - Pay attention to the synchronization of the threads when extracting tokens from the board.
The checkedboxes means that the problem was solved.

### Example
```bash
The board is: 26 42 75 43 5 91 62 93 22 29 
Narcis has: 26 75 5 62 22 
Stefan has: 42 43 91 93 29 

Process finished with exit code 0
```