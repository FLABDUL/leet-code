//package problems.java.archive.attempt;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class LongestSubStringWithoutRepeatingChars {
//    public static void main(String[] args) {
//        String s = "abcabcbb";
//        System.out.println("res: " + lengthOfLongestSubstring(s));
//    }
//
//    public static int lengthOfLongestSubstring(String s) {
//        //loop through whole char
//            //loop window
//                //if window exists
//        char[] chars = s.toCharArray();
//        Set<Character> uniqueChars = new HashSet<>();
//        for(int i = 0; i < s.length(); i++) {
//            if(!uniqueChars.contains(chars[i])){
//                uniqueChars.add(chars[i]);
//            }
//        }
//    }
//}
