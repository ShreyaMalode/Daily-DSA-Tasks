// Count inversions in an array
class Inversion_Of_Array {

    /*
     * Problem Statement:
     * Given an array of N integers, count the number
     * of inversions in the array using Merge Sort.
     *
     * Inversion of an array:
     *
     * For any two indices i and j:
     *
     * i < j
     * and
     * A[i] > A[j]
     *
     * then (A[i], A[j]) is called an inversion.
     *
     * Example:
     *
     * Input:
     * [5, 3, 2, 4, 1]
     *
     * Output:
     * 7
     *
     * Explanation:
     * Inversions are:
     *
     * (5,3)
     * (5,2)
     * (5,4)
     * (5,1)
     * (3,2)
     * (3,1)
     * (2,1)
     *
     * Total = 7
     */

    public static int countInversions(int[] arr) {

        // Merge Sort use karke inversion count karenge.
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int low, int high) {

        // Agar sirf ek element hai,
        // to inversion possible nahi hai.
        if (low >= high) {
            return 0;
        }

        // Array ko two halves me divide karo.
        int mid = (low + high) / 2;

        // Left half ke inversions count karo.
        int count = mergeSort(arr, low, mid);

        // Right half ke inversions count karo.
        count = count + mergeSort(arr, mid + 1, high);

        // Dono halves ko merge karo
        // aur cross inversions count karo.
        count = count + merge(arr, low, mid, high);

        return count;
    }

    public static int merge(int[] arr, int low, int mid, int high) {

        int i = low;
        int j = mid + 1;

        int count = 0;

        // Temporary array banayenge merge karne ke liye.
        int[] temp = new int[high - low + 1];

        int k = 0;

        // Dono halves ke elements compare karo.
        while (i <= mid && j <= high) {

            // Agar left element chhota ya equal hai,
            // to directly temp array me daalo.
            if (arr[i] <= arr[j]) {

                temp[k] = arr[i];

                i++;

            } else {

                // Agar arr[i] > arr[j],
                // to left half ke arr[i] se lekar mid tak
                // ke saare elements arr[j] se bade honge.
                //
                // Isliye:
                // mid - i + 1 inversions milenge.
                count = count + (mid - i + 1);

                temp[k] = arr[j];

                j++;
            }

            k++;
        }

        // Agar left half me elements bach gaye.
        while (i <= mid) {

            temp[k] = arr[i];

            i++;
            k++;
        }

        // Agar right half me elements bach gaye.
        while (j <= high) {

            temp[k] = arr[j];

            j++;
            k++;
        }

        // Sorted elements ko original array me copy karo.
        for (int x = 0; x < temp.length; x++) {

            arr[low + x] = temp[x];
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {5, 3, 2, 4, 1};

        // Total inversions count karo.
        int result = countInversions(arr);

        System.out.println("Number of Inversions = " + result);
    }
}