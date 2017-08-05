package tutorialHorizon.arrays;

/**
 * Created by archithrapaka on 7/21/17.
 * Given an array arrA[], find the max­i­mum j – i such that arr[j] > arr[i].
 */
public class MaxJMinusI {


    public static int maxJMinusI(int[] a) {
        int leftMin[] = new int[a.length];
        int[] rightMax = new int[a.length];

        // fill up the lowest element index in left array
        int lowestValue = a[0];
        for (int i = 0; i < a.length; i++) {
              if(lowestValue > a[i]) {
                  lowestValue = a[i];
              }
              leftMin[i] = lowestValue;
        }

        int rightMaxValue = a[a.length-1];
        for (int i = a.length-1; i >=0 ; i--) {
             if(rightMaxValue < a[i]) {
                 rightMaxValue = a[i];
             }
             rightMax[i] = rightMaxValue;
        }

        int distanceSoFar = -1;
        int i = 0,j=0;
        //Then check if (Rmax[i]-Lmin[i])>distance_so_far

        while (i < a.length && j < a.length) {

              if(leftMin[i] < rightMax[j]) {

                    // see if the distance covered so far is greater than current
                    if(j-i > distanceSoFar) {
                        distanceSoFar = j-i;
                    }
                    j++;

              }
              // increase the left pointer
              else  {
                  i++;
              }
        }
        return distanceSoFar;
    }

    public static void main(String[] args) {
        int[] a = {12, 3, 1, 5, 6, 4, 10, 9, 8, 0};
        System.out.println(maxJMinusI(a));
    }
}
