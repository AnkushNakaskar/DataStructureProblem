package com.example.binarysearchtree;

/**
 * @author ankush.nakaskar
 */
public class PostOrderToBST {
    public static int index = 0;

    public static void main(String[] args) {
        TreeNode node =TreeNode.getSampleTree();
        System.out.println(TreeNode.preOrderTraversal(node));
        System.out.println(TreeNode.postOrderTraversal(node));

        int[] nums = new int[]{2, 9, 5, 14, 19, 18, 12};
//        nums = new int[]{12, 5, 2, 9, 18, 14, 19};
        TreeNode preOrderNode = bstFromPostOrder(nums);
        System.out.println(TreeNode.preOrderTraversal(preOrderNode));

    }

    private static TreeNode helper(int[] nums,TreeNode root,int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(val> root.val){
            root.right =helper(nums, root.right, val);
        }else{
            root.left =helper(nums, root.left, val);
        }
        return root;
    }
    private static TreeNode bstFromPostOrder(int[] nums) {
        TreeNode root = helper(nums,null,nums[nums.length-1]);
        for(int i= nums.length-2;i>=0;i--){
            helper(nums,root,nums[i]);
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
