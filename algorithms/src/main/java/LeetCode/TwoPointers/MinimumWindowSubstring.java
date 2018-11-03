package LeetCode.TwoPointers;

/**
 * Created by archithrapaka on 4/9/17.
 */
public class MinimumWindowSubstring {

    public static String minWindowSubstring(String s, String t) {
        assert s.length() >= t.length();
        int end = 0;
        int begin = 0;
        int head = 0;
        int d = Integer.MAX_VALUE;
        int[] count = new int[256]; // ascii
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        int counter = count.length;

        while (end < s.length()) {
            if (count[s.charAt(end)] > 0) {
                counter--;
            }
            count[s.charAt(end)]--;
            end++;

            while (counter == 0) {
                if (end - begin < d) {
                    d = end - begin;
                    head = begin;
                }
                count[s.charAt(begin)]++;
                if (count[s.charAt(begin)] > 0) {
                    counter++;
                }
                begin++;
            }
        }
        if (d != Integer.MAX_VALUE) {
            return s.substring(head, d);
        } else {
            return "";
        }
    }

    public void main(String[] args) {

    }
}
