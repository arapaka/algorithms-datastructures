package Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by archithrapaka on 4/22/17.
 */
public class GenerateWellFormedParanthesis {

    public static void generate(int n) {
        List<String> list = new ArrayList<>();
        generate("",list,n,n);

        for (String s:list) {
            System.out.println(s);
        }
    }

    private static void generate(String s, List<String> list, int left, int right) {
         if(left > right) {
             return;
         }

         if(left > 0) {
             generate(s + "(",list,left-1,right);
         }
         if(right > 0) {
             generate(s+")",list,left,right-1);
         }
         if(left == 0 && right == 0) {
             list.add(s);
             return;
         }
    }

    public static void main(String[] args){
        generate(4);
    }
}
