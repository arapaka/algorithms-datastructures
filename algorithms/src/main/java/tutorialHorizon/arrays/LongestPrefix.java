package tutorialHorizon.arrays;

/**
 * Created by archithrapaka on 7/2/17.
 */
public class LongestPrefix {

    public static String findLongestPrefix(String[] strings) {
        String prefix = strings[0]; // get the longest prefix ;
        String commonPrefix = "";

        for (int i = 1; i < strings.length; i++) {
               commonPrefix = commonPrefix(strings[i],prefix);
               prefix = commonPrefix;
        }
        return commonPrefix;
    }

    public static String commonPrefix(String a , String b) {
            int i = 0;
            int j = 0;
            StringBuilder sb = new StringBuilder("");
            while (i < a.length() && j < b.length()) {
                  if(a.charAt(i) == b.charAt(j)) {
                      sb.append(a.charAt(i));
                      i++;
                      j++;
                  } else {
                      break;
                  }
            }
            return sb.toString();
    }


    public static void main(String[] args) {
        String[] s = {"a", "a", "b"};
        System.out.println(findLongestPrefix(s));
    }
}
