package LeetCode.TwoPointers;

/**
 * Created by archithrapaka on 4/13/17.
 */
public class findTheDifference {

    public static void printDiff(String s, String t) {

        int[] sCount = getCharCount(s);

        for (char c : t.toCharArray()) {
            if (sCount[c] == 0) {
                System.out.print("the missing char is : " + c);
                break;
            }
        }
    }

    public static int[] getCharCount(String s) {
        int[] count = new int[126];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
