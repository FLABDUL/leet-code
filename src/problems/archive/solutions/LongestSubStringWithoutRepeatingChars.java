package problems.archive.solutions;

import java.util.HashMap;

public class LongestSubStringWithoutRepeatingChars {

    /**
     * Finds the length of the longest substring without repeating characters.
     *
     * Pros:
     * 1. Efficient: Runs in O(n) time complexity, processing each character only once.
     * 2. Sliding Window Logic: Intuitive and maintains a dynamic window of unique characters.
     * 3. Handles Edge Cases: Works for empty strings and strings with all unique characters.
     *
     * Cons:
     * 1. Space Complexity: Requires O(n) additional space for the HashMap to track characters.
     * 2. Not Optimized for Non-ASCII: May require additional handling for extended Unicode inputs.
     *
     * Use Cases:
     * 1. String Analysis: Identify patterns or unique substrings in text data.
     * 2. Competitive Programming: Frequently appears in algorithmic challenges.
     * 3. Real-World Applications: Useful for parsing text, password validation, or deduplication tasks.
     *
     * @param s The input string.
     * @return The length of the longest substring without repeating characters.
     */
    public int lengthOfLongestSubstring(String s) {
        // Handle edge case where input string is empty
        if (s.length() == 0) {
            System.out.println("Input string is empty. Returning 0.");
            return 0;
        }

        // Map to store the last index of each character in the string
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0; // Variable to track the maximum length of unique substring
        int j = 0;   // Left boundary of the sliding window

        System.out.println("Starting to process the string: " + s);

        // Loop through the characters of the string
        for (int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);
            System.out.println("Processing character '" + currentChar + "' at index " + i);

            // If the character is already in the map, adjust the left boundary of the window
            if (map.containsKey(currentChar)) {
                j = Math.max(j, map.get(currentChar) + 1);//max prevents backwards jump e.g. "abba"
                System.out.println("Character '" + currentChar + "' already seen. Updating 'j' to " + j);
            }

            // Update the last index of the current character in the map
            map.put(currentChar, i);
            System.out.println("Updating character '" + currentChar + "' in map with index " + i);

            // Update the maximum length of the unique substring
            max = Math.max(max, i - j + 1);
            System.out.println("Current max length: " + max);
        }

        System.out.println("Final maximum length of unique substring: " + max);
        return max;
    }

    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingChars solver = new LongestSubStringWithoutRepeatingChars();
        String input = "abcabcbb";
        System.out.println("Length of the longest substring without repeating characters: " + solver.lengthOfLongestSubstring(input));
    }
}

