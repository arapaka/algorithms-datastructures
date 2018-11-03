package LeetCode.strings;

public class DetectCapital {


    public static boolean detectCapitalUse(String word) {
        int upperCase = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c - 'a' < 0) {
                upperCase++;
            }
        }
        if (word.charAt(0) - 'a' < 0) {
            return (upperCase == 1 || upperCase == word.length());
        }
        return (upperCase == 0 || upperCase == word.length());
    }

    // Best
    public boolean detectCapitalUse2(String word) {
        if (word.length() < 2) return true;
        if (word.toUpperCase().equals(word)) return true;
        if (word.substring(1).toLowerCase().equals(word.substring(1)))
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String s2 = "LeetCode";
        String s3 = "FlAg";
        String s4 = "USA";
        System.out.println(detectCapitalUse(s));
        System.out.println(detectCapitalUse(s2));
        System.out.println(detectCapitalUse(s3));
        System.out.println(detectCapitalUse(s4));
    }
}
