package tree.medium2;

import tree.TreeNode;

public class DiameterOfTree {

    //Check out the optimal solution at : https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
    static public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root!=null ){
            if((root.left==null && root.right==null))
                return 0;
        }
        int val =height(root.left) + height(root.right) + 1+1;
        System.out.println(val);
        return val;
    }

    static public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height=Math.max(height(root.left), height(root.right) + 1);
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
        System.out.println(">>>>"+diameterOfBinaryTree(root));
    }

}
