package problems.archive.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SubStringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        // Step 1: Create a frequency map for the words
        final Map<String, Integer> counts = new HashMap<>();
        for (final String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word Frequency Map: " + counts);

        final List<Integer> indexes = new ArrayList<>();
        final int n = s.length(); // Total length of the string
        final int num = words.length; // Total number of words
        final int len = words[0].length(); // Length of each word (all words are the same length)

        // PROS:
        // - Efficient sliding window reduces the number of substring checks
        // - Handles duplicate words (e.g., ["foo", "foo"]) by using a frequency map
        // - Works with any order of words, as long as all are matched correctly

        // CONS:
        // - Memory usage scales with the size of `words` due to frequency and seen maps
        // - Substring operations (`s.substring()`) can add overhead for large inputs
        // - Not the fastest solution for extremely large strings or word arrays

        // USE CASES:
        // - Specifically designed for problems like LeetCode 30: Substring with Concatenation of All Words
        // - Can be adapted for any problem requiring frequency-based substring matching
        // - Useful for word-pattern matching in text analytics or search engines

        // Outer loop: Iterate through all valid starting points in the string
        for (int i = 0; i < n - num * len + 1; i++) {
            System.out.println("Checking starting index: " + i);

            // Step 2: Create a map to track words seen in this window
            final Map<String, Integer> seen = new HashMap<>();
            int j = 0;

            // Inner loop: Check each word-sized chunk in this window
            while (j < num) {
                int start = i + j * len; // Start of the current word
                int end = start + len; // End of the current word (exclusive)
                final String word = s.substring(start, end);
                System.out.println("  Extracted word: " + word);

                // Check if the word is in the word list
                if (counts.containsKey(word)) {
                    // Increment the seen count for this word
                    seen.put(word, seen.getOrDefault(word, 0) + 1);

                    System.out.println("  Word '" + word + "' seen " + seen.get(word) + " times so far.");

                    // If a word is seen more times than allowed, break early
                    if (seen.get(word) > counts.get(word)) {
                        System.out.println("  Word '" + word + "' exceeds allowed frequency, breaking.");
                        break;
                    }
                } else {
                    // If the word is not in the original list, break early
                    System.out.println("  Word '" + word + "' not in word list, breaking.");
                    break;
                }
                j++;
            }

            // If all words are matched, add the starting index to the result
            if (j == num) {
                System.out.println("  All words matched at index: " + i);
                indexes.add(i);
            } else {
                System.out.println("  Not all words matched at index: " + i);
            }
        }

        // Log final result for debugging
        System.out.println("Final Result: " + indexes);
        return indexes;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        SubStringWithConcatenationOfAllWords cat = new SubStringWithConcatenationOfAllWords();
        System.out.println("Result: " + cat.findSubstring(s, words));
    }
}
