package com.example.binarysearchtree;

/**
 * @author ankush.nakaskar
 */
public class ConvertSortedArrayToBST {
    public static void main(String[] args) {
        int[] nums =new int[]{-10,-3,0,5,9};
        TreeNode node = sortedArrayToBST(nums);
        System.out.println(TreeNode.inorderTraversal(node));
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null){
            return null;
        }
        int left =0;
        int right=nums.length-1;
        return helper(nums,left,right);
    }

    private static TreeNode helper(int[] nums, int left, int right) {
        if(left<=right){
            int mid =(left+right)/2;
            TreeNode node =new TreeNode(nums[mid]);
            node.left = helper(nums, left, mid-1);
            node.right =helper(nums, mid+1, right);
            return node;
        }
        return null;
    }
}
