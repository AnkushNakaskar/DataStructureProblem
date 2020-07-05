package tree.medium;

import tree.TreeNode;

public class IsThisBST {

    static boolean checkBST(TreeNode root) {
        if(root!=null){
            if(root.left!=null && root.left.val >root.val){
                return false;
            }else if(root.left!=null && root.right.val <root.val){
                return false;
            }
            return checkBST(root.left) && checkBST(root.right);
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(checkBST(TreeNode.createNotBinarySearchTree()));
    }
}
