package codefights;

/**
 * Created by archithrapaka on 5/27/17.
 */
public class ExcelSheetToColumnNumber {

    static int excelSheetColumnNumber(String s) {
        int result = 0;
        int i = s.length() - 1;
        int t = 0;
        while (i >= 0) {
            char curr = s.charAt(i);
            result += (int) Math.pow(26, t) * (curr - 'A' + 1);
            t++;
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ABC";
        System.out.println(excelSheetColumnNumber(s));
    }
}
