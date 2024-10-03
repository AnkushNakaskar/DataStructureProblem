package com.example.breadthfirstsearch;

/*
Image method1 file


/* Let us construct below tree
             17
            /   \
           11     21
             \       \
              15       24
               \       /   \
               16      23   25
                             \
                             26

 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode treeNode = (TreeNode) o;

        return val == treeNode.val;
    }

    @Override
    public int hashCode() {
        return val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + val +
                '}';
    }

     /*
        17
      /       \
    11           21
      \            \
       15         24
        \        /    \
       16      23    25
                            \
                            26

 */

    public static TreeNode createBinaryTree() {
        TreeNode root = new TreeNode(17);
        TreeNode elev = new TreeNode(11);
        root.left = elev;
        elev.right = new TreeNode(15);
        elev.right.right = new TreeNode(16);

        root.right = new TreeNode(21);
        root.right.right = new TreeNode(24);
        root.right.right.left = new TreeNode(23);
        root.right.right.right = new TreeNode(25);
        root.right.right.right.right = new TreeNode(26);

        return root;
    }


    /*
        17
      /       \
    13           21
    /  \            \
   10    15         24
   / \     \        /    \
  4  11     16      23    25
                            \
                            26

 */


    public static TreeNode createBinaryTree2() {
        TreeNode root = new TreeNode(17);
        root.left = new TreeNode(13);
        root.left.right = new TreeNode(15);
        root.left.right.right = new TreeNode(16);
        root.left.left = new TreeNode(10);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(11);

        root.right = new TreeNode(21);
        root.right.right = new TreeNode(24);
        root.right.right.left = new TreeNode(23);
        root.right.right.right = new TreeNode(25);
        root.right.right.right.right = new TreeNode(26);

        return root;
    }


/*
        7
      /   \
    2       9
      \
        4
          \
            5
             \
               6
 */

    public static TreeNode createBinaryTree3() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        root.right = new TreeNode(9);
//        root.right.right=new TreeNode(10);

        return root;
    }

    public static TreeNode createNotBinarySearchTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(1);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(6);

        return root;
    }

    /*
     1
   / \
  2   2
 / \ / \
3  4 4  3

     */

    public static TreeNode createNotBinarySearchTreeMirror() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        return root;
    }

    /*

     1
   / \
  2   2
   \   \
   3    3

     */
    public static TreeNode createNotBinarySearchTreeNotMirror() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        return root;
    }

    public static void printInOrder(TreeNode root){
        if(root!=null){
            printInOrder(root.left);
            System.out.print(" "+root.val);
            printInOrder(root.right);
        }
    }
    public static void printPreOrder(TreeNode root){
        if(root!=null){
            System.out.print(" "+root.val);
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }
    public static void printPostOrder(TreeNode root){
        if(root!=null){
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(" "+root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode =new TreeNode(1);
        treeNode.left =new TreeNode(2);
        treeNode.left.left=new TreeNode(4);
        treeNode.left.right =new TreeNode(5);
        treeNode.right =new TreeNode(3);
        printPreOrder(TreeNode.createBinaryTree2());
        System.out.println();
        printInOrder(TreeNode.createBinaryTree2());
        System.out.println();

        printPostOrder(TreeNode.createBinaryTree2());
    }

}

