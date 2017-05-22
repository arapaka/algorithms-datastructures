package LeetCode.TwoPointers;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by archithrapaka on 4/15/17.
 */
public class ReverseVowels {

    public static void reverseVowels(String s) {
        if(null == s || s.length() <= 1){
            return;
        }
        Set<Character> chars = new HashSet<>(5);
        chars.add('a');
        chars.add('e');
        chars.add('i');
        chars.add('o');
        chars.add('u');

        int left = 0;
        int right = s.length()-1;
        char[] c = s.toCharArray();
        while (left <= right) {
               if(chars.contains(c[left]) && chars.contains(c[right])) {
                   swap(left,right,c);
                   left++;
                   right--;
               }
                else if (!chars.contains(c[left])) {
                   left++;
               }
              else if (!chars.contains(c[right])) {
                   right--;
               }
        }
        System.out.println(new String(c));
    }
    public static void swap(int left , int right, char[] c) {
        char temp = c[left];
        c[left] = c[right];
        c[right] = temp;
    }

    public static void main(String[] args) {
        String s = "hello";
        String s2 = "leetcode";
        reverseVowels(s);
        reverseVowels(s2);
    }
}
