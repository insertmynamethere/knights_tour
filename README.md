# knights_tour
My own solution to the knight's tour problem

The knights tour problem is a famous puzzle. Given 1 knight on a chess board, starting at any position, can you make the knight traverse across all 64 spaces without reusing a space?

A knight can move in 8 possible directions. My solution takes those 8 directions and gives them a random order. Given any order of these 8 possible moves, the knight will move to the first availible direction following the order. If the order does not result in a successful solution (the knight does not move to all 64 spaces), then the order is randomized again and the process repeats until a solution is found.

For example:<br/>
| |5| |2| |<br/>
|7| | | |1|<br/>
| | |K| | |<br/>
|6| | | |3|<br/>
| |8| |4| |<br/>

This grid repsents the possible directions a knight can move in. The numbers represent the priority of that direction. 1 being the highest, 8 being the lowest. If the direction at priority 1 is availible (meaning it hasn't been crossed yet) the knight will go in that direction. should the direction at 1 being unavaible (meaning it has been crossed previously) the knight will resort to direction 2. Should 2 be unavailible, then direction 3 and so on and so forth. 

I have tested this method with all 64 starting positions and there is a possible order-of-moves for every starting position.

This leads me to believe that the knight's tour problem has a simple solution. Just assignment a priority for each direction the knight can move in. Then move the knight in the highest, possible priority. Go down the prioirty levels until you find a possible move to make. Should you run out of places to go and have not reached a solution, change the order of the moves and retry again.


run with<br/>
java Lab16ast
