package codefights;

/**
 * Created by archithrapaka on 6/9/17.
 */
public class SumBinaryStrings {

    public static String sumBinaryStrings(String x , String y) {
        int max = Math.max(x.length(),y.length());
        int[] carry = new int[max];

        int i = x.length()-1;
        int j = y.length()-1;
        int k = 0;
        int carryK = 0;
        StringBuilder res = new StringBuilder("");
        while (i >= 0 && j >= 0) {
            int x1 = Integer.parseInt(x.charAt(i) + "");
            int y1 = Integer.parseInt(y.charAt(j) + "");
            int sum = x1+y1+carryK;
            carryK = 0;

            if(sum >= 10) {
                carryK = sum/10;
                sum = sum % 10;
            }
            res.append(sum + "");
            i--;
            j--;
        }

        while (i >=0) {
            int sum = Integer.parseInt(x.charAt(i) + "") + carryK;
            carryK = 0;
            if(sum >= 10) {
                carryK = sum/10;
                sum = sum % 10;
            }
            res.append(sum + "");
            i--;
        }

        while (j >= 0) {
            int sum = Integer.parseInt(y.charAt(j) + "") + carryK;
            carryK = 0;
            if(sum >= 10) {
                carryK = sum/10;
                sum = sum % 10;
            }
            res.append(sum + "");
            j--;
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1000";
        String b = "111";
        System.out.println(sumBinaryStrings(a,b));
    }
}
