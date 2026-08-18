// Find the repeating and missing numbers
class Find_Repeating_Missing {

    /*
     * Problem Statement:
     * Given an integer array nums of size n containing values
     * from [1, n], each value appears exactly once except:
     *
     * A number appears twice (Repeating Number)
     * and B number is missing.
     *
     * Return A and B in an array of size 2.
     *
     * A should be at 0-th index and B should be at 1st index.
     *
     * Note:
     * We are not allowed to modify the original array.
     *
     * Example:
     *
     * Input:
     * [4, 3, 6, 2, 1, 1]
     *
     * Output:
     * Repeating = 1
     * Missing = 5
     */

    public static int[] findNumbers(int[] nums) {

        int n = nums.length;

        // Frequency array banayenge.
        // frequency[i] batayega ki number i kitni baar aaya.
        //
        // Original array ko modify nahi kar rahe hain.
        int[] frequency = new int[n + 1];

        // Har number ki frequency count karo.
        for (int i = 0; i < n; i++) {

            frequency[nums[i]]++;
        }

        int repeating = -1;
        int missing = -1;

        // 1 se n tak check karo.
        for (int i = 1; i <= n; i++) {

            // Agar number 2 times aaya hai,
            // to ye repeating number hai.
            if (frequency[i] == 2) {
                repeating = i;
            }

            // Agar number ek bhi baar nahi aaya,
            // to ye missing number hai.
            if (frequency[i] == 0) {
                missing = i;
            }
        }

        // Index 0 = Repeating
        // Index 1 = Missing
        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {

        int[] nums = {4, 3, 6, 2, 1, 1};

        // Repeating aur missing number find karo.
        int[] result = findNumbers(nums);

        System.out.println("Repeating Number = " + result[0]);
        System.out.println("Missing Number = " + result[1]);
    }
}