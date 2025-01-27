package problems.archive.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SubStringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if (words == null || words.length == 0 || s == null || s.length() < words.length * words[0].length()) {
            return new ArrayList<>();
        }

        //setup string count map
        //cycle words and add to count map
        HashMap<String, Integer> count = new HashMap<>();
        for (String word : words){
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        //create index list
        //length stirng
        //number words
        //lengtht each same word
        List<Integer> index = new ArrayList<>();
        int stringLength = s.length();
        int numberWords = words.length;
        int lengthWord = words[0].length();

        //outer loop through all strating poitn in string
            //seen map window
            //inner loop check word size chunk
            //strat and end of words
            //subtring word
            //if count contains word
                //put in seen
                //if freq exceed, break
            //esle break if not contian word
//            increment count
        for(int i = 0; i < stringLength - numberWords * lengthWord + 1; i++){
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;

            while(j < numberWords){
                int start = i + j * lengthWord;
                int end = start + lengthWord;
                String word = s.substring(start, end);
                if(count.containsKey(word)){
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if(seen.get(word)>count.get(word)){
                        break;
                    }
                }else{
                    break;
                }
                j++;
            }
            if(j==numberWords){
                index.add(i);
            }
        }

        //if numbers add up add to index
        //return index
    return index;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        SubStringWithConcatenationOfAllWords cat = new SubStringWithConcatenationOfAllWords();
        System.out.println("Result: " + cat.findSubstring(s, words));
    }
}
