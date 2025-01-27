//package problems.java.archive.practise;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TextJustification {
//    public static void main(String[] args) {
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification"};
//        int maxWidth=16;
//
//        TextJustification tj = new TextJustification();
//        List<String> result = tj.fullJustify(words, maxWidth);
//    }
//
//    private List<String> fullJustify(String[] words, int maxWidth) {
//        //set left first
//        int left=0;
//        List<String> result = new ArrayList<>();
//
//        //process each line
//        while (left < words.length){
//            int right = findRight(left, words, maxWidth);
//            result.add(justify(left, right, words, maxWidth));
//            left = right+1;//next line
//        }
//        return result;
//    }
//
//    private String justify(int left, int right, String[] words, int maxWidth) {
//
//    }
//
//    private int findRight(int left, String[] words, int maxWidth) {
//        int right=left;
//        int sum = words[right++].length();
//        whie(right>words.length && (sum + 1 + words[rig]))
//    }
//}
