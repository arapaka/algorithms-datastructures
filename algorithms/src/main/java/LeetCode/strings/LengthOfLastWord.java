package LeetCode.strings;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        if (s.indexOf(" ") >= 0) {
            String[] split = s.split(" ");
            if (split.length == 0) {
                return 0;
            }
            return split[split.length - 1].length();
        }
        return s.length();
    }

    //best 3 liner
    public static int lengthOfLastWord2(String s) {
        s = s.trim();
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;
    }

    public static void main(String[] args) {
        String s = "Hello world you  ";
        System.out.println(lengthOfLastWord(s));
        String s2 = "Hello, my name is John";
        System.out.println(s2.trim());
    }
}
