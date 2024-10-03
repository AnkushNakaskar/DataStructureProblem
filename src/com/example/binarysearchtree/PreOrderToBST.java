package com.example.binarysearchtree;

import java.util.List;

/**
 * @author ankush.nakaskar
 */
public class PreOrderToBST {
    public static int index = 0;

    public static void main(String[] args) {
        TreeNode node =TreeNode.getSampleTree();
        System.out.println(TreeNode.preOrderTraversal(node));

        int[] nums = new int[]{12, 5, 2, 9, 18, 14, 19};
        nums =new int[]{5,2,6,1,3};
        TreeNode preOrderNode = bstFromPreorder(nums);
        List<Integer> travelOrder = TreeNode.preOrderTraversal(preOrderNode);
        System.out.println();

    }

    public static TreeNode helper(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = helper(root.right, val);
        } else {
            root.left = helper(root.left, val);
        }
        return root;
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = helper(null, preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            helper(root, preorder[i]);
        }
        return root;
    }
    /*
                12 (MAX)
              /     \
             5 (12)       18
           /   \         / \
          2 (5)    9    14   19
 */

}
