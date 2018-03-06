# knights_tour
My own solution to the knight's tour problem

A knight can move in 8 possible directions. My solution takes those 8 directions and gives them a random order. Given any order of these 8 possible moves, the knight will move to the first availible direction following the order. If the order does not result in a successful solution (the knight does not move to all 64 spaces), then the order is randomized again and the process repeats until a solution is found.
