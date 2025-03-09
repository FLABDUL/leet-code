package problems.hashmap_hashset;

import java.util.*;

public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        // Create a HashMap to count occurrences of each number
        Map<Integer, Integer> numCount = new HashMap<>();
        // Create a HashSet to store unique occurrence counts
        Set<Integer> uniqueCount = new HashSet<>();

        // Count occurrences of each element in the array
        for (int i = 0; i < arr.length; i++) {
            numCount.put(arr[i], numCount.getOrDefault(arr[i], 0) + 1);
        }

        // Debug log: Print the occurrence count of each number
        System.out.println("Number Occurrences Map: " + numCount);

        // Add the occurrence counts to the HashSet
        for (int count : numCount.values()) {
            uniqueCount.add(count);
        }

        // Debug log: Print the unique occurrence values
        System.out.println("Unique Occurrence Counts Set: " + uniqueCount);

        // If uniqueCount size is equal to numCount size, all counts are unique
        return uniqueCount.size() == numCount.size();
    }

    // Main method to test the function
    public static void main(String[] args) {
        UniqueOccurrences solution = new UniqueOccurrences();

        // Test cases
        int[] arr1 = {1, 2, 2, 1, 1, 3};  // Expected output: true
        int[] arr2 = {1, 2, 2, 3, 3, 3};  // Expected output: false
        int[] arr3 = {1, 2, 3, 4, 5};     // Expected output: true (all unique)

        System.out.println("Test Case 1: " + Arrays.toString(arr1) + " -> " + solution.uniqueOccurrences(arr1));
        System.out.println("Test Case 2: " + Arrays.toString(arr2) + " -> " + solution.uniqueOccurrences(arr2));
        System.out.println("Test Case 3: " + Arrays.toString(arr3) + " -> " + solution.uniqueOccurrences(arr3));
    }
}

/**
 * Pros:
 * - Uses HashMap for efficient counting (O(1) average time complexity for insertions and lookups).
 * - Uses HashSet to check uniqueness in O(1) time.
 * - Optimized compared to brute-force solutions using nested loops.

 * Cons:
 * - Requires extra space for HashMap and HashSet (O(n) additional space).
 * - Only works with integer arrays; other types would require modification.

 * Uses:
 * - Checking if elements in a dataset have unique occurrence counts.
 * - Useful in statistical analysis where frequency uniqueness is important.

 * Time Complexity:
 * - Counting occurrences: O(n)
 * - Storing counts in HashSet: O(n)
 * - Checking size condition: O(1)
 * - Overall: **O(n)**

 * Space Complexity:
 * - HashMap stores counts: O(n)
 * - HashSet stores unique counts: O(n)
 * - Overall: **O(n)**
 */
