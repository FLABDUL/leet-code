import java.util.*;

public class FindDifferenceTwoArrays {
    // Method to find the difference between two integer arrays
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Create the final answer list that will contain two lists
        List<List<Integer>> ans = new ArrayList<>();
        // Create lists to store unique elements from nums1 and nums2
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        // Create sets to store unique elements from nums1 and nums2 for efficient lookup
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Add elements of nums1 to set1
        for (int num1 : nums1) {
            set1.add(num1);
        }
        System.out.println("Set1 (unique nums1 elements): " + set1);

        // Add elements of nums2 to set2
        for (int num2 : nums2) {
            set2.add(num2);
        }
        System.out.println("Set2 (unique nums2 elements): " + set2);

        // Find elements in set1 that are not in set2
        for (int num1 : set1) {
            if (!set2.contains(num1)) {
                ans1.add(num1);
            }
        }
        System.out.println("Elements in nums1 but not in nums2: " + ans1);

        // Find elements in set2 that are not in set1
        for (int num2 : set2) {
            if (!set1.contains(num2)) {
                ans2.add(num2);
            }
        }
        System.out.println("Elements in nums2 but not in nums1: " + ans2);

        // Add both lists to the final answer
        ans.add(ans1);
        ans.add(ans2);

        // Return the answer containing both lists
        return ans;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3}; // Example input array 1
        int[] nums2 = {2, 4, 6};    // Example input array 2

        System.out.println("Input Array 1: " + Arrays.toString(nums1));
        System.out.println("Input Array 2: " + Arrays.toString(nums2));

        List<List<Integer>> result = findDifference(nums1, nums2);

        System.out.println("Final Result (Unique Differences): " + result);
    }
}
// Pros:
// 1. Uses HashSet for fast lookups (O(1) average time complexity for contains operation).
// 2. Ensures unique elements in the output lists (no duplicates).
// 3. More efficient than using nested loops (O(n^2) complexity).

// Cons:
// 1. Extra space usage due to HashSets (O(n) additional space).
// 2. Only works with integer arrays; for other types, conversions are required.

// Uses:
// - Finding unique differences between two datasets.
// - Comparing two lists for elements exclusive to each.

// Time Complexity:
// - Constructing the sets takes O(n + m), where n is the size of nums1 and m is the size of nums2.
// - Checking each element in the sets takes O(n + m).
// - Overall: **O(n + m)**

// Space Complexity:
// - We store nums1 and nums2 in separate sets: O(n + m)
// - Output lists store unique elements: O(n + m)
// - Overall: **O(n + m)**

