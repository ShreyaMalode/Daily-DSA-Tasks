// next_permutation : find next lexicographically greater permutation
class Next_Permutation {

    /*
     * Problem Statement:
     * Given an array of integers, rearrange the numbers
     * into the lexicographically next greater permutation.
     *
     * If the next greater permutation is not possible,
     * rearrange the array into the lowest possible order,
     * i.e. sorted in ascending order.
     *
     * Example:
     * Input:  1 2 3
     * Output: 1 3 2
     */

    public static void nextPermutation(int[] arr) {

        int n = arr.length;

        // Step 1: Right se pehla element find karo
        // jo apne next element se chhota ho.
        int pivot = -1;

        for (int i = n - 2; i >= 0; i--) {

            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        // Agar pivot nahi mila,
        // array already largest permutation hai.
        // Isliye reverse karke smallest permutation banao.
        if (pivot == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        // Step 2: Right se pivot se bada element find karo
        for (int i = n - 1; i > pivot; i--) {

            if (arr[i] > arr[pivot]) {

                swap(arr, pivot, i);
                break;
            }
        }

        // Step 3: Pivot ke right side ko reverse karo
        reverse(arr, pivot + 1, n - 1);
    }

    // Do elements ko swap karne ka method
    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Array ke given part ko reverse karo
    public static void reverse(int[] arr, int start, int end) {

        while (start < end) {

            swap(arr, start, end);

            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        nextPermutation(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}