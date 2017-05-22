package datastrutures.strings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by archithrapaka on 3/5/17.
 */
public class PrintListOfItemsContainingAllChars {

    static void printList(String pattern , ArrayList<String> dict) {
        // for each sorted string in the list check if the pattern and the word match
        for (String word:dict) {
            int[] charcount = StringUtils.getCharCount(pattern);
               if(matchChars(word,charcount,pattern.length())) {
                   System.out.print(word + " ");
               }
        }

    }

    private static boolean matchChars(String word, int[] charcount,int patternLength) {

        int length = 0;
        for (int i = 0; i < word.length(); i++) {
                    if(length == patternLength) {
                        return true;
                    }
              char c = word.charAt(i);
              if(charcount[c] <= 0) {
                  continue;
              }
              length++;
              charcount[c]--;

        }
        return false;
    }

    public static void main(String[] args) {
        String s = "suns";
        String[] words = new String[]{"sunday","utensil","sansui","samsung"};
        ArrayList<String> dict = new ArrayList<>(Arrays.asList(words));
        //printList(s,dict);
        String s2 = "geeks quiz practice code";
        String s3 = "getting       good      at   coding   needs a lot of practice";

        System.out.print(StringUtils.reverseWords(s3));
    }
}
