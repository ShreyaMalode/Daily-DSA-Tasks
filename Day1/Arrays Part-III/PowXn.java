// Implement Pow(x, n)

class PowXn {

    /*
     * Problem Statement:
     * Implement the power function pow(x, n), which calculates the x raised
     * to n i.e. x^n.
     *
     * Example:
     * Input:
     * x = 2.0
     * n = 10
     *
     * Output:
     * 1024.0
     */

    public static void main(String[] args) {

        // Simple input
        double x = 2.0;
        int n = 10;

        double result = power(x, n);

        System.out.println("Answer: " + result);
    }

    // x^n calculate karne ka function
    static double power(double x, int n) {

        // long use kar rahe hain because Integer.MIN_VALUE ka issue ho sakta hai.
        long exponent = n;

        // Agar exponent negative hai,
        // x^(-n) = 1 / x^n
        if (exponent < 0) {
            x = 1 / x;
            exponent = -exponent;
        }

        double result = 1;

        // Binary Exponentiation
        while (exponent > 0) {

            // Agar exponent odd hai to current x answer mein multiply hoga.
            if (exponent % 2 == 1) {
                result = result * x;
            }

            // x ko square kar rahe hain.
            x = x * x;

            // Exponent ko half kar rahe hain.
            exponent = exponent / 2;
        }

        return result;
    }
}