// Find the duplicate in an array of N+1 integers
class Find_Duplicate_Number {

    /*
     * Problem Statement:
     * Given an array of N + 1 size, where each element is
     * between 1 and N.
     *
     * Assuming there is only one duplicate number,
     * find the duplicate number.
     *
     * Example:
     *
     * Input:
     * [1, 3, 4, 2, 2]
     *
     * Output:
     * 2
     *
     * Explanation:
     * The number 2 appears more than once,
     * so the duplicate number is 2.
     */

    public static int findDuplicate(int[] nums) {

        // Slow pointer aur fast pointer ko first element se start karo.
        int slow = nums[0];
        int fast = nums[0];

        // Step 1:
        // Slow ek step chalega aur fast two steps chalega.
        // Ye dono ek point par milenge.
        do {

            slow = nums[slow];

            fast = nums[nums[fast]];

        } while (slow != fast);

        // Step 2:
        // Slow ko starting position par wapas le aao.
        slow = nums[0];

        // Ab slow aur fast dono ek-ek step chalenge.
        while (slow != fast) {

            slow = nums[slow];
            fast = nums[fast];
        }

        // Jahan slow aur fast milte hain,
        // wahi duplicate number hai.
        return slow;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 2, 2};

        // Duplicate number find karo.
        int result = findDuplicate(nums);

        System.out.println("Duplicate Number = " + result);
    }
}