package tree;

public class LCMOFTree {
    public static TreeNode lca(TreeNode root, int v1, int v2) {
        if (root == null) {
            return null;
        }
        if (root.val == v1 || root.val == v2) {
            return root;
        }
        TreeNode left = lca(root.left, v1, v2);
        TreeNode right = lca(root.right, v1, v2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }


    public static void main(String[] args) {
        System.out.println(lca(TreeNode.createBinaryTree2(), 10, 15));
//        lca(TreeNode.createBinaryTree2(), 10, 15);//13,17

    }
}
