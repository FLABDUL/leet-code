package problems.archive.practise;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ReverseWords {
    public static void main(String[] args) {
//        System.out.print(reverseWords("helloWorld"));
        System.out.print(reverseWords("test spaces  here   now"));
    }

    public static String reverseWords(String s) {
        String sSingleSpace = s.replaceAll("\\s+", " ");
        System.out.println("aSingleSpace: " + sSingleSpace);

        String[] words;
        words = sSingleSpace.split(" ");
        for(String word : words) {
            System.out.println("word: " + word);
        }

        //doesnt work because lexographic only
//        Arrays.sort(words, Collections.reverseOrder());
//        System.out.println();
//        for(String word : words) {
//            System.out.println("word: " + word);
//        }
//        sSingleSpace.split()

//        String[] reversed = Arrays.stream(words).sorted(Comparator.reverseOrder()).toArray(String[]::new);
//        for(String reverse : reversed) {
//            System.out.println("reverse: " + reverse);
//        }

        String reversed = Arrays.stream(words)
                .collect(Collectors.collectingAndThen(//collection setup then post-processing args(collection, function)
                        Collectors.toList(),//reverse() only works on list
                        list -> {
                                Collections.reverse(list);//reverse words
                                return String.join(" ", list);//then join them with spaces in between
                                }
                ));
        System.out.println("Reversed: " + reversed);
        return reversed.trim();//cut leading and trailing spaces
    }
}
