package Facebook;

import java.util.Stack;

/**
 * Created by archithrapaka on 4/22/17.
 */
public class BinarySearchTreeIterator {
    Stack<TreeNode> stack; // To Hold TreeNodes

    // initialize the BST with TreeNode iterator roots
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

//    public TreeNode next() {
//        TreeNode treeNode = stack.pop();
//        TreeNode right = treeNode.right;
//
//        while (right != null) {
//              stack.push(right);
//             right = right.left;
//        }
//    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    //TreeNode
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {

    }
}
