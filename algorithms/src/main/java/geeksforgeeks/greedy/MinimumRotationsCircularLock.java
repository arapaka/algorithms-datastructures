package geeksforgeeks.greedy;

public class MinimumRotationsCircularLock {

    public static int minRotations(String currentCode,String unlockCode) {
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < currentCode.length() && j < unlockCode.length()) {
            int a = Character.getNumericValue(currentCode.charAt(i));
            int b = Character.getNumericValue(unlockCode.charAt(j));
            count += Math.min(Math.abs(a-b),10-Math.abs(a-b));
            i++;
            j++;
        }
        return count;
    }

    public static void main(String[] args){
        //System.out.println(minRotations("2345","5432"));
        System.out.println(minRotations("28756","98234"));
    }
}
