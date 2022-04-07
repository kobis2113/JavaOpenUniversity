package Maman14;


import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex14 {
    private static final int MIN = 0;
    public static boolean what(int [][] m)
    {
        int n = m.length;
        for (int x = 0; x < n; x++)
            for (int y = 0; y < (n - 1); y++)
                if (m[x][y] > m[x][y + 1]) return false;
        for (int x = 0; x < n; x++)
            for (int y = 0; y < (n - 1); y++)
                if (m[y][x] > m[y + 1][x]) return false;
        return true;
    }

    public static boolean riddle(int [][] m, int val)
    {
        int n = m.length;
        for(int x=0; x<n; x++)
            for (int y=0; y<n; y++)
                if(m[x][y] == val) return true;
        return false;
    }
    public static boolean test(int [][] m) {
        int n = m.length;
        for (int r = 0; r < (n - 1); r++)
            for (int c = 0; c < n; c++)
                for (int i = 0; i < n; i++)
                    if (m[r][c] > m[r + 1][i]) return false;
        return true;
    }

    /**
     * This method goes over an array, and checks if a given value is in this array.
     * It's complexity is o(n).
     * @param m An array that returns true on method `What`
     * @param val The value we want to check if exists in the array.
     * @complexity The time complexity is o(n) because we can allow ourselves run diagonally,
     * because we know that the array returns true on What method, so we can only check if the next diagonal cell
     * is bigger then val, and if it is not we can jump to next diagonal cell and by that we don't need to go over the
     * whole array. By doing that, in the worst case we will run over the diagonal, and 2 times n (one horizontally and
     * one vertically) -> o(n).
     * @return True if the value is in the array and False if its not.
     */
    public static boolean findValWhat (int [][] m, int val){
        // Get array length
        int arrayLength = m.length;

        // Loop over the array len
        for( int index = MIN; index < arrayLength-1; index++){
            // Check if the current diagonal equals val
            if(m[index][index] == val) return true;
            if(m[index+1][index+1] > val){
                // Going over the specific row from the index and checking if val is there.
                for( int rowPivot = MIN; rowPivot <= index; rowPivot++)
                    if(m[rowPivot][index+1] == val)
                        return true;
                // Going over the specific col from the index and checking if val is there.
                for( int colPivot = MIN; colPivot <= index; colPivot++)
                    if(m[index+1][colPivot] == val)
                        return true;
            }
        }
        // Checking the last cell in the array
        return m[arrayLength - 1][arrayLength - 1] == val;
    }

    /**
     * This method goes over an array, and checks if a given value is in this array.
     * It's complexity is o(n).
     * @param m An array that returns true on method `Test`
     * @param val The value we want to check if exists in the array.
     * @complexity The time complexity is o(n) because we can allow ourselves run on the first column,
     * because we know that the array returns true on Test method, so we can only check if the next column cell
     * is bigger then val, and if it is not we can jump to next column cell and by that we don't need to go over the
     * whole array. By doing that, in the worst case we will run over the first column, and then over the last two rows -> o(n).
     * @return True if the value is in the array and False if its not.
     */
    public static boolean findValTest (int [][] m, int val) {
        // Get the length of the array
        int arrayLength = m.length;

        // Looping over the first column
        for (int index = MIN; index < arrayLength - 1; index++) {
            // Check if the current cell equals val
            if (m[index][MIN] == val) return true;
            // Check if the next cell in the col is greater then val
            if (m[index + 1][MIN] > val) {
                // The array isn't sorted so val can be in the current or next row
                // Loop over the current col to see if val is in there.
                for (int currentRowPivot = MIN; currentRowPivot < arrayLength; currentRowPivot++)
                    if (m[index][currentRowPivot] == val)
                        return true;
                // Loop over the next col to see if val is in there.
                for (int nextRowPivot = MIN; nextRowPivot < arrayLength; nextRowPivot++)
                    if (m[index + 1][nextRowPivot] == val)
                        return true;
            }
        }

        // Going over the last row since the previous for goes over the next row each
        // time so we won't enter the last row because we will get null exception.
        for (int rowPivot = MIN; rowPivot < arrayLength; rowPivot++)
            if (m[arrayLength-1][rowPivot] == val) return true;

        return false;
    }

    /**
     * This method gets the number of all high order sorted sub arrays in the given array.
     * Example: this array: {1,2,4,4,5} -> {1, 2}, {1, 2, 4}, {2, 4}, {4, 5}
     * @param a The array that we want to get it's high order sorted sub arrays.
     * @complexity The time complexity is o(n) because in the worst case we run over the array once, and using
     * our help method called subArrayFormula a few times which is in the worst case o(n) so o(2n) => o(n)
     * @return The number of all high order sorted sub arrays in the given array
     */
    public static int strictlyIncreasing (int[] a){
        int sortedSubArraysCounter = MIN;
        int tempLongestSequence = 1;
        // Going over the array and checking if the next cell is greater then the current one
        for(int pivot = MIN; pivot < a.length-1; pivot++){
            if(a[pivot] < a[pivot+1])
                tempLongestSequence ++;
            else {
                sortedSubArraysCounter += subArrayFormula(tempLongestSequence);
                tempLongestSequence = MIN;
            }
        }

        // Calculating one last time because we are not going over the last cell,
        // In case that the array is always growing
        sortedSubArraysCounter += subArrayFormula(tempLongestSequence);
        return sortedSubArraysCounter;
    }

    // This method gets a number and returns the number of its sub arrays.
    // This method is o(n) because it runs one time from number to 1.
    private static int subArrayFormula(int number){
        int result = 0;
        int counter = 1;
        while(number > 1) {
            result += counter;
            counter++;
            number --;
        }
        return result;
    }

    /**
     * This method gets an array and calculates the length of the longest flat sequence inside it.
     * @param arr The array to get its longest flat sequence.
     * @return The length of the longest flat sequence inside the given array.
     */
    public static int longestFlatSequence (int[] arr){
        // if the length is less than 2 quit
        if(arr.length < 2){
            return MIN;
        }
        // checking the flat sequence length of the current array.
        int seqLen = lengthFlat(arr, 0, arr[0], arr[1] );

        // returns the max number between the current flat sequence to the recursive
        // call with a sliced array.
        return Math.max(
                longestFlatSequence(Arrays.copyOfRange(arr,
                        (seqLen > 0) ? seqLen : 1,
                        arr.length)),
                seqLen);

    }

    /**
     * This method calculates the flat sequence length of a given array.
     * @param arr The array to get it's flat sequence length.
     * @param index The index to start checking the sequence from.
     * @param firstNum The first number of the array.
     * @param secondNum The first number of the array.
     * @return The length of the flat sequence inside the array.
     */
    public static int lengthFlat (int [] arr, int index, int firstNum, int secondNum){
        // Checking if we reached to the end of the array.
        if(index == arr.length - 1){
            return (arr[index] != firstNum && arr[index] != secondNum) ? 0 : 1;
        }

        // Checking if the difference between the numbers are -1/0/-1.
        if(firstNum - secondNum > 1 || firstNum - secondNum < -1){
            return 0;
        }

        // In case that firstNum and secondNum are equal
        if(firstNum == secondNum && arr[index] != firstNum){
            // If the next number is different from firstNum or secondNum by more than 1
            if (firstNum - arr[index] > 1 || firstNum - arr[index] < -1){
                return 0;
            }
            // changing the second number to the other number in the sequence
            else{
                secondNum = arr[index];
            }
        }

        // checking if the current number is different then the two numbers in the sequence
        else if(arr[index] != firstNum && arr[index] != secondNum){
            return 0;
        }
        // calling the method recursively while increasing the index by 1
        return lengthFlat(arr, index + 1, firstNum, secondNum) + 1;
    }

    public static void main(String[] args) {
        // What - goes over each cell and checks if the cell next to him(right and below) is larger.
        // Riddle - checks if a given value is in the array
        // Test- checks if all the values in the next col in larger then each cell in the previous col
        System.out.println(strictlyIncreasing(new int[]{1,2,3}));
        System.out.println(subArrayFormula(7));
        /**
         * Question 1
         * A. 3, 5 are the right
         */
    }
}

