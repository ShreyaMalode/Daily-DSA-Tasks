// Majority Element-II

import java.util.ArrayList;

class MajorityElementII {

    /*
     * Problem Statement:
     * Given an integer array nums of size n.
     * Return all elements which appear more than n/3 times in the array.
     * The output can be returned in any order.
     *
     * Example:
     * Input:
     * nums = {1, 2, 2, 3, 2, 1, 1}
     *
     * Output:
     * [1, 2]
     */

    public static void main(String[] args) {

        // Simple input array
        int[] nums = {1, 2, 2, 3, 2, 1, 1};

        ArrayList<Integer> result = findMajorityElements(nums);

        System.out.println("Majority Elements: " + result);
    }

    static ArrayList<Integer> findMajorityElements(int[] nums) {

        ArrayList<Integer> result = new ArrayList<>();

        // N/3 se zyada baar maximum 2 elements hi aa sakte hain.
        int candidate1 = 0;
        int candidate2 = 0;

        int count1 = 0;
        int count2 = 0;

        // First pass: candidates find karenge.
        for (int num : nums) {

            if (count1 == 0 && num != candidate2) {
                candidate1 = num;
                count1++;
            } 
            else if (count2 == 0 && num != candidate1) {
                candidate2 = num;
                count2++;
            } 
            else if (num == candidate1) {
                count1++;
            } 
            else if (num == candidate2) {
                count2++;
            } 
            else {
                // Dono candidates se different number mila.
                // Dono counts decrease karenge.
                count1--;
                count2--;
            }
        }

        // Second pass: actual frequency check karna zaroori hai.
        count1 = 0;
        count2 = 0;

        for (int num : nums) {

            if (num == candidate1) {
                count1++;
            }

            if (num == candidate2) {
                count2++;
            }
        }

        // Actual frequency N/3 se greater hai ya nahi check karo.
        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }

        if (count2 > nums.length / 3 && candidate2 != candidate1) {
            result.add(candidate2);
        }

        return result;
    }
}