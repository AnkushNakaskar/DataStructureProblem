package tree.medium;

import tree.Node;

public class ValidateBST {
    public static boolean validate(Node root) {
        if (root != null) {

            if (root.left != null && root.data < root.left.data) {
                return false;
            }
            if (root.right != null && root.data > root.right.data) {
                return false;
            }
            if(!validate(root.left) || !validate(root.right)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validate(Node.createBinaryTree3()));
        System.out.println(validate(Node.createNotBinarySearchTree()));

    }
}
