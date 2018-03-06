//Willy Xu website: insertmy.name
import java.util.*;
import java.io.*;

public class Lab16ast {
        public static void main (String args[]) {
                Knight knight = new Knight();
                knight.getStart();
                knight.solveTour();
                knight.displayBoard();
        }
}

class Knight {
        private int board[][];
        private int startRow;
        private int startCol;
        private int rowPos;
        private int colPos;
        private int moves;
        private int movesOption[][] = {
                {-2,1},
                {-1,2},
                {1,2},
                {2,1},
                {2,-1},
                {1,-2},
                {-1,-2},
                {-2,-1}
        };
        final private int ACCESS[][] = {
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,2,3,4,4,4,4,3,2,0,0},
                {0,0,3,4,6,6,6,6,4,3,0,0},
                {0,0,4,6,8,8,8,8,6,4,0,0},
                {0,0,4,6,8,8,8,8,6,4,0,0},
                {0,0,4,6,8,8,8,8,6,4,0,0},
                {0,0,4,6,8,8,8,8,6,4,0,0},
                {0,0,3,4,6,6,6,6,4,3,0,0},
                {0,0,2,3,4,4,4,4,3,2,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0}
        };

        public void getStart() {
                Scanner input = new Scanner(System.in);

                System.out.print("Enter starting row (numbers 1 - 8 only): ");
                boolean correctInput = false;
                do {
                        try {
                                startRow = input.nextInt() - 1;
                                correctInput = true;
                                        if (startRow < 0 ||  startRow > 7) {
                                        System.out.print("Error! >>> enter a number from 1 to 8: ");
                                        correctInput = false;
                                }
                        } catch (InputMismatchException e) {
                                String buffer = input.next();
                                System.out.print("Error! >>> enter a number: ");
                        }
                } while (!correctInput);

                System.out.print("Enter starting column (numbers 1 - 8 only): ");
                correctInput = false;
                do {
                        try {
                                startCol = input.nextInt() - 1;
                                correctInput = true;
                                        if (startCol < 0 ||  startCol > 7) {
                                        System.out.print("Error! >>> enter a number from 1 to 8: ");
                                        correctInput = false;
                                }
                        } catch (InputMismatchException e) {
                                String buffer = input.next();
                                System.out.print("Error! >>> enter a number: ");
                        }
                } while (!correctInput);
                System.out.println();
        }

        public void displayBoard() {
                System.out.println();
                        for (int y = 0; y < board.length; y++) {
                        for (int x = 0; x < board[y].length; x++)
                                        System.out.printf("%02d ",board[y][x]);
                        System.out.println();
                }
                        System.out.println("\nThe knight made " + moves + " moves");
        }

        private boolean getMove() {
                int moveID = -1;
                int numOfmove = 8;
                        for (int x = 0; x < movesOption.length; x++) {
                        if (ACCESS[rowPos + movesOption[x][0] + 2][colPos + movesOption[x][1] + 2] != 0) {
                                if (board[rowPos + movesOption[x][0]][colPos + movesOption[x][1]] == 0) {
                                        if (ACCESS[rowPos + movesOption[x][0] + 2][colPos + movesOption[x][1] + 2] <= numOfmove) {
                                                numOfmove = ACCESS[rowPos + movesOption[x][0] + 2][colPos + movesOption[x][1] + 2];
                                                moveID = x;
                                        }
                                }
                        }
                }

                if (moveID != -1) {
                        board[rowPos += movesOption[moveID][0]][colPos += movesOption[moveID][1]] = ++moves;
                        return true;
                }
                        return false;
        }

        public void solveTour() {
                while (moves != 64) {
                        moves = 0;
                        board = new int[8][8];
                        rowPos = startRow;
                        colPos = startCol;
                        board[rowPos][colPos] = ++moves;
                                Random rnd = new Random();
                        for (int s = movesOption.length - 1; s > 0; s--) {
                                int index = rnd.nextInt(s + 1);
                                int temp[] = movesOption[index].clone();
                                movesOption[index] = movesOption[s];
                                movesOption[s] = temp.clone();
                        }
                        while(getMove());
                }
        }
}