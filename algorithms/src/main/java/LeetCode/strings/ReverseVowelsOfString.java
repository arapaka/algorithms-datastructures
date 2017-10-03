package LeetCode.strings;

import java.util.HashMap;
import java.util.Map;

public class ReverseVowelsOfString {

    //Set<Character> vowels = new HashSet<>(Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'}));
    public static String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1;

        Map<Character,Integer> map = new HashMap<>();
        map.put('a',1);
        map.put('A',2);
        map.put('e',1);
        map.put('E',1);
        map.put('i',1);
        map.put('I',1);
        map.put('o',1);
        map.put('O',1);
        map.put('u',1);
        map.put('U',1);
        char[] c = s.toCharArray();
        while ( i < j ) {
              while (i < j && !map.containsKey(c[i])) {
                   i++;
              }

            while (i < j && !map.containsKey(c[j])) {
                j--;
            }

              if(i < j) {
                  swap(c,i,j);
                  i++;
                  j--;
              }
        }
        return new String(c);
    }

    public static void swap(char[]c , int i , int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }
}
