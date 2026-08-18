// Count Reverse Pairs

class CountReversePairs {

    /*
     * Problem Statement:
     * Given an array of numbers, you need to return the count of reverse pairs.
     *
     * Reverse Pairs are those pairs where i < j and arr[i] > 2 * arr[j].
     *
     * Example:
     * Input:
     * arr = {1, 3, 2, 3, 1}
     *
     * Output:
     * 2
     *
     * Explanation:
     * Reverse pairs are:
     * (3, 1) at indexes (1, 4)
     * (3, 1) at indexes (3, 4)
     */

    public static void main(String[] args) {

        // Simple input array
        int[] arr = {1, 3, 2, 3, 1};

        int result = countReversePairs(arr);

        System.out.println("Number of Reverse Pairs: " + result);
    }

    static int countReversePairs(int[] arr) {

        return mergeSort(arr, 0, arr.length - 1);
    }

    // Merge Sort ke through reverse pairs count karenge.
    static int mergeSort(int[] arr, int low, int high) {

        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;

        // Left aur right part mein reverse pairs count karo.
        int count = 0;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);

        // Left aur right part ke beech reverse pairs count karo.
        count += countPairs(arr, low, mid, high);

        // Dono parts ko sorted form mein merge karo.
        merge(arr, low, mid, high);

        return count;
    }

    static int countPairs(int[] arr, int low, int mid, int high) {

        int right = mid + 1;
        int count = 0;

        // Left part ke har element ko check karenge.
        for (int i = low; i <= mid; i++) {

            // long use kiya hai taaki 2 * arr[right] mein
            // integer overflow na ho.
            while (right <= high && (long) arr[i] > 2L * arr[right]) {
                right++;
            }

            // right - (mid + 1) = valid reverse pairs
            count += right - (mid + 1);
        }

        return count;
    }

    static void merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int index = 0;

        // Left aur right sorted arrays ko merge karenge.
        while (left <= mid && right <= high) {

            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } 
            else {
                temp[index] = arr[right];
                right++;
            }

            index++;
        }

        // Agar left part mein elements bache hain.
        while (left <= mid) {
            temp[index] = arr[left];
            left++;
            index++;
        }

        // Agar right part mein elements bache hain.
        while (right <= high) {
            temp[index] = arr[right];
            right++;
            index++;
        }

        // Temporary array ko original array mein copy karo.
        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
    }
}