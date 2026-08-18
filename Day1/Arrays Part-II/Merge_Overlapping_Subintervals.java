// Merge Overlapping Sub-intervals
class Merge_Overlapping_Subintervals {

    /*
     * Problem Statement:
     * Given an array of intervals where intervals[i] = [starti, endi],
     * merge all overlapping intervals and return an array of the
     * non-overlapping intervals that cover all the intervals in the input.
     *
     * Example:
     *
     * Input:
     * [1,3] [2,6] [8,10] [15,18]
     *
     * Output:
     * [1,6] [8,10] [15,18]
     *
     * Explanation:
     * [1,3] and [2,6] overlap,
     * so we merge them into [1,6].
     */

    public static void merge(int[][] intervals) {

        // Pehle intervals ko starting value ke according sort karo.
        // Matlab jis interval ka start chhota hai,
        // woh pehle aayega.
        java.util.Arrays.sort(intervals,
            (a, b) -> Integer.compare(a[0], b[0]));

        // First interval ko current interval maan lo.
        int start = intervals[0][0];
        int end = intervals[0][1];

        System.out.println("Merged Intervals:");

        // Baaki ke intervals ko ek-ek karke check karo.
        for (int i = 1; i < intervals.length; i++) {

            // Agar current interval ka starting point
            // current end se chhota ya equal hai,
            // iska matlab dono intervals overlap kar rahe hain.
            if (intervals[i][0] <= end) {

                // End ko maximum end value se update karo.
                end = Math.max(end, intervals[i][1]);

            } else {

                // Agar overlap nahi hai,
                // to previous merged interval print karo.
                System.out.println("[" + start + ", " + end + "]");

                // Ab current interval ko new interval bana do.
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Last merged interval print karo.
        System.out.println("[" + start + ", " + end + "]");
    }

    public static void main(String[] args) {

        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        // Merge function call karo.
        merge(intervals);
    }
}