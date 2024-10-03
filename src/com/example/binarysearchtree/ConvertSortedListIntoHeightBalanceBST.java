package com.example.binarysearchtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ankush.nakaskar
 */
public class ConvertSortedListIntoHeightBalanceBST {
    public static void main(String[] args) {
        ListNode node = new ListNode(-10);
        node.next =new ListNode(-3);
        node.next.next =new ListNode(0);
        node.next.next.next =new ListNode(5);
        node.next.next.next.next =new ListNode(9);
        TreeNode treeNode =sortedListToBST(node);
        System.out.println(TreeNode.inorderTraversal(treeNode));
    }
//    [-10,-3,0,5,9]

    public static TreeNode sortedListToBST(ListNode listNode) {
        if(listNode==null){
            return null;
        }
        if(listNode.next==null){
            return new TreeNode(listNode.val);
        }
        List<Integer> list =new ArrayList<>();
        while (listNode!=null){
            list.add(listNode.val);
            listNode =listNode.next;
        }
        int[] nums =new int[list.size()];
        for(int i=0;i<list.size();i++){
            nums[i]=list.get(i);
        }
        int left =0;
        int right = nums.length-1;
        TreeNode node = helperBalance(nums,left,right,false);
        return node;
    }

    private static TreeNode helperBalance(int[] nums, int left, int right, boolean flag) {
        if(left<=right){
            int mid = (left+right)/2;
            TreeNode node =new TreeNode(nums[mid]);
            if(flag){
                node.right =helperBalance(nums, mid+1, right, !flag);
                node.left =helperBalance(nums, left, mid-1, !flag);
            }else{
                node.left =helperBalance(nums, left, mid-1, !flag);
                node.right =helperBalance(nums, mid+1, right, !flag);
            }
            return node;
        }
        return null;
    }
}
