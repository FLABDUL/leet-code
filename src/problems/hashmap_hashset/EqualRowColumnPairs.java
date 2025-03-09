package problems.hashmap_hashset;

import java.util.*;

public class EqualRowColumnPairs {
    public int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;
        Map<List<Integer>, Integer> rowMap = new HashMap<>(); // Map to store row patterns and their frequency

        // Process rows and store in rowMap
        for (int y = 0; y < n; y++) {
            List<Integer> rowList = new ArrayList<>();
            for (int x = 0; x < n; x++) {
                rowList.add(grid[y][x]);
            }
            rowMap.put(rowList, rowMap.getOrDefault(rowList, 0) + 1); // Count occurrences of each row
            System.out.println("Row added: " + rowList + " -> Count: " + rowMap.get(rowList));
        }

        // Process columns and count matches in rowMap
        for (int x = 0; x < n; x++) {
            List<Integer> columnList = new ArrayList<>();
            for (int y = 0; y < n; y++) {
                columnList.add(grid[y][x]);
            }
            int matches = rowMap.getOrDefault(columnList, 0); // Check if column exists in rowMap
            count += matches;
            System.out.println("Column checked: " + columnList + " -> Matches: " + matches);
        }

        System.out.println("Total equal row-column pairs: " + count);
        return count;
    }

    // Main method to test edge cases
    public static void main(String[] args) {
        EqualRowColumnPairs solution = new EqualRowColumnPairs();

        // Test case 1: Basic example
        int[][] grid1 = {
                {1, 2, 3},
                {3, 2, 1},
                {1, 2, 3}
        };
        System.out.println("Test 1: " + solution.equalPairs(grid1)); // Expected: 2

        // Test case 2: No matching pairs
        int[][] grid2 = {
                {1, 2},
                {3, 4}
        };
        System.out.println("Test 2: " + solution.equalPairs(grid2)); // Expected: 0

        // Test case 3: All identical rows and columns
        int[][] grid3 = {
                {1, 1},
                {1, 1}
        };
        System.out.println("Test 3: " + solution.equalPairs(grid3)); // Expected: 4 (every row matches every column)
    }
}

/**
 * Edge Cases:
 * 1. A grid where no column matches any row (e.g., [[1,2], [3,4]] -> Expected: 0)
 * 2. A grid where every column matches a row (e.g., [[1,1], [1,1]] -> Expected: 4)
 * 3. A single-element grid (e.g., [[5]] -> Expected: 1)
 * 4. A large grid (e.g., 1000x1000) to test efficiency
 *
 * Pros:
 * - Efficient approach using HashMap for row storage.
 * - Avoids unnecessary nested comparisons.
 * - Handles duplicate row cases correctly.
 *
 * Cons:
 * - Uses extra space for the HashMap (O(n^2) worst case in memory).
 * - Performance could degrade if Java's HashMap has collisions.
 *
 * Uses:
 * - Useful for matrix pattern matching.
 * - Can be extended for checking symmetry in matrices.
 *
 * Time Complexity:
 * - Constructing rowMap: O(n^2)
 * - Checking columns: O(n^2)
 * - Overall: O(n^2)
 *
 * Space Complexity:
 * - HashMap stores up to O(n^2) entries in the worst case.
 * - Overall: O(n^2) in worst case, O(n) in best case.
 */
