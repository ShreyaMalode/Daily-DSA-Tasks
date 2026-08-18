// Grid Unique Paths : DP on Grids (DP8)

class GridUniquePaths {

    /*
     * Problem Statement:
     * Given two integers m and n, representing the number of rows and columns
     * of a 2d array named matrix.
     *
     * Return the number of unique ways to go from the top-left cell
     * (matrix[0][0]) to the bottom-right cell (matrix[m-1][n-1]).
     *
     * Movement is allowed only in two directions from a cell:
     * right and bottom.
     *
     * Example:
     * Input:
     * m = 3
     * n = 7
     *
     * Output:
     * 28
     */

    public static void main(String[] args) {

        // 3 rows aur 7 columns ka grid
        int m = 3;
        int n = 7;

        int result = uniquePaths(m, n);

        System.out.println("Number of Unique Paths: " + result);
    }

    static int uniquePaths(int m, int n) {

        // dp[i][j] = (i,j) cell tak pahunchne ke total ways.
        int[][] dp = new int[m][n];

        // First row mein sirf right move kar sakte hain.
        // Isliye har cell tak sirf 1 way hai.
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // First column mein sirf bottom move kar sakte hain.
        // Isliye har cell tak sirf 1 way hai.
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // Baaki cells ke liye:
        // current cell tak ways =
        // upar wale cell ke ways + left wale cell ke ways
        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Last cell mein total unique paths mil jayenge.
        return dp[m - 1][n - 1];
    }
}