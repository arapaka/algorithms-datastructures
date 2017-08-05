package tutorialHorizon.arrays;

/**
 * Created by archithrapaka on 7/19/17.
 */
public class SortedArrayToBstMin {

    public static Tree convertArrayToBst(int[] a , int left , int right) {
         if(left > right) {
             return null;
         }

        int mid = (left+right) >>> 1;
        Tree root = new Tree(a[mid]);
        root.left = convertArrayToBst(a,left,mid-1);
        root.right = convertArrayToBst(a,mid+1,right);
        return root;
    }


    private static class Tree {
         int data;
         Tree left;
         Tree right;

         public Tree(int data) {
             this.data = data;
             this.left = null;
             this.right = null;
         }
    }


    public static void main(String[] rags) {
        int[] a = {1,4,5,6,8,9,10};

    }
}
