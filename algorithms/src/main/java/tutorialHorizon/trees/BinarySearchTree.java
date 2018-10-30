package tutorialHorizon.trees;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node insert(int n) {
        return insertHelper(n,root);
    }

    public Node insertHelper(int n , Node node) {
        if(node == null) {
            node = new Node(n);
            return node;
        }

        if(n <= node.data) {
            return insertHelper(n,node.left);
        }
        return insertHelper(n,node.right);
    }

    public void display () {

        if(root == null) {
           System.out.println("the root is null");
        }

    }

    public static void main(String[] args) {

    }
}
