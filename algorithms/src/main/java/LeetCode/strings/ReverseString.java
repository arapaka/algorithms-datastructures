package LeetCode.strings;

public class ReverseString {

    public static String reverseString(String s) {
        if(null == s || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length()-1;
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

    }
}
