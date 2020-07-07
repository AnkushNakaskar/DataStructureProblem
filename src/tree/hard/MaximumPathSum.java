package tree.hard;

import tree.TreeNode;

public class MaximumPathSum {

    static int max_sum;

    public static int maxPathSum(TreeNode root) {
        max_sum = Integer.MIN_VALUE;
        pathSum(root);
        return max_sum;
    }

    public static int pathSum(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(0, pathSum(root.left));
        int right = Math.max(0, pathSum(root.right));
        max_sum = Math.max(max_sum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(-10);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.right = new TreeNode(7);
        node.right.left = new TreeNode(15);
        System.out.println(maxPathSum(node));


        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        maxPathSum(node1);
        System.out.println(maxPathSum(node1));


    }

}
