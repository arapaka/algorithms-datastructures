package codefights;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by archithrapaka on 5/20/17.
 */
public class ReverseVowelsOfString {

    static String reverseVowelsOfString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');

        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            while (!vowels.contains(s.charAt(right)) && left < right) {
                right--;
            }
            while (!vowels.contains(s.charAt(left)) && left < right) {
                left++;
            }

            if (left < right) {
                swap(left, right, chars);
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public static void swap(int left, int right, char[] chars) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }

    public static void main(String[] args) {
        System.out.print(reverseVowelsOfString(".,"));
    }
}
