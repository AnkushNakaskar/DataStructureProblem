package com.example.binarysearchtree;

import java.util.Stack;

/**
 * @author ankush.nakaskar
 */
public class ClosestValue {

    public static Stack<Integer> stack =new Stack<>();
    public static void main(String[] args) {
        TreeNode node = TreeNode.getSampleTree();
        System.out.println(closestValue(node,17));
        System.out.println(closestValue(node,11.74));
        System.out.println(closestValue(node,11.25));
        TreeNode node1 = new TreeNode(3);
        node1.left =new TreeNode(2);
        node1.left.left =new TreeNode(1);
        node1.right =new TreeNode(4);
        System.out.println(closestValue(node1,4.14));

        TreeNode node3 = new TreeNode(3);
        node3.left =new TreeNode(2);
        node3.left.left =new TreeNode(1);
        node3.right =new TreeNode(4);
        System.out.println(closestValue(node3,3.5));

        TreeNode node2 = new TreeNode(1);
        node2.right =new TreeNode(8);
        System.out.println(closestValue(node2,3));
    }

    /*
                12
              /     \
             5        18
           /   \      / \
          2     9    14   19
 */

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        stack =new Stack<>();
        inorderCheck(root,p);
        if(!stack.isEmpty()){
            Integer top = stack.pop();
        }
        return null;
    }

    private void inorderCheck(TreeNode node, TreeNode p) {
        if(node!=null){
            inorderCheck(node.left,p);
            if(stack.size()<=1 && p.val>=node.val){
                stack.push(node.val);
            }
            inorderCheck(node.right,p);
        }
    }

    public static int closestValue(TreeNode root, double target) {
        if(root.left==null && root.right==null){
            return root.val;
        }
        int val = (int)Math.round(target);
        stack =new Stack<>();
        searchInBST(root,val);
        int diff = Integer.MAX_VALUE;
        int result = -1;
        while(!stack.isEmpty()){
            int curr = stack.pop();
            if(Math.abs(val-curr) <=diff){
                diff=Math.abs(val-curr);
                result=curr;
            }
        }
        return result;
    }

    private static void searchInBST(TreeNode root, int val) {
        if(root!=null){
            searchInBST(root.left, val);
            int curr =root.val;
            if(!stack.isEmpty() && stack.peek()>val && curr>stack.peek()){
                return ;
            }else{
                stack.push(root.val);
            }
            searchInBST(root.right, val);
        }
    }
    private static TreeNode searchInBSTOld(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        int rootVal = root.val;
        if(rootVal==val){
            return root;
        }

        if(val>rootVal){
            TreeNode res = searchInBSTOld(root.right,val);
            if(res!=null)stack.push(res.val);

        }else {
            TreeNode res = searchInBSTOld(root.left,val);
            stack.push(root.val);
            if(res!=null)stack.push(res.val);

        }
        return root;
    }
}
