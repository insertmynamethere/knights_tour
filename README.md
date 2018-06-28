# knights_tour
A new(?) solution to the knight's tour problem. 

The knights tour problem is a famous maze-puzzle.
Given 1 knight piece on a chess board and starting on any space, can you make the knight traverse across all 64 spaces without reusing a space?

A knight can move in 8 possible directions. My solution takes those 8 directions and prioritizes them in a random order. Given an order of these 8 possible moves, the knight will move to the first availible direction following the order (The move with the highest priority). The knight will move in accordance to the priority of the directions that it's given. If the order does not result in a successful solution (the knight does not move to all 64 spaces), then the order is randomized again and the process repeats until a solution is found.

For example:<br/>
```
| |5| |2| |
|7| | | |1|
| | |K| | |
|6| | | |3|
| |8| |4| |
```
In more detail:
This grid repsents a random priority of directions a knight can move in. The numbers represent the priority of that direction. 1 being the highest, 8 being the lowest. If the direction at highest priority is availible (meaning the knight has yet to travel on that space) the knight will go in that direction. Should the direction at 1 being unavaible (meaning the knight has traveled on that space previously) the knight will resort to direction priority 2. Should 2 be unavailible, then direction 3 and so on and so forth. If the knight runs out of possible spaces to go but, all the spaces have yet to be traveled on, then the knight is given a different order. 

Currently, the code is setup to simply randomize the priority of directions until a soluton is found. I have tested this algorithm with all 64 starting positions and there is a priority of drections that leads to a solution for every starting position.

This leads me to believe that the knight's tour problem has a simple solution. Just assignment a priority for each direction the knight can move in. Then move the knight in the highest, possible priority. Should you run out of places to go and have not reached a solution, change the order of the moves and retry again.

Perhaps there is some sort of math equation invovled which allows each starting space to have a heirachy of moves that leads to a solution. 

run with:<br/>
java Lab16ast
