package problems.insert_interval;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class InsertIntervalLog {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        InsertIntervalLog insertIntervalLog = new InsertIntervalLog();
        System.out.println("result: " + Arrays.deepToString(insertIntervalLog.insert(intervals, newInterval)));
    }
    /**
     * Inserts a new interval into a list of sorted, non-overlapping intervals
     * and merges any overlapping intervals.
     *
     * @param intervals The original list of intervals (sorted by start time).
     * @param newInterval The new interval to be inserted.
     * @return A 2D array of intervals after insertion and merging.
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Initialize a list to store the resulting intervals
        List<int[]> result = new LinkedList<>();
        int i = 0;

        // Log the input for debugging
        System.out.println("Original intervals:");
        for (int[] interval : intervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
        System.out.println("New interval: [" + newInterval[0] + ", " + newInterval[1] + "]");

        // Step 1: Add all intervals that end before the newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            System.out.println("Adding interval before merge: [" + intervals[i][0] + ", " + intervals[i][1] + "]");
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge all overlapping intervals with the newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            System.out.println("Merging interval: [" + intervals[i][0] + ", " + intervals[i][1] + "] with newInterval: ["
                    + newInterval[0] + ", " + newInterval[1] + "]");
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the merged interval to the result
        System.out.println("Adding merged interval: [" + newInterval[0] + ", " + newInterval[1] + "]");
        result.add(newInterval);

        // Step 3: Add all remaining intervals
        while (i < intervals.length) {
            System.out.println("Adding interval after merge: [" + intervals[i][0] + ", " + intervals[i][1] + "]");
            result.add(intervals[i]);
            i++;
        }

        // Convert the result list to a 2D array and return
        System.out.println("Final merged intervals:");
        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
        return result.toArray(new int[result.size()][]);
    }

    /*
     * ==========================
     * Time and Space Complexity:
     * ==========================
     * Time Complexity: O(n)
     * - We iterate through the intervals array once, processing each interval in constant time.
     *
     * Space Complexity: O(n)
     * - We use a list to store the resulting intervals, which could contain all the input intervals in the worst case.
     *
     * =================
     * Pros:
     * =================
     * 1. Efficient: Runs in O(n), making it suitable for large inputs.
     * 2. Minimal mutation: Only the necessary intervals are merged or added to the result.
     * 3. Clear logic: Divided into three steps (before, merging, after) for simplicity.
     * 4. Handles edge cases like empty input or no overlap cleanly.
     *
     * =================
     * Cons:
     * =================
     * 1. Assumes input intervals are pre-sorted, which must be ensured beforehand.
     * 2. Slight overhead of converting a list to a 2D array at the end.
     * 3. Relies on modifying the `newInterval` directly during merging, which could be problematic in other use cases.
     *
     * =================
     * Uses:
     * =================
     * 1. Scheduling problems (e.g., adding a new meeting to a calendar).
     * 2. Merging time ranges for efficient resource allocation.
     * 3. Computational geometry (e.g., merging overlapping line segments).
     */
}
