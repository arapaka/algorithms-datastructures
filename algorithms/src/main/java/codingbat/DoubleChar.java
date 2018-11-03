package codingbat;

import java.net.URL;
import java.net.URLDecoder;

/**
 * Created by archithrapaka on 4/26/17.
 */
public class DoubleChar {

    public static int countHi(String str) {
        int[] count = new int[256];

        for (char c : str.toCharArray()) {
            count[c]++;
        }
        int h = count['h'];
        int i = count['i'];
        int countHi = 0;
        while (h > 0 && i > 0) {
            h--;
            i--;
            countHi++;
        }
        return countHi;
    }

    public static void decode(String s) throws Exception {
        String decode = URLDecoder.decode(s, "UTF-8");
        System.out.println(decode);
        String[] decodeSplit = decode.split("\\.");
        System.out.println(decodeSplit[1]);
        String path = new URL(decode).getPath();
        //path = path.replaceFirst("/", "");
//        for (String s1:path.split("/")) {
//            System.out.print(s1);
//        }

        System.out.println(path.split("/")[1]);
    }

    public static void main(String[] args) throws Exception {
//        System.out.print(countHi("ABChi hi") );
//        System.out.print(countHi("abc hi ho"));
//        System.out.print(countHi("hihi"));
        String s = "https%3A%2F%2Fwww.adobe.com%2fsomething";
        decode(s);
    }
}

// path could be empty