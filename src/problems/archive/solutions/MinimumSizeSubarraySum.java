package problems.archive.solutions;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
//        int[] nums = {1,1,1,1,1,1,1,1};
        int target=7;
//        int target=11;
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int s, int[] a) {
        // Edge case: if the input array is null or empty, return 0
        if (a == null || a.length == 0) {
            System.out.println("Input array is null or empty.");
            return 0;
        }

        // Initialize variables
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        System.out.println("Starting computation...");

        // Outer loop to expand the sliding window
        while (j < a.length) {
            sum += a[j];
            System.out.printf("Added a[%d] = %d, current sum = %d, window = [%d, %d]\n", j, a[j], sum, i, j);
            j++;

            // Inner loop to shrink the window when the condition is met
            while (sum >= s) {
                int currentWindowLength = j - i;
                min = Math.min(min, currentWindowLength);

                System.out.printf(
                        "Current window [%d, %d] meets condition (sum = %d >= %d).\n",
                        i, j - 1, sum, s
                );
                System.out.printf(
                        "Current window length = %d, min length so far = %d.\n",
                        currentWindowLength, min
                );

                sum -= a[i];
                System.out.printf("Shrinking window: Subtracted a[%d] = %d, new sum = %d.\n", i, a[i], sum);
                i++;
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println("No valid subarray found.");
        } else {
            System.out.printf("Minimal length of subarray found: %d\n", min);
        }

        // Pros:
        // 1. Efficiency: Uses the sliding window technique to achieve O(n) time complexity.
        // 2. Real-time Debugging: Log statements help understand the algorithm's behavior step-by-step.
        // 3. Compactness: Space complexity is O(1), making it memory efficient.

        // Cons:
        // 1. Edge Cases: Assumes the array contains only non-negative numbers. Negative numbers can break the logic.
        // 2. Limited Use: Specifically designed for problems involving contiguous subarrays.
        // 3. Verbose Logging: Logging can become overwhelming for large inputs; should be disabled in production.

        // Use Case:
        // This method is ideal for scenarios where you need to find a minimal window satisfying a condition, such as:
        // - Financial analysis: Finding the shortest period to achieve a profit goal.
        // - Bioinformatics: Identifying a minimal sequence with a target sum.
        // - Streaming data: Online processing to meet thresholds in real-time.

        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
