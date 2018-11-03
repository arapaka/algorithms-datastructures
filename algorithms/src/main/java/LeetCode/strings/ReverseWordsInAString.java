package LeetCode.strings;

public class ReverseWordsInAString {

    public static String reverseWords(String s) {
        int i = 0;
        int j = 0;
        char[] chars = s.toCharArray();
        while (i < s.length() && j < s.length()) {
            while (j < s.length() && chars[j] != ' ') {
                j++;
            }
            reverse(chars, i, j - 1);
            j++;
            i = j;
        }
        return new String(chars);
    }

    public static void reverse(char[] c, int start, int end) {
        while (start < end) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
    }

    public static String reverse(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = chars[i];
            char ith = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
