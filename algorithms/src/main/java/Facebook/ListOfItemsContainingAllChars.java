package Facebook;

import java.util.Arrays;

import static LeetCode.TwoPointers.findTheDifference.getCharCount;

/**
 * Created by archithrapaka on 4/30/17.
 */
public class ListOfItemsContainingAllChars {

    public static void printList(String[] dict , String s) {
        // chars count;
        int[] count = getCharCount(s);

        for (String v2:dict) {
             if(containsMatch(v2,s,count)) {
                 System.out.println(v2);
             }
        }

    }

    //check if A has same chars as B
    public static boolean containsMatch(String A , String B, int[] count) {
        int[] dummy = Arrays.copyOf(count,count.length);
        int wordCount = 0;
        for (int i = 0;i < A.length(); i++) {
              if(wordCount == B.length()) {
                  return true;
              }

             if(dummy[A.charAt(i)] == 0 ) {
                 continue;
             }
             else {
                 dummy[A.charAt(i)]--;
                 wordCount++;
             }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "sun";
        String[] words = new String[]{"sunday","utensil","sansui","samsung"};
        printList(words,s);
    }
}
