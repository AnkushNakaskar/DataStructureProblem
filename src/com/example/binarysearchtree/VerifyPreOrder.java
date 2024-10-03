package com.example.binarysearchtree;

import java.util.List;
import java.util.Stack;

/**
 * @author ankush.nakaskar
 */
public class VerifyPreOrder {
    public static void main(String[] args) {
        int[]nums =new int[]{5,2,6,1,3};
        System.out.println(verifyPreorder(new int[]{5,2,6,1,3}));
        System.out.println(verifyPreorder(new int[]{5,2,1,3,6}));


    }
    public static boolean verifyPreorder(int[] nums) {
        if(nums==null || nums.length==1){
            return true;
        }
//We are checking the pattern if we find the low again than , what we have low in substree, then we return false, to get that pattern ,we use stack
        int low =Integer.MIN_VALUE;
        Stack<Integer> stack =new Stack<>();
        for(int val : nums){
            if(val<low){
                return false;
            }
            while(!stack.empty() && val > stack.peek()){
                low = stack.pop();
            }
            stack.push(val);
        }

        return true;
    }

    public static boolean verifyPreorderTimeConsuming(int[] nums) {
        if(nums==null || nums.length==1){
            return true;
        }
        TreeNode node = createPreOrderBST(nums);
        System.out.println(TreeNode.preOrderTraversal(node));
        List<Integer> preTravel = TreeNode.preOrderTraversal(node);
        for(int i=0;i< nums.length;i++){
            if(preTravel.get(i)!=nums[i]) return false;
        }
        return true;
    }

    private static TreeNode createPreOrderBST(int[] nums) {
        TreeNode  node = helperPreOrder(nums,null,nums[0]);
        for(int i=1;i< nums.length;i++){
            helperPreOrder(nums,node,nums[i]);
        }
        return node;
    }

    private static TreeNode helperPreOrder(int[] nums, TreeNode node, int val) {
        if(node==null){
            return new TreeNode(val);
        }
        if(val> node.val){
            node.right =helperPreOrder(nums, node.right, val);
        }else{
            node.left =helperPreOrder(nums, node.left, val);
        }
        return node;
    }
}
