package datastrutures.strings;

import java.util.Arrays;

/**
 * Created by archithrapaka on 3/5/17.
 * // some useful methods
 */
public class StringUtils {

    public static int[] getCharCount(String s) {
        int[] count = new int[256];

        for (int i = 0; i < s.length(); i++) {
             count[s.charAt(i)]++;
        }
        return count;
    }

    // check String rotation
    static boolean checkRotation(String s , String b) {

        return (s.length() == b.length()) && s.concat(s).contains(b);
    }

    /**
     * return sorted string
     * @param word
     * @return
     */
    private static String sort(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static String reverse(String s){
        StringBuilder stringBuilder = new StringBuilder("");
        int i = s.length()-1;
        while (i >= 0) {
            stringBuilder.append(s.charAt(i));
            i--;
        }
        return stringBuilder.toString();
    }

    public static String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder("");
        int i = split.length-1;

        while (i >= 0) {
            sb.append(split[i]);
            sb.append(" ");
            i--;
        }
        return sb.toString();
    }

    public int lengthOfLongestSubstring(String s){
        int[] map = new int[128];
        int start = 0;
        int minStart = 0;
        int end = 0;
        int begin = 0;
        int counter = 0;
        int MAX = 0;
        //int count = t.length();
        int minLength = Integer.MAX_VALUE;

        while (end < s.length()) {
              if(map[s.charAt(end++)]++ > 0) counter++;

              while (counter > 0) {
                   if(map[s.charAt(begin++)]-- > 1) {
                       counter--;
                       MAX = Math.max(MAX,end-begin);
                   }
              }
        }
        return MAX;
    }
}
