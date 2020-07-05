package tree.medium;

import tree.TreeNode;

public class CheckIFMirrorTree {

    public static boolean checkMirror(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        }
        if(p!=null && q==null){
            return false;
        }
        if(p!=null && q!=null){
            if(p.val !=q.val){
                return false;
            }
            return checkMirror(p.left,q.right) && checkMirror(p.right,q.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root!=null){
            return checkMirror(root.left,root.right);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createNotBinarySearchTreeNotMirror();
        System.out.println(checkMirror(treeNode.left, treeNode.right));


    }
}
