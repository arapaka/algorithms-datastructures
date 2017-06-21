package hackerrank;

/**
 * Created by archithrapaka on 6/6/17.
 */
public class HackerRankInAString {

    public static boolean findHackerRankBetter(String s) {
        String hackerRank = "hackerrank";
        int i = 0;
        int j = 0;

        while (i < s.length() && j < hackerRank.length()) {

               if(s.charAt(i) == hackerRank.charAt(j)) {
                   i++;
                   j++;
               } else {
                   i++;
               }
        }
        return (j == hackerRank.length());
    }
    public static void main(String[] args) {
            String s = "hereiamstackerrank";
            System.out.println(findHackerRankBetter(s));
    }
}
