package Maman11;
import java.util.Scanner;

public class Knight {
    /**
     * This program gets an input from the user, represents the location of a knight
     * inside a board. First, it checks if the location is on the board, and if it is
     * it calculates all its possible moves.
     * @className Knight
     * @author Kobi Shabaton
     * @version 2022a
     * @date 22/3/2022
     */
    public static void main(String[] args) {
        // Constants
        final int MIN_CELL = 0;
        final int MAX_CELL = 9;
        // Getting input from the user.
        int tempRow, tempCol;
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "This program reads two integers which " + "represent the knight's location on the chess board: ");
        System.out.println("Please enter the number of row");
        int row = scan.nextInt();
        System.out.println("Please enter the number of column");
        int col = scan.nextInt();

        // Checking weather the input is in bounds.
        if (row > MIN_CELL && row < MAX_CELL  && col > MIN_CELL && col < MAX_CELL) {
            // This section calculates a legal input moves options.
            System.out.println("Moves:");
            // Option one
            tempCol = col - 1;
            tempRow = row - 2;
            if (tempRow > MIN_CELL && tempRow < MAX_CELL  && tempCol > MIN_CELL && tempCol < MAX_CELL) {
                System.out.println(tempRow + " " + tempCol);
            }
            // Option two
            tempCol = col - 2;
            tempRow = row - 1;
            if (tempRow > MIN_CELL && tempRow < MAX_CELL  && tempCol > MIN_CELL && tempCol < MAX_CELL) {
                System.out.println(tempRow + " " + tempCol);
            }
            // Option three
            tempCol = col - 2;
            tempRow = row + 1;
            if (tempRow > MIN_CELL && tempRow < MAX_CELL  && tempCol > MIN_CELL && tempCol < MAX_CELL) {
                System.out.println(tempRow + " " + tempCol);
            }
            // Option four
            tempCol = col - 1;
            tempRow = row + 2;
            if (tempRow > MIN_CELL && tempRow < MAX_CELL  && tempCol > MIN_CELL && tempCol < MAX_CELL) {
                System.out.println(tempRow + " " + tempCol);
            }
            // Option five
            tempCol = col + 1;
            tempRow = row + 2;
            if (tempRow > MIN_CELL && tempRow < MAX_CELL  && tempCol > MIN_CELL && tempCol < MAX_CELL) {
                System.out.println(tempRow + " " + tempCol);
            }
            // Option six
            tempCol = col + 2;
            tempRow = row + 1;
            if (tempRow > MIN_CELL && tempRow < MAX_CELL  && tempCol > MIN_CELL && tempCol < MAX_CELL) {
                System.out.println(tempRow + " " + tempCol);
            }
            // Option seven
            tempCol = col + 2;
            tempRow = row - 1;
            if (tempRow > MIN_CELL && tempRow < MAX_CELL  && tempCol > MIN_CELL && tempCol < MAX_CELL) {
                System.out.println(tempRow + " " + tempCol);
            }
            // Option eight
            tempCol = col + 1;
            tempRow = row - 2;
            if (tempRow > MIN_CELL && tempRow < MAX_CELL  && tempCol > MIN_CELL && tempCol < MAX_CELL) {
                System.out.println(tempRow + " " + tempCol);
            }
        }
        else {
            System.out.println("input is illegal");
        }
    } // end of method main
} // end of class Knight
