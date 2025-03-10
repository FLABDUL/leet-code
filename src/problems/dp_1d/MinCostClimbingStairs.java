package problems.dp_1d;

import java.util.*;

public class MinCostClimbingStairs {

    // Recursive Approach (Exponential Time Complexity: O(2^n))
    public static int minCostRecursive(int[] cost) {
        int n = cost.length;
        return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    private static int minCost(int[] cost, int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return cost[n];
        return cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    // Top Down Memoization (Time: O(n), Space: O(n))
    private static int[] dp;
    public static int minCostMemoization(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(minCostMemo(cost, n - 1), minCostMemo(cost, n - 2));
    }

    private static int minCostMemo(int[] cost, int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return cost[n];
        if (dp[n] != -1) return dp[n];
        dp[n] = cost[n] + Math.min(minCostMemo(cost, n - 1), minCostMemo(cost, n - 2));
        return dp[n];
    }

    // Bottom Up Tabulation (Time: O(n), Space: O(n))
    public static int minCostTabulation(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < 2) dp[i] = cost[i];
            else dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    // Bottom Up Space Optimized (Time: O(n), Space: O(1))
    public static int minCostOptimized(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        if (n <= 2) return Math.min(first, second);

        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }

    // Main method to test all approaches
    public static void main(String[] args) {
        int[] cost = {10, 15, 20, 5, 10, 25, 30}; // Example test case

        System.out.println("Recursive Approach: " + minCostRecursive(cost));
        System.out.println("Memoization Approach: " + minCostMemoization(cost));
        System.out.println("Tabulation Approach: " + minCostTabulation(cost));
        System.out.println("Optimized Approach: " + minCostOptimized(cost));
    }
}

/**
 * Edge Cases:
 * - cost = [10, 15] (Only two steps, should return min(10,15) = 10)
 * - cost = [1, 100, 1, 100, 1] (Algorithm should take cheapest path)
 * - cost = [0, 0, 0, 0] (All costs are zero, result should be 0)
 * - Large values of n (Ensures efficiency)
 *
 * Pros & Cons:
 * - Recursive: Simple but slow (O(2^n) time complexity, exponential)
 * - Memoization: Optimized recursion, avoids redundant calculations (O(n) time, O(n) space)
 * - Tabulation: Iterative approach, O(n) time but requires O(n) space
 * - Space Optimized: Best for efficiency, O(n) time & O(1) space
 *
 * Time Complexity:
 * - Recursive: O(2^n) (Inefficient for large n)
 * - Memoization: O(n) (Efficient, avoids redundant calculations)
 * - Tabulation: O(n)
 * - Space-Optimized Iterative: O(n), with O(1) space
 */
