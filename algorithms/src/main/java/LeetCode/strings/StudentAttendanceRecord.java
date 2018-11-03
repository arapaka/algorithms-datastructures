package LeetCode.strings;

public class StudentAttendanceRecord {

    public static boolean checkRecord(String s) {
        int countA = 0;

        for (char c : s.toCharArray()) {
            if (c == 'A') {
                countA++;
            }
        }
        return countA <= 1 && s.indexOf("LLL") < 0;
    }

    // best
    public boolean checkRecord2(String s) {
        if (s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"))
            return false;
        return true;
    }

    public static void main(String[] args) {

    }
}
