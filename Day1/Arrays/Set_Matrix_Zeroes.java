// Set Matrix Zero
class Set_Matrix_Zeroes {

    /*
     * Problem Statement:
     * Given a matrix, if an element in the matrix is 0,
     * set its entire row and column to 0.
     *
     * Example:
     * Input:
     * 1 2 3
     * 4 0 6
     * 7 8 9
     *
     * Output:
     * 1 0 3
     * 0 0 0
     * 7 0 9
     */

    public static void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Ye arrays batayenge ki kaunsi row aur column me 0 hai
        boolean[] row = new boolean[rows];
        boolean[] col = new boolean[cols];

        // Step 1: 0 ko find karo
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Step 2: Marked rows aur columns ko 0 karo
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 2, 3},
            {4, 0, 6},
            {7, 8, 9}
        };

        setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}