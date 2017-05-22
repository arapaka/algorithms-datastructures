package datastrutures.strings;

/**
 * Created by archithrapaka on 3/4/17.
 */
public class PrintAllPermutations {

    static void permute(String remaining , String main) {
        if(main.length() == 0){
             System.out.println(remaining);
             return;
         }
        for (int i = 0; i < main.length(); i++) {
             String rem = main.substring(0,i)+main.substring(i+1);
            permute(remaining+main.charAt(i), rem);
        }
    }

    static void permuteUnique(char[] s , int index) {
         if(index == s.length) {
             for (int i = 0; i < s.length; i++) {
                 System.out.print(s[i]);
             }
             System.out.println();
         }
         else {
                // permute once without swaps
              permuteUnique(s,index+1);
              char lastChar = s[index];

             for (int j = index+1; j < s.length; j++) {

                  if(lastChar == s[j]) {
                      continue;
                  } else {
                      lastChar = s[j];
                  }
                        swap(s,index,j);
                        permuteUnique(s,index+1);
                        swap(s,index,j);
             }
         }
    }

    static void swap(char[] s , int a , int b) {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }
    public static void main(String[] args) {
        //permute("","ACBC");
        permuteUnique("aab".toCharArray(),0);
        "abc".hashCode();
        //HashMap<HashMap<Integer,Integer>,Integer> hashMapIntegerHashMap = new HashMap<>();

    }
}
