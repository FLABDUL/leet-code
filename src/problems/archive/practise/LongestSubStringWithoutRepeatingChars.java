package problems.archive.practise;

import java.util.HashMap;

public class LongestSubStringWithoutRepeatingChars {
    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingChars solver = new LongestSubStringWithoutRepeatingChars();
        String input = "abcabcbb";
        System.out.println("Length of the longest substring without repeating characters: "
                + solver.lengthOfLongestSubstring(input));
    }

    private int lengthOfLongestSubstring(String s) {
        // Handle null or empty string edge case
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // HashMap to store the last index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, j = 0; // max length and left boundary of the window

        // Iterate through characters in the string
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i); // Current character

            // If the character is already in the map, update the left boundary
            if (map.containsKey(curr)) {
                j = Math.max(j, map.get(curr) + 1);
            }

            // Update the last index of the current character in the map
            map.put(curr, i);

            // Update the maximum length of the unique substring
            max = Math.max(max, i - j + 1);
        }

        return max;
    }
}
