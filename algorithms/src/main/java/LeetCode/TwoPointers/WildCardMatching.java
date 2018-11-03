package LeetCode.TwoPointers;

/**
 * Created by archithrapaka on 4/9/17.
 */
public class WildCardMatching {

    static boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int starIndex = -1;
        int iIndex = -1;
        while (i < s.length()) {

            if (s.charAt(i) == p.charAt(j) || j < p.length() && (p.charAt(j) == '?')) {
                ++i;
                ++j;
            } else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                iIndex = i;
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;
                i = iIndex + 1;
                iIndex++;
            } else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            ++j;
        }

        return j == p.length();
    }

    public static boolean regexMatch(String s, String p) {
        for (int i = 0; i < p.length(); s = s.substring(1)) {
            char c = p.charAt(i);
            if (i + 1 >= p.length() || p.charAt(i + 1) != '*')
                i++;
            else if (regexMatch(s, p.substring(i + 2)))
                return true;

            if (s.isEmpty() || (c != '.' && c != s.charAt(0)))
                return false;
        }

        return s.isEmpty();
    }

    public static void main(String[] args) {
        //System.out.print(isMatch("abed","?b*d**"));
        System.out.println(regexMatch("aa", ".*"));
    }
}
