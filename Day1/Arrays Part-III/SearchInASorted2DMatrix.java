// Search in a Sorted 2D Matrix

class SearchInASorted2DMatrix {

    /*
     * Problem Statement:
     * You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M'
     * denote the number of rows and columns, respectively.
     *
     * The elements of each row are sorted in non-decreasing order.
     * Moreover, the first element of a row is greater than the last element
     * of the previous row (if it exists).
     *
     * You are given an integer 'target', and your task is to find if it exists
     * in the given 'mat' or not.
     *
     * Example:
     * Input:
     * mat = {
     *     {1, 3, 5, 7},
     *     {10, 11, 16, 20},
     *     {23, 30, 34, 60}
     * }
     * target = 3
     *
     * Output:
     * true
     */

    public static void main(String[] args) {

        // 2D matrix ka simple example
        int[][] mat = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target = 3;

        // Matrix ke total elements
        int rows = mat.length;
        int cols = mat[0].length;

        // Hum poori matrix ko ek sorted 1D array ki tarah treat karenge.
        int low = 0;
        int high = rows * cols - 1;

        boolean found = false;

        // Binary Search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // 1D index ko 2D row aur column mein convert kar rahe hain.
            int row = mid / cols;
            int col = mid % cols;

            if (mat[row][col] == target) {
                found = true;
                break;
            } 
            else if (mat[row][col] < target) {
                // Target right side mein hoga.
                low = mid + 1;
            } 
            else {
                // Target left side mein hoga.
                high = mid - 1;
            }
        }

        System.out.println("Target " + target + " exists: " + found);
    }
}