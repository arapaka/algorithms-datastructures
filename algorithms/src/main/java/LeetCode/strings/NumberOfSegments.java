package LeetCode.strings;

public class NumberOfSegments {

    public static int countSegments(String s) {
        s = s.trim();
        int count = 0;
        if (s.indexOf(' ') >= 0) {
            String[] split = s.split(" ");
            for (String string : split) {
                if (!string.equals("")) {
                    count++;
                }
            }
            return count;
        }
        return s.isEmpty() ? 0 : 1;
    }

    //best
    public static int countSegments2(String s) {
        String trimmed = s.trim();
        if (trimmed.length() == 0) {
            return 0;
        } else {
            String[] split = trimmed.split("\\s+");
            return split.length;
        }

    }

    public static void main(String[] args) {
        String s = ", , , ,        a, eaefa";
        System.out.println(countSegments2(s));

    }
}
