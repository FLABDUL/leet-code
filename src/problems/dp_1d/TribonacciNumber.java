package problems.dp_1d;

import java.util.*;

public class TribonacciNumber {

    // Recursive Approach (Exponential Time Complexity: O(3^n))
    public static int tribonacciRecursive(int n) {
        System.out.println("Calling tribonacciRecursive(" + n + ")");
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return tribonacciRecursive(n - 1) + tribonacciRecursive(n - 2) + tribonacciRecursive(n - 3);
    }

    // Dynamic Programming with Memoization (Time: O(n), Space: O(n))
    public static int tribonacciMemoization(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        System.out.println("Computing tribonacciMemoization(" + n + ")");

        int result;
        if (n == 0) result = 0;
        else if (n == 1 || n == 2) result = 1;
        else result = tribonacciMemoization(n - 1, memo) + tribonacciMemoization(n - 2, memo) + tribonacciMemoization(n - 3, memo);

        memo.put(n, result); // Store computed result
        return result;
    }

    // Iterative Dynamic Programming (Time: O(n), Space: O(n))
    public static int tribonacciIterative(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int[] dp = new int[n + 1]; // DP array
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    // Space-Optimized Iterative Approach (Time: O(n), Space: O(1))
    public static int tribonacciOptimized(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int a = 0, b = 1, c = 1, nextTrib;

        for (int i = 3; i <= n; i++) {
            nextTrib = a + b + c;
            a = b;
            b = c;
            c = nextTrib;
        }

        return c;
    }

    // Main method to run all approaches
    public static void main(String[] args) {
        int n = 10; // Test case, can be changed
        System.out.println("\nRecursive Approach: " + tribonacciRecursive(n));
        System.out.println("\nMemoization Approach: " + tribonacciMemoization(n, new HashMap<>()));
        System.out.println("\nIterative DP Approach: " + tribonacciIterative(n));
        System.out.println("\nSpace-Optimized Approach: " + tribonacciOptimized(n));
    }
}

/**
 * Edge Cases:
 * - n = 0 (Expect 0)
 * - n = 1, 2 (Expect 1)
 * - Large values of n (Check performance)
 *
 * Pros & Cons:
 * - Recursive: Simple but slow (exponential time complexity)
 * - Memoization: Optimized recursion, but extra space needed
 * - Iterative DP: Good balance, still uses O(n) space
 * - Space Optimized: Best for efficiency, O(n) time & O(1) space
 *
 * Time Complexity:
 * - Recursive: O(3^n) (Worst case, inefficient)
 * - Memoization: O(n) (Efficient, avoids redundant calculations)
 * - Iterative DP: O(n)
 * - Space-Optimized Iterative: O(n), with O(1) space
 */
