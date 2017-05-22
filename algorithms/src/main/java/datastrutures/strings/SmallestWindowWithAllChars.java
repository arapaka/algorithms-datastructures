package datastrutures.strings;

/**
 * Created by archithrapaka on 3/11/17.
 */
public class SmallestWindowWithAllChars {

    public static void minWindow(String s, String t) {
        String result = "";
        if(s==""||t.length()>s.length()){
            System.out.println("no min window");
            return ;
        }

        int[] map = new int[128];
        int start = 0;
        int minStart = 0;
        int end = 0;
        int count = t.length();
        int minLength = Integer.MAX_VALUE;
        for(char temp:t.toCharArray()){
            map[temp]++;
        }
        while(end<s.length()){
            if(map[s.charAt(end++)]-- >0)
                count--;
            //map[s.charAt(end)]--;
            //end++;
            while(count==0){
                if (end - start < minLength) {
                    minStart = start;
                    minLength = end - start;
                }
                map[s.charAt(start)]++;
                if (map[s.charAt(start)] > 0)
                    count++;
                start++;
            }
        }
        System.out.print((minLength==Integer.MAX_VALUE)?"":s.substring(minStart, minStart+minLength));
    }

    public static void main(String[] args){
           String s = "this is a test string";
           String pat = "tist";
           minWindow(s,pat);
    }
}
