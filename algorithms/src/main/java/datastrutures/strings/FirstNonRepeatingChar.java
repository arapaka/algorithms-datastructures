package datastrutures.strings;

/**
 * Created by archithrapaka on 3/5/17.
 */
public class FirstNonRepeatingChar {

    static void getFirstNonRepeatingChar(String s) {
        int[] count = new int[256];// count array of ascii
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        for (char c : s.toCharArray()
        ) {
            if (count[c] == 1) {
                System.out.print(c);
                break;
            }
        }
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        getFirstNonRepeatingChar(s);
    }
}
