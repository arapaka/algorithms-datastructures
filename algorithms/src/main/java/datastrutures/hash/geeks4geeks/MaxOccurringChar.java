package datastrutures.hash.geeks4geeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by archithrapaka on 2/14/17.
 */
public class MaxOccurringChar {

    public static char getMaxRepeatedCharacter(String input){
        HashMap<Character,Integer> map = new HashMap<>(128);

        for (Character c : input.toCharArray()){
               if(map.containsKey(c)){
                   map.put(c,map.get(c)+1);
               } else {
                   map.put(c,1);
               }
        }

        int max = 0;

        char maxrep = input.charAt(0);

        for (Map.Entry<Character,Integer> entry:map.entrySet()
             ) {
                 if(entry.getValue() > max){
                     max = entry.getValue();
                     maxrep = entry.getKey();
                 }
        }
        System.out.println("the count is : " + max);
        return maxrep;
    }

    public static  void checkSumPair(int[] a , int x){

        // sort the array
        Arrays.sort(a);

        int low = 0;
         int  high = a.length-1;

         while (low < high){
              if(a[low] + a[high] == x){
                  System.out.print("("+a[low] + "," + a[high]+")");
                  low++;
                  high--;
              }
              else if (a[low] + a[high] > x){
                  high--;
              }
              else {
                  low++;
              }
         }
    }

    public static void main(String[] args){
               String s = "aA";
             //System.out.println("max repeating char of : " + s + " is : " + getMaxRepeatedCharacter(s));
        int[] a = {5,6,7,7,8,9};
        checkSumPair(a,14);
    }
}
