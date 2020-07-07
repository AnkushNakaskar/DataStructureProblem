package tree.medium;

import tree.TreeNode;

public class TreeIsBalanced {

    public static int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root != null) {
            return Math.max(heightOfTree(root.left),heightOfTree(root.right)) +1;
        }
        return 0;
    }

    public static boolean isBalanced(TreeNode root) {
        if(root!=null){
            if(Math.abs(heightOfTree(root.left)-heightOfTree(root.right))>1){
                return false;
            }
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return true;
    }
/*
    3
   / \
  9  20
    /  \
   15   7


 */


    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.right = new TreeNode(7);
        node.right.left = new TreeNode(15);
        System.out.println(heightOfTree(node));
        System.out.println(heightOfTree(TreeNode.createBinaryTree3()));
        System.out.println(isBalanced(node));
        System.out.println(isBalanced(TreeNode.createBinaryTree3()));

    }
}
