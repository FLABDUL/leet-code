package problems;

import java.util.Arrays;

class HouseRobber {
    // Optimized Space Solution - O(n) Time, O(1) Space
    public int rob(int[] nums) {
        int prevRob = 0; // Stores the max amount robbed excluding the current house
        int maxRob = 0;  // Stores the max amount robbed including the current house

        System.out.println("Starting optimized house robbery...");

        for (int i = 0; i < nums.length; i++) {
            int curValue = nums[i];
            int temp = Math.max(maxRob, prevRob + curValue);
            System.out.println("House " + i + " | Value: " + curValue + " | MaxRob (including this): " + temp + " | PrevRob: " + prevRob);
            prevRob = maxRob; // Move to the next house
            maxRob = temp;    // Update maxRob to the newly calculated max
        }

        System.out.println("Max amount that can be robbed: " + maxRob);
        return maxRob;
    }

    // DP Array Solution - O(n) Time, O(n) Space
    public int robDP(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            System.out.println("Only one house, robbing: " + nums[0]);
            return nums[0];
        }

        int[] dp = new int[n];

        dp[0] = nums[0]; // If only one house, rob it
        dp[1] = Math.max(nums[0], nums[1]); // Choose the max of first two houses

        System.out.println("House 0: " + nums[0] + ", House 1: " + nums[1] + ", DP[1]: " + dp[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]); // Either rob current house and dp[i-2], or skip it
            System.out.println("House " + i + " | Value: " + nums[i] + " | DP[i]: " + dp[i] + " | DP[i-1]: " + dp[i-1] + " | DP[i-2]: " + dp[i-2]);
        }

        System.out.println("Max amount that can be robbed: " + dp[n - 1]);
        return dp[n - 1];
    }

    // Main method to test edge cases
    public static void main(String[] args) {
        HouseRobber robber = new HouseRobber();

        int[][] testCases = {
                {2, 7, 9, 3, 1},   // Normal case
                {1, 2, 3, 1},       // Small case
                {5},                // Single house
                {5, 1},             // Two houses
                {10, 20, 30, 40, 50}, // Increasing values
                {10, 50, 20, 70, 30}, // Skipping strategy
                {},                 // No houses
        };

        for (int[] testCase : testCases) {
            System.out.println("\nTesting: " + Arrays.toString(testCase));
            System.out.println("Optimized DP Result: " + robber.rob(testCase));
            System.out.println("DP Array Result: " + robber.robDP(testCase));
        }
    }
}

/**
 * 🔥 House Robber Problem - Explanation 🔥
 * -----------------------------------------
 * Given an array of non-negative integers `nums` where `nums[i]` represents
 * the amount of money in house `i`, return the maximum money that can be robbed
 * without robbing two adjacent houses.
 *
 * 🚀 Approaches:
 *
 * 1️⃣ **Optimized Space DP (O(1) Space, O(n) Time)**
 *    - Keep track of `prevRob` (max up to i-2) and `maxRob` (max up to i-1)
 *    - Update at each house without extra space
 *    - Formula: `maxRob = max(maxRob, prevRob + nums[i])`
 *
 * 2️⃣ **DP Array (O(n) Space, O(n) Time)**
 *    - `dp[i] = max(dp[i-1], nums[i] + dp[i-2])`
 *    - Stores max at each step, useful for debugging
 *
 * 🛑 **Edge Cases Considered:**
 *    - No houses → Return 0
 *    - Single house → Return that house’s value
 *    - Two houses → Return max of both
 *    - Large values → Algorithm scales well
 *
 * ✅ **Pros & Cons**
 *    - ✅ **Optimized Space**: Uses O(1) space (only two variables)
 *    - ✅ **Fast Execution**: O(n) time
 *    - ❌ **DP Array is redundant**: Only useful if needing intermediate results
 *
 * 🔢 **Complexity Analysis**
 *    - **Time Complexity**: `O(n)`, since we iterate through `nums` once
 *    - **Space Complexity**:
 *        - Optimized DP: `O(1)` (two variables)
 *        - DP Array: `O(n)` (array of size `n`)
 */
