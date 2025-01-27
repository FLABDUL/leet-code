package problems.archive.attempt;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println("result: " + fullJustify(words, maxWidth));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        //substract words+a space from maxwidth till 0 and append to string
        //if leftover space, remaining/2, append with split
        int charCount = 0;
        int spaceCount = 0;
        List<String> result = List.of();
        ArrayList<String> store = new ArrayList<>();
        for(String word : words) {
            if((word.length()+spaceCount)<charCount) {
                charCount += word.length();
                spaceCount++;
                store.add(word);
            }else{
//                result.add(line);
            }
        }

        return result;
    }
}
