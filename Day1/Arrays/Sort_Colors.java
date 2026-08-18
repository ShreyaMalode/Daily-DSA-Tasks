// Sort an array of 0s, 1s and 2s
class Sort_Colors {

    /*
     * Problem Statement:
     * Given an array nums consisting only of 0, 1, and 2,
     * sort the array in non-decreasing order.
     *
     * The sorting must be done in-place,
     * without making a copy of the original array.
     *
     * Example:
     * Input:  [2, 0, 2, 1, 1, 0]
     * Output: [0, 0, 1, 1, 2, 2]
     */

    public static void sortColors(int[] nums) {

        // 0 ko left side rakhenge
        int low = 0;

        // Current element ko check karenge
        int mid = 0;

        // 2 ko right side rakhenge
        int high = nums.length - 1;

        while (mid <= high) {

            // Agar current element 0 hai
            if (nums[mid] == 0) {

                // 0 ko left side bhejo
                swap(nums, low, mid);

                low++;
                mid++;
            }

            // Agar current element 1 hai
            else if (nums[mid] == 1) {

                // 1 middle me rahega
                mid++;
            }

            // Agar current element 2 hai
            else {

                // 2 ko right side bhejo
                swap(nums, mid, high);

                high--;

                // Yaha mid++ nahi karna
                // Kyunki high se aaya element abhi check nahi hua
            }
        }
    }

    // Do elements ko swap karo
    public static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};

        sortColors(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}