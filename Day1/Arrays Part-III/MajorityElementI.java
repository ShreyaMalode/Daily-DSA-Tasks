// Majority Element-I

class MajorityElementI {

    /*
     * Problem Statement:
     * Given an integer array nums of size n, return the majority element
     * of the array.
     *
     * The majority element of an array is an element that appears more
     * than n/2 times in the array.
     *
     * The array is guaranteed to have a majority element.
     *
     * Example:
     * Input:
     * nums = {2, 2, 1, 1, 1, 2, 2}
     *
     * Output:
     * 2
     */

    public static void main(String[] args) {

        // Simple input array
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        int majorityElement = findMajorityElement(nums);

        System.out.println("Majority Element: " + majorityElement);
    }

    static int findMajorityElement(int[] nums) {

        // Initially first element ko candidate maan rahe hain.
        int candidate = nums[0];

        int count = 0;

        for (int num : nums) {

            // Agar count zero ho gaya,
            // current element ko new candidate bana do.
            if (count == 0) {
                candidate = num;
            }

            // Candidate same hai to count increase.
            if (num == candidate) {
                count++;
            } 
            else {
                // Different element mila to count decrease.
                count--;
            }
        }

        // Array mein majority element guaranteed hai,
        // isliye candidate hi answer hoga.
        return candidate;
    }
}