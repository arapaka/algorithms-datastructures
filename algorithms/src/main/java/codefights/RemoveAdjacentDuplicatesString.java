package codefights;

/**
 * Created by archithrapaka on 5/27/17.
 */
public class RemoveAdjacentDuplicatesString {

    // removes
    public static String removeDups(String s) {
        char res[] = new char[s.length()];
        int j = 0;
        res[j] = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != res[j]) {
                res[++j] = s.charAt(i);
            } else {
                res[j--] = '\u0000';
            }
        }

        String result = String.valueOf(res);
        return result.substring(0, j + 1);
    }

    String removeDuplicateAdjacent(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        char previous = chars[0];
        sb.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != previous) {
                sb.append(chars[i]);
                previous = chars[i];
            }
        }
        String res = sb.toString();
        return res;
    }

    public static void main(String[] args) {
        String s = "azxxzy";
        System.out.println(removeDups(s));
    }
}
