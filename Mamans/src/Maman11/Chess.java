package Maman11;
import java.util.Scanner;

public class Chess {
    /**
     * This class gets two chars - one for each pawn type(Bishop, Knight, ot a rook), and it's positions.
     * It checks if one of the pawns threats the other.
     * In case that they are the from same type, has the same position, or out of bounds, it prints
     * An indecative error message. In case that the input is ok it checks if one of theam threats the other and if
     * it is, it prints the threat. When there is no therat it prints that there is no threat.
     * @className Chess
     * @author Kobi Shabaton
     * @version 2022a
     * @date 22/3/2022
     */
    public static void main(String[] args) {
        // Variables
        int rowDiff, colDiff, knightTempRow, knightTempCol;
        String firstPawnName, secondPawnName;
        boolean isThreat = false;
        char knight = 'k';
        char rook = 'r';
        char bishop = 'b';
        final int MIN_CELL = 0;
        final int MAX_CELL = 9;

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the type" +
                " of the first chessman");
        char first = scan.next().charAt(0);
        System.out.println("Please enter the number of row");
        int row1 = scan.nextInt();
        System.out.println("Please enter the number of column");
        int col1 = scan.nextInt();
        System.out.println("Please enter the type" +
                " of the second chessman");
        char second = scan.next().charAt(0);
        System.out.println("Please enter the number of row");
        int row2 = scan.nextInt();
        System.out.println("Please enter the number of column");
        int col2 = scan.nextInt();

        // Checking if the pawns are from the same type
        if (first == second) {
            System.out.println("Chessmen should be different from each other");
        }
        // Checking if one of the positions are not in the board
        else if (row1 <= MIN_CELL || row1 >= MAX_CELL ||
                row2 <= MIN_CELL || row2 >= MAX_CELL ||
                col1 <= MIN_CELL || col1 >= MAX_CELL ||
                col2 <= MIN_CELL || col2 >= MAX_CELL) {
            System.out.println("Position is not legal");
        }
        // Checking if the pawns has the same position
        else if (row1 == row2 && col1 == col2) {
            System.out.println("Chessmen positions should not be identical");
        }
        else{
            if(first == knight){
                // If the first one in a knight, the second must be a bishop or a rook.
                if(second == rook)
                    secondPawnName = "rook";
                else
                    secondPawnName = "bishop";
                // Option one
                knightTempCol = col1 - 1;
                knightTempRow = row1 - 2;
                if (knightTempRow > MIN_CELL && knightTempRow < MAX_CELL
                        && knightTempCol > MIN_CELL && knightTempCol < MAX_CELL) {
                    if(knightTempCol == col2 && knightTempRow == row2){
                        isThreat = true;
                        System.out.println("knight threats " + secondPawnName);
                    }
                }
                // Option two
                knightTempCol = col1 - 2;
                knightTempRow = row1 - 1;
                if (knightTempRow > MIN_CELL && knightTempRow < MAX_CELL
                        && knightTempCol > MIN_CELL && knightTempCol < MAX_CELL) {
                    if(knightTempCol == col2 && knightTempRow == row2){
                        isThreat = true;
                        System.out.println("knight threats " + secondPawnName);
                    }
                }
                // Option three
                knightTempCol = col1 - 2;
                knightTempRow = row1 + 1;
                if (knightTempRow > MIN_CELL && knightTempRow < MAX_CELL
                        && knightTempCol > MIN_CELL && knightTempCol < MAX_CELL) {
                    if(knightTempCol == col2 && knightTempRow == row2){
                        isThreat = true;
                        System.out.println("knight threats " + secondPawnName);
                    }
                }
                // Option four
                knightTempCol = col1 - 1;
                knightTempRow = row1 + 2;
                if (knightTempRow > MIN_CELL && knightTempRow < MAX_CELL
                        && knightTempCol > MIN_CELL && knightTempCol < MAX_CELL) {
                    if(knightTempCol == col2 && knightTempRow == row2){
                        isThreat = true;
                        System.out.println("knight threats " + secondPawnName);
                    }
                }
                // Option five
                knightTempCol = col1 + 1;
                knightTempRow = row1 + 2;
                if (knightTempRow > MIN_CELL && knightTempRow < MAX_CELL
                        && knightTempCol > MIN_CELL && knightTempCol < MAX_CELL) {
                    if(knightTempCol == col2 && knightTempRow == row2){
                        isThreat = true;
                        System.out.println("knight threats " + secondPawnName);
                    }
                }
                // Option six
                knightTempCol = col1 + 2;
                knightTempRow = row1 + 1;
                if (knightTempRow > MIN_CELL && knightTempRow < MAX_CELL
                        && knightTempCol > MIN_CELL && knightTempCol < MAX_CELL) {
                    if(knightTempCol == col2 && knightTempRow == row2){
                        isThreat = true;
                        System.out.println("knight threats " + secondPawnName);
                    }
                }
                // Option seven
                knightTempCol = col1 + 2;
                knightTempRow = row1 - 1;
                if (knightTempRow > MIN_CELL && knightTempRow < MAX_CELL
                        && knightTempCol > MIN_CELL && knightTempCol < MAX_CELL) {
                    if(knightTempCol == col2 && knightTempRow == row2){
                        isThreat = true;
                        System.out.println("knight threats " + secondPawnName);
                    }
                }
                // Option eight
                knightTempCol = col1 + 1;
                knightTempRow = row1 - 2;
                if (knightTempRow > MIN_CELL && knightTempRow < MAX_CELL
                        && knightTempCol > MIN_CELL && knightTempCol < MAX_CELL) {
                    if(knightTempCol == col2 && knightTempRow == row2){
                        isThreat = true;
                        System.out.println("knight threats " + secondPawnName);
                    }
                }
            }
            else if(first == bishop){
                // If the first one in a bishop, the second must be a rook or a knight.
                if(second == rook)
                    secondPawnName = "rook";
                else
                    secondPawnName = "knight";
                rowDiff = row1 - row2;
                colDiff = col1 - col2;
                if(rowDiff < 0){
                    rowDiff = rowDiff * -1;
                }
                if(colDiff < 0){
                    colDiff = colDiff * -1;
                }
                if(rowDiff == colDiff){
                    isThreat = true;
                    System.out.println("bishop threats " + secondPawnName);
                }
            }
            else if (first == rook) {
                // If the first one in a rook, the second must be a bishop or a knight.
                if(second == bishop)
                    secondPawnName = "bishop";
                else
                    secondPawnName = "knight";
                if(col1 == col2 || row1 == row2){
                    isThreat = true;
                    System.out.println("rook threats " + secondPawnName);
                }
            }
            if(second == knight){
                // If the second one in a knight, the first must be a bishop or a rook.
                if(first == rook)
                    firstPawnName = "rook";
                else
                    firstPawnName = "bishop";
                // Option one
                knightTempCol = col2 - 1;
                knightTempRow = row2 - 2;
                if (knightTempRow > MIN_CELL && knightTempRow < MAX_CELL
                        && knightTempCol > MIN_CELL && knightTempCol < MAX_CELL) {
                    if(knightTempCol == col1 && knightTempRow == row1){
                        isThreat = true;
                        System.out.println("knight threats " + firstPawnName);
                    }
                }
                // Option two
                knightTempCol = col2 - 2;
                knightTempRow = row2 - 1;
                if (knightTempRow > MIN_CELL && knightTempRow < MAX_CELL
                        && knightTempCol > MIN_CELL && knightTempCol < MAX_CELL) {
                    if(knightTempCol == col1 && knightTempRow == row1){
                        isThreat = true;
                        System.out.println("knight threats " + firstPawnName);
                    }
                }
                // Option three
                knightTempCol = col2 - 2;
                knightTempRow = row2 + 1;
                if (knightTempRow > MIN_CELL && knightTempRow < MAX_CELL
                        && knightTempCol > MIN_CELL && knightTempCol < MAX_CELL) {
                    if(knightTempCol == col1 && knightTempRow == row1){
                        isThreat = true;
                        System.out.println("knight threats " + firstPawnName);
                    }
                }
                // Option four
                knightTempCol = col2 - 1;
                knightTempRow = row2 + 2;
                if (knightTempRow > MIN_CELL && knightTempRow < MAX_CELL
                        && knightTempCol > MIN_CELL && knightTempCol < MAX_CELL) {
                    if(knightTempCol == col1 && knightTempRow == row1){
                        isThreat = true;
                        System.out.println("knight threats " + firstPawnName);
                    }
                }
                // Option five
                knightTempCol = col2 + 1;
                knightTempRow = row2 + 2;
                if (knightTempRow > MIN_CELL && knightTempRow < MAX_CELL
                        && knightTempCol > MIN_CELL && knightTempCol < MAX_CELL) {
                    if(knightTempCol == col1 && knightTempRow == row1){
                        isThreat = true;
                        System.out.println("knight threats " + firstPawnName);
                    }
                }
                // Option six
                knightTempCol = col2 + 2;
                knightTempRow = row2 + 1;
                if (knightTempRow > MIN_CELL && knightTempRow < MAX_CELL
                        && knightTempCol > MIN_CELL && knightTempCol < MAX_CELL) {
                    if(knightTempCol == col1 && knightTempRow == row1){
                        isThreat = true;
                        System.out.println("knight threats " + firstPawnName);
                    }
                }
                // Option seven
                knightTempCol = col2 + 2;
                knightTempRow = row2 - 1;
                if (knightTempRow > MIN_CELL && knightTempRow < MAX_CELL
                        && knightTempCol > MIN_CELL && knightTempCol < MAX_CELL) {
                    if(knightTempCol == col1 && knightTempRow == row1){
                        isThreat = true;
                        System.out.println("knight threats " + firstPawnName);
                    }
                }
                // Option eight
                knightTempCol = col2 + 1;
                knightTempRow = row2 - 2;
                if (knightTempRow > MIN_CELL && knightTempRow < MAX_CELL
                        && knightTempCol > MIN_CELL && knightTempCol < MAX_CELL) {
                    if(knightTempCol == col1 && knightTempRow == row1){
                        isThreat = true;
                        System.out.println("knight threats " + firstPawnName);
                    }
                }
            }
            else if(second == bishop){
                // If the second one in a bishop, the first must be a rook or a knight.
                if(first == rook)
                    firstPawnName = "rook";
                else
                    firstPawnName = "knight";
                rowDiff = row2 - row1;
                colDiff = col2 - col1;
                if(rowDiff < 0){
                    rowDiff = rowDiff * -1;
                }
                if(colDiff < 0){
                    colDiff = colDiff * -1;
                }
                if(rowDiff == colDiff){
                    isThreat = true;
                    System.out.println("bishop threats " + firstPawnName);
                }
            }
            else if (second == rook) {
                // If the second one in a rook, the first must be a bishop or a knight.
                if(first == bishop)
                    firstPawnName = "bishop";
                else
                    firstPawnName = "knight";
                if(col1 == col2 || row1 == row2){
                    isThreat = true;
                    System.out.println("rook threats " + firstPawnName);
                }
            }
            if(isThreat == false){
                System.out.println("no threat");
            }
        }
    } // end of method main
} // end of class Chess
