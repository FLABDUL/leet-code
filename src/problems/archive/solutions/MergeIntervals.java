package problems.archive.solutions;

import java.util.*;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // Handle edge case where there is 1 or no intervals
        if (intervals.length <= 1) {
            System.out.println("Input has 1 or no intervals, returning as is.");
            return intervals;
        }

        // Sort intervals by their starting points in ascending order
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        System.out.println("Sorted intervals: " + Arrays.deepToString(intervals));

        // Initialize a list to store merged intervals
        List<int[]> result = new ArrayList<>();

        // Start with the first interval
        int[] newInterval = intervals[0];
        result.add(newInterval);
        System.out.println("Starting merge with interval: " + Arrays.toString(newInterval));

        for (int[] interval : intervals) {
            System.out.println("Evaluating interval: " + Arrays.toString(interval));

            // Check if intervals overlap
            if (interval[0] <= newInterval[1]) { // Overlap detected
                System.out.println("Overlapping with: " + Arrays.toString(newInterval));

                // Merge the intervals by extending the end of newInterval
                newInterval[1] = Math.max(newInterval[1], interval[1]);
                System.out.println("Merged interval: " + Arrays.toString(newInterval));
            } else { // No overlap, move to the next interval
                System.out.println("No overlap. Adding new interval: " + Arrays.toString(interval));

                // Update newInterval and add it to the result
                newInterval = interval;
                result.add(newInterval);
            }
        }

        // Convert the list of intervals back to a 2D array
        int[][] mergedIntervals = result.toArray(new int[result.size()][]);
        System.out.println("Final merged intervals: " + Arrays.deepToString(mergedIntervals));

        return mergedIntervals;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();

        // Test case
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Input intervals: " + Arrays.deepToString(intervals));

        int[][] merged = mergeIntervals.merge(intervals);
        System.out.println("Output merged intervals: " + Arrays.deepToString(merged));
    }
}

/*
Pros:
1. Efficient algorithm with O(n log n) time complexity due to sorting.
2. Handles both overlapping and disjoint intervals effectively.
3. Simple and easy-to-understand implementation.

Cons:
1. Requires additional space for the List<int[]> to store merged intervals.
2. Sorting step adds overhead for large datasets.

Uses:
1. Useful in scheduling problems, such as merging meeting times.
2. Simplifies handling ranges in numerical problems.
3. Commonly used in interval-related problems, e.g., for calendar applications.
*/
