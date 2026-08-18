// Rotate Image by 90 degree
class Rotate_Matrix_90 {

    /*
     * Problem Statement:
     * Given an N * N 2D integer matrix, rotate the matrix
     * by 90 degrees clockwise.
     *
     * The rotation must be done in place, meaning the input
     * 2D matrix must be modified directly.
     *
     * Example:
     *
     * Input:
     * 1 2 3
     * 4 5 6
     * 7 8 9
     *
     * Output:
     * 7 4 1
     * 8 5 2
     * 9 6 3
     */

    public static void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Transpose the matrix
        // Row ko column aur column ko row bana rahe hain.
        for (int i = 0; i < n; i++) {

            // i + 1 se start karenge,
            // taaki same elements ko dobara swap na karein.
            for (int j = i + 1; j < n; j++) {

                // matrix[i][j] aur matrix[j][i] ko swap karo
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Har row ko reverse karo
        // Transpose + Reverse each row = 90 degree clockwise rotation.
        for (int i = 0; i < n; i++) {

            int start = 0;
            int end = n - 1;

            while (start < end) {

                // First aur last element ko swap karo.
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;

                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Matrix ko 90 degree clockwise rotate karo.
        rotate(matrix);

        // Rotated matrix print karo.
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}