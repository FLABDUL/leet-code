package problems.archive.attempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        SubStringWithConcatenationOfAllWords cat = new SubStringWithConcatenationOfAllWords();
        System.out.println("Result: " + cat.findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || words == null || words.length == 0) {
            return result; // Edge case: Empty input
        }

        int wordLength = words[0].length();
        int totalWordsLength = wordLength * words.length;

        // Step 1: Create a frequency map of the words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Step 2: Iterate through the string using a sliding window
        for (int i = 0; i <= s.length() - totalWordsLength; i++) {
            // Create a map to track seen words
            Map<String, Integer> seenWords = new HashMap<>();
            int j = 0;

            // Step 3: Check substrings in chunks of `wordLength`
            while (j < words.length) {
                int wordStart = i + j * wordLength;
                int wordEnd = wordStart + wordLength;
                String word = s.substring(wordStart, wordEnd);

                if (wordCount.containsKey(word)) {
                    // Add the word to the seen map
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);

                    // If we see the word more than it appears in `words`, break
                    if (seenWords.get(word) > wordCount.get(word)) {
                        break;
                    }
                } else {
                    // If the word is not in the wordCount map, break
                    break;
                }

                j++;
            }

            // If all words are matched, add the starting index to the result
            if (j == words.length) {
                result.add(i);
            }
        }

        return result;
    }
}
