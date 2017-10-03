package LeetCode.strings;

import java.util.Arrays;
import java.util.Collections;

public class ReverseSentence {

    public String reverseWords(String s) {
        if(null == s || s.trim().length() == 0 ){
            return s.trim();
        }
        String[] split = s.trim().split("\\s+");
        return reverse(split);
    }

    public String reverse(String[] s) {
        int i = 0;
        int j = s.length-1;

        while (i < j) {
            String temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < s.length-1; k++) {
            sb.append(s[k]);
            sb.append(" ");
        }
        sb.append(s[s.length-1]);
        return sb.toString();
    }


    // java builtin solution
    public String reverseWords2(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String s = "       the sky        is            blue     ";
       String[] s1 = s.trim().split("\\s+");
       int i = 0;
       for (String s2 : s1) {
            System.out.println(i++ + ":" + s2);
        }
    }
}
