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

## Optional
- &#9745; Implement the scoring and determine who the winner is at the end of the game.
- &#9745; Make sure that players wait their turns, using a wait-notify approach.
- &#9745; Consider the situation when each player might have a different strategy for extracting a number: automated (random) or manual.
- &#9745; A manual player will use the keyboard, while the bot will extract a random token. Simulate bot contests on large graphs.
- &#9745; Implement a timekeeper thread that runs concurrently with the player threads, as a daemon. This thread will display the running time of the game and it will stop the game if it exceeds a certain time limit.

## Bonus
- &#9745; Implement a "smart" player. This should try to create valuable sequences, while not allowing others to extend theirs.
- &#9745; Implement various scoring strategies (in a flexible manner), for example the winner could be the one that determines the most valuable hamiltonian circuit.
Create a simple graphical user interface for the game, using JavaFX.

### Example
```bash
Commands:
 1. play
 2. list
 3. quit
shell>>play
Options: { arithmetic, clique }
Enter the game you want to play: arithmetic
Enter the number of tokens on the table: 8
Enter the duration of the game (in seconds): 10
Enter the target size of the arithmetic progression: 3
Enter the number of players: 2
Options: { smart, random, manual }
Enter the player type: smart
Enter player name: S1
Options: { smart, random, manual }
Enter the player type: smart
Enter player name: S2
Arithmetic progression game started!
S1's turn. Smart player.
S2's turn. Smart player.
S1's turn. Smart player.
S2's turn. Smart player.
S1's turn. Smart player.
Winner: S1
Winner's arithmetic progression: 4, 5, 6

shell>>play
Options: { arithmetic, clique }
Enter the game you want to play: clique
Enter the number of vertices: 8
Enter the duration of the game (in seconds): 5
Enter the target size of the clique: 2
Enter the number of players: 2
Options: { random, manual }
Enter the player type: random
Enter player name: S1
Options: { random, manual }
Enter the player type: random
Enter player name: S2
Clique game started!
S1's turn. Random player.
Winner: S1
Winner's clique: 1, 4
Winner's edges: 
{1, 4}

shell>>quit

Process finished with exit code 0
```