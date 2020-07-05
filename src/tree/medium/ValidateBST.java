package tree.medium;

import tree.TreeNode;

public class ValidateBST {
    public static boolean validate(TreeNode root) {
        if (root != null) {

            if (root.left != null && root.val < root.left.val) {
                return false;
            }
            if (root.right != null && root.val > root.right.val) {
                return false;
            }
            if(!validate(root.left) || !validate(root.right)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validate(TreeNode.createBinaryTree3()));
        System.out.println(validate(TreeNode.createNotBinarySearchTree()));

    }
}
