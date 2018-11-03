package datastrutures.strings;

/**
 * Created by archithrapaka on 4/6/17.
 */
public class ReverseWords<K> {

    // reversing words in a array
    public void reverse(K[] o, int i, int j) {
        if (o.length <= 1 || i > j) {
            return;
        }
        while (i <= j) {
            K temp = o[i];
            o[i] = o[j];
            o[j] = temp;
            i++;
            j--;
        }
        for (K s : o) {
            System.out.print(s);
        }
    }

    public void reverseChar(char[] chars) {

        reverseChars(chars, 0, chars.length - 1);

        int i = 0;
        int j;
        for (j = 0; j < chars.length; j++) {
            if (chars[j] == ' ') {
                reverseChars(chars, i, j - 1);
                i = j + 1;
            }
        }
        // last word must be reversed
        reverseChars(chars, i, j - 1);
        for (char c : chars) {
            System.out.print(c);
        }
    }

    public void reverseChars(char[] chars, int i, int j) {
        if (chars.length <= 1 || i > j) {
            return;
        }
        while (i <= j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }

    public void reverseVowels(String s) {

    }

    public static void main(String[] args) {
        String s = "rowdy this is a man";
        ReverseWords<String> reverseWords = new ReverseWords<>();
        //reverseWords.reverse(new String[]{"I"," ","am"},0,2);
        //reverseWords.reverseChar(s.toCharArray());

    }

}
