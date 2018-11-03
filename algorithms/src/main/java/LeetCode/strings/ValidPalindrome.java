package LeetCode.strings;

public class ValidPalindrome {

    public static boolean isValidPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stringBuilder.append(c);
            }
        }
        String a = stringBuilder.toString().toLowerCase();
        String b = stringBuilder.reverse().toString().toLowerCase();
        return a.equals(b);
    }
}
