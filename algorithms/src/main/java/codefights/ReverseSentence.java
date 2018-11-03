package codefights;

/**
 * Created by archithrapaka on 5/21/17.
 */
public class ReverseSentence {
    String reverseSentence(String sentence) {
        String[] words = sentence.split(" ");
        String s = reverse(words);
        return s;
    }

    String reverse(String[] words) {

        int i = 0;
        int j = words.length - 1;

        while (i < j) {
            swap(i, j, words);
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder("");

        for (int k = 0; k < words.length - 1; k++) {
            sb.append(words[k]);
            sb.append(" ");
        }
        sb.append(words[words.length - 1]);
        return sb.toString();
    }

    public void swap(int i, int j, String[] words) {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }
}
