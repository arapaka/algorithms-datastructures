package tutorialHorizon.arrays;

/**
 * Created by archithrapaka on 7/2/17.
 */
public class ReArrangePositiveNegativeNumbers {

    /**
     * This method separates Positive and negative numbers in array
     * @param a
     */
    public static void reArrange(int[] a) {
        int pivot = 0;
        int i = 0;
        int j = a.length-1;

        while (i < j) {
               while (i < a.length && a[i] < pivot) {
                   i++;
               }

               while (j >= 0 && a[j] > pivot) {
                   j--;
               }
               if(i < j) {
                   int temp = a[i];
                   a[i] = a[j];
                   a[j] = temp;
                   i++;
                   j--;
               }
        }
    }

    public static void divideGroups(int[] a , int low , int high) {
         if(low >= high) {
             return;
         }
         int mid = (high+low) >>> 1;

         divideGroups(a,low,mid);
         divideGroups(a,mid+1,high);
         merge(a,low,mid,high);
    }

    /**
     * this uses o(n)
     * @param a
     * @param low
     * @param mid
     * @param high
     */
    public static void merge2(int[] a , int low , int mid , int high) {
            int i,j,k;
            int n1 = mid-low+1;
            int n2 = high-mid;
            int[] left = new int[n1];
            int[] right = new int[n2];

            for (i = 0; i < n1; i++)
            left[i] = a[low + i];

            for (j = 0; j < n2; j++)
            right[j] = a[mid + 1 + j];

            i = 0; //left subarray
            j= 0; // right subarray
            k = low; // merged subarray

        // copy negative elements of left subarray
        while (i < n1 && left[i] < 0)
            a[k++] = left[i++];

        // copy negative elements of right subarray
        while (j < n2 && right[j] < 0)
            a[k++] = right[j++];

        // copy positive elements of left subarray
        while (i < n1)
            a[k++] = left[i++];

        // copy positive elements of right subarray
        while (j < n2)
            a[k++] = right[j++];
    }

    public static void merge(int[] a, int low , int mid , int high) {
        int l = low;
        int k = mid+1;

        while (l <= mid && a[l] <= 0) {
            l++;
        }

        while (k <= high && a[k] <= 0) {
            k++;
        }
        reverse(a,l,mid);
        reverse(a,mid+1,k-1);
        reverse(a,l,k-1);
    }

    public static void display(int[] a) {
        for (Integer integer : a) {
            System.out.print(integer + " ");
        }
    }

    public static void reverse(int[] arrA,int x, int y) {
        while (y > x) {
            int temp = arrA[x];
            arrA[x] = arrA[y];
            arrA[y] = temp;
            x++;
            y--;
        }
    }

    public static void main(String[] args) {
          int[] a = {-2,1,-3,4,-5};
          //reArrange(a);
           divideGroups(a,0,a.length-1);
          display(a);
    }
}
