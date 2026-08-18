// Merge two Sorted Arrays Without Extra Space
class Merge_Sorted_Arrays {

    /*
     * Problem Statement:
     * Given two sorted integer arrays nums1 and nums2,
     * merge both the arrays into a single array sorted
     * in non-decreasing order.
     *
     * The final sorted array should be stored inside nums1
     * and it should be done in-place.
     *
     * Array nums1 has a length of m + n, where the first
     * m elements contain the actual elements of nums1 and
     * the remaining n elements are 0s.
     *
     * nums2 has a length of n.
     *
     * Example:
     *
     * nums1 = [1, 2, 3, 0, 0, 0]
     * nums2 = [2, 5, 6]
     *
     * Output:
     * nums1 = [1, 2, 2, 3, 5, 6]
     */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // i points to the last actual element of nums1.
        int i = m - 1;

        // j points to the last element of nums2.
        int j = n - 1;

        // k points to the last position of nums1.
        // Yahi se hum elements ko fill karenge.
        int k = m + n - 1;

        // Jab tak nums2 ke elements baaki hain,
        // tab tak comparison karte rahenge.
        while (j >= 0) {

            // Agar nums1 ka element bada hai,
            // to usko last position par rakho.
            if (i >= 0 && nums1[i] > nums2[j]) {

                nums1[k] = nums1[i];

                i--;

            } else {

                // Otherwise nums2 ka element last position par rakho.
                nums1[k] = nums2[j];

                j--;
            }

            // Next empty position par jao.
            k--;
        }
    }

    public static void main(String[] args) {

        // nums1 ki length m + n hai.
        // Pehle m elements actual elements hain.
        // Last n positions empty hain (0).
        int[] nums1 = {1, 2, 3, 0, 0, 0};

        int[] nums2 = {2, 5, 6};

        int m = 3;
        int n = 3;

        // Merge function call karo.
        merge(nums1, m, nums2, n);

        // Final sorted nums1 print karo.
        System.out.print("Merged Array: ");

        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }
}