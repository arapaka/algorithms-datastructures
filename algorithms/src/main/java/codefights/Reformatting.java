package codefights;

/**
 * Created by archithrapaka on 5/21/17.
 */
public class Reformatting {
    static String stringReformatting(String s, int k) {

        char[] chars = s.toCharArray();
        int count = 0;
        StringBuffer sb = new StringBuffer("");
        StringBuffer sb2 = new StringBuffer("");

        for (char c : chars) {
            if (c != '-') {
                count++;
                sb.append(c);
            }
        }
        if (count == 0) {
            return s;
        }
        System.out.println(sb.toString());
        int groups = count / k;

        int i = sb.length() - 1;
        int j;
        while (groups > 0) {
            j = 0;
            while (j < k && i >= 0) {
                sb2.append(sb.charAt(i));
                i--;
                j++;
            }

            sb2.append("-");
            groups--;
        }

        while (i >= 0) {
            sb2.append(sb.charAt(i));
            i--;
        }

        if (sb2.charAt(sb2.length() - 1) == '-') {
            sb2.deleteCharAt(sb2.length() - 1);
        }

        return sb2.reverse().toString();
    }

    public static void main(String[] rags) {
        String s = "-";
        int k = 1;
        System.out.print(stringReformatting(s, k));
    }
}
