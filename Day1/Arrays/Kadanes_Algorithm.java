// Kadane's Algorithm : Maximum Subarray Sum in an Array
class Kadanes_Algorithm {

    /*
     * Problem Statement:
     * Given an integer array nums, find the subarray
     * with the largest sum and return that sum.
     *
     * A subarray is a contiguous non-empty sequence
     * of elements within an array.
     *
     * Example:
     * Input:  [-2, 1, -3, 4, -1, 2, 1, -5, 4]
     * Output: 6
     *
     * Maximum subarray:
     * [4, -1, 2, 1]
     *
     * Sum = 6
     */

    public static int maxSubArray(int[] nums) {

        // First element se current sum start karenge
        int currentSum = nums[0];

        // First element ko maximum sum bhi maanenge
        int maxSum = nums[0];

        // Second element se loop start karo
        for (int i = 1; i < nums.length; i++) {

            // Decide karo:
            // New subarray start karein
            // ya previous subarray continue karein
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Maximum sum update karo
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = maxSubArray(nums);

        System.out.println("Maximum Sum = " + result);
    }
}