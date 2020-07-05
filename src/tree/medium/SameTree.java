package tree.medium;

import tree.TreeNode;

public class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null & q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeNode.createBinaryTree();
        TreeNode t2 = TreeNode.createBinaryTree();
        System.out.println(isSameTree(t1, t2));
    }

}
