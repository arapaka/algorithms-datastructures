package LeetCode.strings;

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split(".");
        String[] v2 = version2.split(".");
        int a1 = Integer.parseInt(v1[0]);
        int a2 = Integer.parseInt(v1[1]);
        int b1 = Integer.parseInt(v2[0]);
        int b2 = Integer.parseInt(v2[1]);

        if (a1 > b1) {
            return 1;
        } else if (a1 == b1) {

            //a2 > b2
            if (a2 > b2) {
                return 1;
            } else if (a2 < b2) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }

    }


    public static void main(String[] args) {

    }
}
