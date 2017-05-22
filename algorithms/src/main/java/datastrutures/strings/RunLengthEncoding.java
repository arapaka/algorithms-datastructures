package datastrutures.strings;

/**
 * Created by archithrapaka on 3/11/17.
 */
public class RunLengthEncoding {


    public static void getStringEncoding(String s) {
        int charCount[] = StringUtils.getCharCount(s);

        StringBuilder stringBuilder = new StringBuilder("");

        for (char c:s.toCharArray()) {
              if(charCount[c] <= 0) {
                  continue;
              }
              stringBuilder.append(c + "" + charCount[c]);
              charCount[c] = 0; // remove the count to make sure for repeated chars sss
        }
       System.out.print(stringBuilder.toString());
    }

    public static void main(String[] args){
           String s = "abcba";
           getStringEncoding(s);
    }
}
