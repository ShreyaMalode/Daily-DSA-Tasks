// Program to generate Pascal's Triangle
class Pascals_Triangle {

    /*
     * Problem Statement:
     * Write a program to generate Pascal's Triangle.
     *
     * In Pascal's Triangle, each number is the sum
     * of the two numbers directly above it.
     *
     * Example:
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     */

    public static void generate(int n) {

        // Previous row ko store karenge
        int[] previous = new int[n];

        for (int i = 0; i < n; i++) {

            // Current row ka array
            int[] current = new int[i + 1];

            // Har row ka first element 1 hota hai
            current[0] = 1;

            // Har row ka last element bhi 1 hota hai
            current[i] = 1;

            // Middle elements calculate karo
            for (int j = 1; j < i; j++) {

                // Upper-left + upper-right
                current[j] = previous[j - 1] + previous[j];
            }

            // Current row print karo
            for (int j = 0; j < current.length; j++) {
                System.out.print(current[j] + " ");
            }

            System.out.println();

            // Current row next iteration ke liye previous row banegi
            previous = current;
        }
    }

    public static void main(String[] args) {

        int n = 5;

        generate(n);
    }
}