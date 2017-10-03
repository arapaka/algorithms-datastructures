package LeetCode.strings;

public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] rc = getCount(ransomNote);
        int count = ransomNote.length();
        for (char c : magazine.toCharArray()) {
             if(rc[c - 'a'] > 0) {
                 rc[c - 'a']--;
                 count--;
             }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String rc = "fffbfg";
        String mag = "effjfggbffjdgbjjhhdegh";
        System.out.println(canConstruct(rc,mag));
    }

    public static int[] getCount(String s) {
        int[] count = new int[26];

        for (char c:s.toCharArray()) {
             count[c - 'a']++;
        }
        return count;
    }
}
