package codefights;

/**
 * Created by archithrapaka on 5/27/17.
 */
public class AmendTheSentence {

    static String amendTheSentence(String s) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < s.length();i++) {
            char c = s.charAt(i);
            if(i != 0 && Character.isUpperCase(c)) {
                sb.append(" ");
                Character.toLowerCase(c);
                sb.append(c);
            } else {
                sb.append(c);
            }
        }
        return sb.toString().toLowerCase();
    }

    public static void main(String[] args) {
        String s = "CodefightsIsAwesome";
        System.out.print(amendTheSentence(s));
    }
}
