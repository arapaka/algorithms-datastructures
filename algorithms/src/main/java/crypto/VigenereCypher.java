package crypto;

/**
 * Created by archithrapaka on 6/11/17.
 */
public class VigenereCypher {

    public static String encrypt(String text, final String key) {
        char start = ' ';
        char end = '~';
        StringBuilder sb = new StringBuilder("");
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < start || c > end) {
                continue;
            }
            sb.append((char) ((c + key.charAt(j)) % 94));
            j = ++j % key.length();
        }
        return sb.toString();
    }

    public static String decrypt(String text, final String key) {
        char start = ' ';
        char end = '~';
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < start || c > end) {
                continue;
            }
            stringBuilder.append((char) ((c - key.charAt(j)) % 94));
            j = ++j % key.length();
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String key = "encodeThisNow";
        String original = "What The World Needs!";

        String key2 = "CAT";
        String ori2 = "PUPPY";

        String enc = encrypt(original, key);
        //String enc2 = encrypt(ori2,key2);

        System.out.println("the encrypted code " + enc);
        System.out.println(decrypt(enc, key));
    }
}
