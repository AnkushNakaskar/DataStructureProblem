package tree.hard;

import tree.TreeNode;

public class HouseRobberiii {

    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.val;
        }


        // case1: rob the root
        int leftMax = 0;
        int rightMax = 0;

        if (root.left != null) {
            leftMax = rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            rightMax = rob(root.right.left) + rob(root.right.right);
        }

        int maxRoot = root.val + leftMax + rightMax;

        // case 2: not rob the root
        leftMax = rob(root.left);
        rightMax = rob(root.right);

        int maxNoRoot = leftMax + rightMax;

        return Math.max(maxRoot, maxNoRoot);
    }
    public static void main(String[] args) {
        int value =rob(TreeNode.createBinaryTree3());
        System.out.println(value);
    }
}
