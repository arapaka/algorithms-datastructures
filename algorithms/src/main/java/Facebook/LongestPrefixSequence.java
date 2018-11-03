package Facebook;

/**
 * Created by archithrapaka on 4/30/17.
 */
public class LongestPrefixSequence {

    public static String longestPrefix(String[] dict) {
        String prevString = dict[0];
        String currString = "";
        String prefix = "";
        for (int i = 1; i < dict.length; i++) {
            currString = dict[1];
            prefix = getCommon(currString, prevString);
            prevString = prefix;
        }
        return prefix;
    }

    public static String getCommon(String A, String B) {
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < A.length() && j < B.length()) {
            if (A.charAt(i) != B.charAt(j)) {
                break;
            }
            sb.append(A.charAt(i));
            i++;
            j++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] s = {"BEDROOM", "BE", "BEDCLOCK", "BEDTABLE", "BEDWALL"};
        System.out.println(longestPrefix(s));
    }
}
