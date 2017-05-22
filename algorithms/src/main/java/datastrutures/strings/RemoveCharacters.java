package datastrutures.strings;

/**
 * Created by archithrapaka on 3/4/17.
 * rEMOVE CHARACTERS FROM FIRST STRING WHICH ARE PRESENT IN SECOND
 */
public class RemoveCharacters {

    static String removeChars(String first , String second) {
        char[] count = new char[256]; // asci chars 256

        for (char c:second.toCharArray()) {
             count[c]++; // count array of chars;
        }

        String s = "";

        for (char c:first.toCharArray()
             ) {
             if(!(count[c] > 0)) {
                 s += c;
             }
        }
        return s;
    }

    public static void main(String[] args){
            System.out.print(removeChars("geeksforgeeks","mask"));
    }
}
