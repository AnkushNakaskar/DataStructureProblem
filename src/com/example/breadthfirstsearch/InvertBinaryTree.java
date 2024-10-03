package com.example.breadthfirstsearch;

/**
 * @author ankush.nakaskar
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(9);
        TreeNode result = invertTree(root);
        System.out.println(result);
    }

    public static TreeNode invertTree(TreeNode root) {

        TreeNode newRoot = helper(root);
        return newRoot;
    }

    private static TreeNode helper(TreeNode root) {
        if(root!=null){
            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;
            root.right= leftNode;
            root.left=rightNode;
            helper(leftNode);
            helper(rightNode);
            return root;
        }
        return null;
    }
}
