package problems.archive.solutions;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0;
        List<String> result = new ArrayList<>();

        // Start processing each line
        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            System.out.println("left: " + left + ", right: " + right);  // Log the range of words for this line
            result.add(justify(left, right, words, maxWidth));
            left = right + 1;  // Move to the next line
        }

        return result;
    }

    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right++].length();

        System.out.println("Finding right index starting from left: " + left + " with initial sum: " + sum);

        // Add words to the line while checking if they fit within maxWidth
        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth) {
            sum += 1 + words[right++].length();  // Add the word length + space
            System.out.println("Added word: " + words[right - 1] + " to line. New sum: " + sum);
        }

        // Log the final right index found for the line
        System.out.println("Final right index: " + (right - 1));
        return right - 1;  // Return the index of the last word that fits
    }

    private String justify(int left, int right, String[] words, int maxWidth) {
        if (right - left == 0) return padResult(words[left], maxWidth);

        boolean isLastLine = right == words.length - 1;
        int numSpaces = right - left;
        int totalSpace = maxWidth - wordsLength(left, right, words);

        System.out.println("Justifying words from index " + left + " to " + right);
        System.out.println("isLastLine: " + isLastLine + ", total space to distribute: " + totalSpace);

        // Calculate the space to insert between words
        String space = isLastLine ? " " : blank(totalSpace / numSpaces);
        int remainder = isLastLine ? 0 : totalSpace % numSpaces;

        StringBuilder result = new StringBuilder();

        // Construct the justified line
        for (int i = left; i <= right; i++) {
            result.append(words[i])
                    .append(space)
                    .append(remainder-- > 0 ? " " : "");  // Add extra space if remainder exists
            System.out.println("Adding word: " + words[i] + ", space: " + (remainder >= 0 ? space : ""));
        }

        // Log the final justified line before padding
        String justifiedLine = result.toString().trim();
        System.out.println("Justified line before padding: \"" + justifiedLine + "\"");

        return padResult(justifiedLine, maxWidth);
    }

    private int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) {
            wordsLength += words[i].length();
        }
        return wordsLength;
    }

    private String padResult(String result, int maxWidth) {
        System.out.println("Padding result to maxWidth: " + maxWidth + ", current length: " + result.length());
        return result + blank(maxWidth - result.length());
    }

    private String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification"};
        int maxWidth = 16;

        TextJustification tj = new TextJustification();//call class instead of static methods
        List<String> result = tj.fullJustify(words, maxWidth);

        // Output the final justified text
        for (String line : result) {
            System.out.println("\"" + line + "\"");
        }
    }
}
