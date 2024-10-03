package com.example.binarysearchtree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author ankush.nakaskar
 */
public class SplitBST {

    public static Set<TreeNode> set;
    public static Stack<TreeNode> stack;
    public static void main(String[] args) {
        TreeNode node = TreeNode.getSampleTree();
        TreeNode[] res = splitBST(node,5);
        System.out.println(TreeNode.inorderTraversal(res[0]));
        System.out.println(TreeNode.inorderTraversal(res[1]));
    }
    /*
                12
              /     \
             5        18
           /   \      / \
          2     9    14   19
 */
    public static TreeNode[] splitBST(TreeNode root, int target) {
        stack =new Stack<>();
        if(root==null){
            return new TreeNode[0];
        }
        TreeNode[] res = new TreeNode[2];
        if(root.val==target){
            res[0]= root;
            if(root.right!=null){
                res[1]=root.right;
                root.right=null;
            }else{
                res = new TreeNode[1];
                res[0]=root;
                return res;
            }
        }
        inOrderIntoStack(root,target);
        TreeNode largeNode = stack.pop();
        TreeNode targetNode = stack.pop();
        if(largeNode==root){
            res[0]= root;
            res[1]= root.left;
            root.left=null;
        }

        System.out.println(stack);
        return res;
    }

    private static void inOrderIntoStack(TreeNode root, int target) {
        if(root!=null){
            inOrderIntoStack(root.left, target);
            if(stack.isEmpty()){
                stack.push(root);
            }else if( !(stack.peek().val>target)){
                stack.push(root);
            }
            inOrderIntoStack(root.right, target);
        }
    }


    public static TreeNode[] splitBSTOld(TreeNode root, int target) {
        set =new HashSet<>();
        findLessThanTargetNode(root,target);
        TreeNode[] result =new TreeNode[2];
        if(!set.isEmpty()){
            TreeNode leftTree = set.iterator().next();
            set.remove(leftTree);
            result[0]=leftTree;
            if(leftTree==root){
                TreeNode rightTree = leftTree.right;
                result[1]=rightTree;
                leftTree.right =null;
            }else{
                getParentNode(root,leftTree);
                TreeNode parentNode =set.iterator().next();

                if(parentNode.left == leftTree){
                    parentNode.left = leftTree.right;
                    leftTree.right =null;
                    result[1]=root;
                }


            }
        }
        return result;
    }

    private static void getParentNode(TreeNode root,TreeNode leftTree) {

        if(root!=null){
            if(root.left==leftTree || root.right==leftTree){
                set.add(root);
                return;
            }
            if(leftTree.val > root.val){
                getParentNode(root.right, leftTree);
            }else{
                getParentNode(root.left, leftTree);
            }
        }
    }

    private static void findLessThanTargetNode(TreeNode node, int target) {
        if(node!=null){
            if(node.val==target){
                set.add(node);
            }else if(target>node.val){
                findLessThanTargetNode(node.right,target);
            }else {
                findLessThanTargetNode(node.left,target);
            }
        }
    }
}
