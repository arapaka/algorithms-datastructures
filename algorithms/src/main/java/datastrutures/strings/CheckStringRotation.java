package datastrutures.strings;

/**
 * Created by archithrapaka on 3/4/17.
 */
public class CheckStringRotation {

    static boolean checkRotation(String s , String b) {

        return (s.length() == b.length()) && s.concat(s).indexOf(b) >= 0;
    }

    static void printReverse(String s, int length){
         if(length == s.length()) {
             return;
         }
         printReverse(s,length+1);
         System.out.print(s.charAt(length));
    }

    public static void main(String[] args){
//        if(checkRotation("AACD","ACDA")) {
//            System.out.println("Strings are rotations of each other");
//        } else {
//            System.out.println("Strings are Not rotations of each other");
//        }
        String s = "abc";
        printReverse(s,0);
    }
}
