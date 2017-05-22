package LeetCode.TwoPointers;

/**
 * Created by archithrapaka on 4/15/17.
 */
public class SortedArrayToBst {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.data = data;
        }
    }

    public static TreeNode convertArrayToBST(int[] a , int start , int end) {

         if(start > end) return null;
         int mid = (start+end)/2;
         TreeNode root = new TreeNode(a[mid]);
         root.left = convertArrayToBST(a,start,mid-1);
         root.right = convertArrayToBST(a,mid+1,end);
         return root;
    }
    public static void main(String[] args) {

    }
}
