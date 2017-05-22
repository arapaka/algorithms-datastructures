package codefights;

/**
 * Created by archithrapaka on 5/16/17.
 */
public class SortByOtherString {

    static String sortByOther(String s , String t) {
        int[] count = new int[26];

        for (char c:s.toCharArray()) {
             count[c - 'a']++;
        }
StringBuilder sb = new StringBuilder("");
        for (char c:t.toCharArray()) {
            if(count[c - 'a'] < 0) {
                continue;
            }
            else {

                int countChar = count[c - 'a'];

                while (countChar > 0) {
                      sb.append(c);
                    countChar--;
                }

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
            String s = "weather";
            String t = "therapyw";
            System.out.println(sortByOther(s,t));
    }
}
