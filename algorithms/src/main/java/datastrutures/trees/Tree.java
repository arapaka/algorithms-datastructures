package datastrutures.trees;

import java.util.*;

/**
 * Created by archithrapaka on 3/20/17.
 */
public class Tree {

    private Node root;
 public int diameter = 0;
    static class Node {
        private int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    /**
     * Recursive traversals
     */

    //Inorder recursive
    public void preOrder(Node root) {

         if(root == null) {
             return;
         }
         System.out.print(root.data+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void postOrder(Node root) {
         if(root == null) {
             return;
         }
         postOrder(root.left);
         postOrder(root.right);
         System.out.print(root.data + " ");
    }

    /**
     * Non recursive tree traversals
     * in DFS you add left subtree first
     * here you add right subtree first
     * @param
     */

    public void preOrderNonRec(Node root) {

           if(root == null) {
               return;
           }
           Stack<Node> stack = new Stack<>();
           stack.push(root);

           while (!stack.isEmpty()) {
                      Node pop = stack.pop();

                 System.out.print(pop.data + " ");

                  // add right first
                  if(pop.right != null) {
                      stack.push(pop.right);
                  }
                  // add left next if non null
                  if(pop.left != null){
                      stack.push(pop.left);
                  }
           }
    }

    /**
     * In pre order we add right and left
     * here we need the reverse of the elements after adding left first and right later , so we use a second stack
     * @param root
     */
    public void postOrderNonRecur(Node root) {
           if(root == null) {
               return;
           }
           Stack<Node> stackA = new Stack<>();
          // Stack<Node> stackB = new Stack<>();

            stackA.push(root);

        List<Integer> res = new ArrayList<>();

           while (!stackA.isEmpty() ) {
               // take out the root and insertHelper into second stack.
               Node temp = stackA.pop();
               //stackB.push(temp); // push it to second stack
               res.add(temp.data);

               if(temp.left != null) {
                   stackA.push(temp.left);
               }

               if(temp.right != null) {
                   stackA.push(temp.right);
               }

           }

        Collections.reverse(res);
    }

    /**
     * In order non recursive with stack
     */

    public void InorderNonRec(Node root) {

        ArrayList<Integer> lst = new ArrayList<Integer>();

         if(root == null) {
             return;
         }
        Stack<Node> stack = new Stack<>();

         Node p = root;

         while (p != null && !stack.isEmpty()) {
                  // go to the bottom left leaf
                   if(p!= null) {
                       stack.push(p);
                       p = p.left;
                   }
                   else {
                       Node t = stack.pop();
                       lst.add(t.data);
                       p = t.right;
                   }

         }
    }

    /**
     * BFS on Tree
     * Level order traversal
     * @param
     */

    public void breadthFirstSearch(Node root) {
         if(root == null) {
             return;
         }
        Queue<Node> queue = new LinkedList<>();
         queue.add(root);

         while (!queue.isEmpty()) {

             Node first = queue.poll();
             System.out.print(first.data + " ");

              if(first.left != null) {
                  queue.add(first.left);
              }

               if(first.right != null) {
                  queue.add(first.right);
               }
         }
    }

    /**
     * DepthFirstSearch using Stack
     * @param root
     */

    public void depthFirstSearch(Node root) {
        if(root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
             Node top = stack.pop();

               if(top.left != null) {
                   stack.push(top.left);
               }
               if(top.right != null) {
                   stack.push(top.right);
               }
            System.out.print(top.data + " ");
        }
    }

    /**
     * Get Max with recursion
     * @param root
     * @return
     */
    public int getMax(Node root) {
        int MAX_VALUE = Integer.MIN_VALUE;

        if(root == null) {
            return 0;
        }
        int leftMax = getMax(root.left);
        int rightMax = getMax(root.right);
        int maxRightOrLeft = Math.max(leftMax,rightMax);
        return Math.max(root.data,maxRightOrLeft);
    }

    /**
     * get Max without recursion
     * Level order comparison
     * @param root
     */

    public int getMaxNonRec(Node root) {
        if(root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int MAX = 0;
        while (!q.isEmpty()) {
            Node temp = q.poll();
              if(temp.data > MAX) {
                  MAX = temp.data;
              }
              if(temp.left != null) {
                  q.add(temp.left);
              }
              if(temp.right != null) {
                  q.add(temp.right);
              }
        }
        return MAX;
    }

    /**
     * search for element in a tree
     * @param root
     * @param key
     * @return
     */
    public Boolean search(Node root , int key) {
         if(root == null) {
             return false;
         }
          if(root.data == key) {
             return true;
          }
          // search in left and right trees
         return search(root.left,key) || search(root.right,key);
    }

    /**
     * BFS  Search , Level order again
     * @param key
     */

     public Boolean searchNonRec(Node root , Integer key) {
          if(root == null || key == null) {
              return false;
          }
          Queue<Node> q = new LinkedList<>();
          q.offer(root);

          while (!q.isEmpty()) {
              Node first = q.poll();
               if(first.data == key) {
                   return true;
               }

               if(first.left != null) {
                      // check if first.left's node is the key , if so return it ,
                     if(first.left.data == key) {
                         return true;
                     }
                     // else add it's subtree for processing
                     else {
                         q.offer(first.left);
                     }
               }

               if(first.right != null) {

                    if(first.right.data == key) {
                        return true;
                    }

                   else {
                        q.offer(first.right);
                    }
               }
          }
          return false;
     }

    /**
     * Insert an element into Tree
     * @param data
     */

    public void insert(int data) {
         root = insertHelper(root,data);
    }

    public Node insertHelper(Node root , int data){
           if(root == null) {
               root = new Node(data);
           }
        // this check is not necessary , just to mimic some order
     else  {
               if(root.data <= data) {
                   root.right = insertHelper(root.right,data);
               }

               else {
                   root.left = insertHelper(root.left,data);
               }

           }

         return root;
    }


    /**
     * Find size of a tree
     * total number of nodes including itself
     * @param root
     */

    public int getSize(Node root) {
         if(root == null){
             return 0;
         }
         else {
             return getSize(root.left) + 1 + getSize(root.right);
         }
    }


    /**
     * find size non recursively
     * @return
     */
    public int getSizeNonRec() {
         if(root == null){
             return 0;
         }

         Queue<Node> queue = new LinkedList<>();
         queue.add(root);
         int count = 0;
         while (!queue.isEmpty()) {
             Node temp = queue.poll();
                  count++;

               if(temp.left != null){
                   queue.add(temp.left);

               }

               if(temp.right != null) {
                   queue.add(temp.right);

               }
         }
         return count;
    }

    /**
     * Delete  a tree
     * @param
     */
    public void delete(){
        root = null;
    }

    /**
     * Post order deletion a tree
     * @param
     */

    public void delete(Node root){
          if(root == null){
              return;
          }
          delete(root.left);
          delete(root.right);
          System.out.println("deleting the current node :"+ root.data);
          root = null;
    }

    /**
     * Add right sub tree first and left sub tree next
     * push to stack the first node from queue.
     */
    public void levelOrderInReverse(){
        if(root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if(temp.right != null) {
                queue.add(temp.right);
            }
            if(temp.left != null) {
                queue.add(temp.left);
            }
            stack.push(temp);
        }

        while (!stack.isEmpty()) {
             System.out.print(stack.pop().data + " ");
        }
    }

    /**
     * Find maxDepth , between left and right to root
     * @param root
     */

    public int maxDepth(Node root) {
          if(root == null) {
              return 0;
          }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

//    /**
//     * print tree
//     * @param args
//     */
//    public void print(Node root) {
//      if(root == null) {
//          System.out.println("Tree is empty !");
//          return;
//      }
//
//
//    }

    public void printAncestors(Node root , Node target) {
        if(root == null) {
            System.out.println("No path exists for Empty Binary tree");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        List<Integer> paths = new ArrayList<>();
        paths.add(root.data);
        queue.add(root);
        Boolean pathExists = false;

        while (!queue.isEmpty()) {
              Node tmp = queue.poll();

              if(tmp.data == target.data) {
                  pathExists = true;
                  paths.add(tmp.data);
                  break;
              }

            if(tmp.left != null ) {

                      if(tmp.left.data == target.data) {
                          pathExists = true;
                          paths.add(tmp.data);
                          break;
                      }
                      else {
                          queue.add(tmp.left);
                      }

                  }

            if(tmp.right != null) {

                        if(tmp.right.data == target.data) {
                            pathExists = true;
                            paths.add(tmp.data);
                            break;
                        }
                        else {
                            queue.add(tmp.right);
                        }

                  }

        }
        if(pathExists) {
            for (Integer i:paths) {
                System.out.print(i + " ");
            }
        }
        else {
            System.out.print("No ancestors found !");
        }
    }

    //Lowest Common Ancestor of B-TREE

    public Node LCA(Node root , int a , int b) {

         if(root == null) {
             return null;
         }

         if(root.data == a || root.data == b) {
             return root;
         }

         Node left = LCA(root.left,a,b);
         Node right = LCA(root.right,a,b);

         // nodes are on separat branch
         if(left != null && right != null) {
             return root;
         } else {
             return left != null ? left : right;
         }

    }

    // LCA OF Binary Search Tree
    public Node LCA2(Node root, Node n1, Node n2) {
        while (root != null) {
            // If root>n1 and root>n2 then lowest common ancestor will be in
            // left
            // subtree.
            if (root.data > n1.data && root.data > n2.data) {
                root = root.left;
            }
            // If root<n1 and root<n2 then lowest common ancestor will be in
            // right
            // subtree.
            else if (root.data <= n1.data && root.data < n2.data) {
                root = root.right;
            }
            // if I am here that means i am at the root which is lowest common
            // ancestor
            else {
                return root;
            }
        }
        return root;
    }


//    public int distanceBetweenNodes(Node root , Node a , Node b) {
//
//    }


    /**
     * find distance between root to any node
     * count gives number of nodes , edges = count -1
     * @param a
     */

    public int findDistance(Node root , int a) {

        if(root == null ){
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int count = 0;

        while (!q.isEmpty()) {

            Node temp = q.poll();

             if(temp.data == a) {
                 return count;
             }

             if(temp.left != null) {

                  if(temp.left.data == a){
                      return count;
                  }
                 else {
                      q.add(temp.left);
                  }

             }

             if(temp.right != null) {
                   if(temp.right.data == a) {
                       return count;
                   }
                   else {
                       q.add(temp.right);
                   }
             }
             count++;
        }
        return count;
    }

    /**
     * find distance recursive
     * @param n1
     */

    public int findDistRecursive(Node root , int n1) {
           if(root != null) {

               int x = 0;
               if ((root.data == n1) || (x = findDistRecursive(root.left, n1)) > 0
                       || (x = findDistRecursive(root.right, n1)) > 0) {
                   return x + 1;

               }
           }
           return 0;
    }

    /**
     * Find disatnce between two nodes in Binary Tree
     * @param a
     */

    public int findDistanceBetweenNodes(Node root , int a , int b) {

         if(root != null) {

             int distToA = findDistance(root,a) - 1;
             int distToB = findDistance(root,b) - 1;
             Node lca = LCA(root,a,b);
             int lcaDistance = findDistance(root,lca.data);
             // distance between two nodes formula
             int distAB = distToA + distToB - lcaDistance;
             return distAB;
         }

       return 0;
    }


    /**
     * Diameter of Tree
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(Node root) {
        maxDepth2(root);
        return diameter;
    }

    // helper function for diameter
    private int maxDepth2(Node root) {
        if (root == null) return 0;

        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);

        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }


    /**
     * width of a tree @Narasimha Karumanchi's style
     * @param root
     * @return
     */
    public int width(Node root) {
        if(root == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null); // end of level 0 completion
        int level = 0;
        int max_so_far = 1; // max_elements so far , only root
        int curr_max = 1;

        while (!queue.isEmpty()) {

            Node tmp = queue.poll();

            if(tmp != null) {

                  if(tmp.left != null) {

                      queue.add(tmp.left);

                  }

                  if(tmp.right != null) {
                      queue.add(tmp.right);
                  }

            }
            else {
                // check to see if the last level has been completed and we don't add
                 if(!queue.isEmpty()) {
                     level++;
                     curr_max = queue.size();

                     if(curr_max > max_so_far){
                         max_so_far = curr_max;
                     }
                     queue.offer(null);

                 }

            }

        }
        return max_so_far;
    }


    /**
     * find width easier way
     * @param root
     */
    public int width2(Node root) {
        if(root == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        int max_width = 0;

        while (!queue.isEmpty()) {

             level = queue.size();

              if(level > max_width){
                  max_width = level;
              }

              // exhaust all elements on a level
             while (level > 0){
                  Node tmp = queue.poll();
                   if(tmp.left != null){
                       queue.offer(tmp.left);
                   }
                   if (tmp.right != null) {
                       queue.offer(tmp.right);
                   }
                 level--;
             }

        }
        return max_width;
    }

    public static void main(String[] args) {

        Tree tree = new Tree();

        Node root = new Node(1);
       tree.root = root;
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);
        //System.out.println( "In order#########");
       // tree.inOrder(root);
        System.out.println();

        //System.out.println("Pre Order");
        //tree.preOrder(root);


        //System.out.print("BFS" + " :");
        //tree.breadthFirstSearch(root);
        //System.out.println( "post order#########");
       // System.out.println();
       // tree.postOrder(root);
        System.out.println();
       // tree.postOrderNonRecur(root);
        //System.out.println("DFS : ");
        //tree.depthFirstSearch(root);
        //System.out.println(tree.getMax(root));
        //System.out.println(tree.getMaxNonRec(root));

//        System.out.println(tree.search(root,8));
//        System.out.println(tree.searchNonRec(root,8));
//        for (int i = 1; i < 8; i++) {
//            tree.insert(i);
//        }
        //tree.preOrder(root);
       // System.out.println(tree.getSize(root));
       // System.out.println(tree.getSizeNonRec());
        //tree.delete(root);

        //tree.levelOrderInReverse();
        //tree.printAncestors(root,root.left.left);
        //System.out.println(tree.findDistance(root,root.left.right.right)-1);
       // System.out.println(tree.findDistRecursive(root,45)-1);
        //System.out.println(tree.findDistanceBetweenNodes(root,20,45));
        //System.out.println(tree.diameterOfBinaryTree(root));
        System.out.println(tree.width(root));
        System.out.println(tree.width2(root));
    }
}
