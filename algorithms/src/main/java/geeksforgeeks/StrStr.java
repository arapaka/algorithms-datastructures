package geeksforgeeks;

/**
 * Created by archithrapaka on 6/8/17.
 */
public class StrStr {


    //Brute force o(mn)
    public static int findString(String x, String target) {
        return x.indexOf(target);
    }

    /**
     * Knuth Morris Pratt Algorithm
     *
     * @param pattern
     * @param text
     */
    int search(String pattern, String text) {
        int[] lsp = computeLspTable(pattern);

        int j = 0;  // Number of chars matched in pattern
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                // Fall back in the pattern
                j = lsp[j - 1];  // Strictly decreasing
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                // Next char matched, increment position
                j++;
                if (j == pattern.length())
                    return i - (j - 1);
            }
        }

        return -1;  // Not found
    }

    int[] computeLspTable(String pattern) {
        int[] lsp = new int[pattern.length()];
        lsp[0] = 0;  // Base case
        for (int i = 1; i < pattern.length(); i++) {
            // Start by assuming we're extending the previous LSP
            int j = lsp[i - 1];
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
                j = lsp[j - 1];
            if (pattern.charAt(i) == pattern.charAt(j))
                j++;
            lsp[i] = j;
        }
        return lsp;
    }

    public static void main(String[] args) {

    }
}
