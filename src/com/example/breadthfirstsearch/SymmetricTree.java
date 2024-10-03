package com.example.breadthfirstsearch;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author ankush.nakaskar
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(3);
        root.right.right=new TreeNode(4);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {

        TreeNode leftTree =root.left;
        TreeNode rightTree = root.right;
        if(leftTree==null && rightTree!=null){
            return false;
        }
        if(leftTree!=null && rightTree==null){
            return false;
        }
        if(leftTree.val!= rightTree.val){
            return false;
        }
        Queue<TreeNode> leftQueue =new ArrayDeque<>();
        leftQueue.add(leftTree);
        Queue<TreeNode> rightQueue =new ArrayDeque<>();
        rightQueue.add(rightTree);
        while(!leftQueue.isEmpty() && !rightQueue.isEmpty()){
            TreeNode leftNode = leftQueue.poll();
            TreeNode rightNode =rightQueue.poll();
            if(leftNode.val!= rightNode.val){
                return false;
            }
            if(leftNode.left==null && rightNode.left!=null){
                return false;
            }
            if(leftNode.left!=null && rightNode.left==null){
                return false;
            }
            if(leftNode.left!=null && rightNode.left!=null){
                leftQueue.add(leftNode.left);
                rightQueue.add(rightNode.left);
            }

            if(leftNode.right==null && rightNode.right!=null){
                return false;
            }
            if(leftNode.right!=null && rightNode.right==null){
                return false;
            }
            if(leftNode.right!=null && rightNode.right!=null){
                leftQueue.add(leftNode.right);
                rightQueue.add(rightNode.right);
            }
        }
        if(leftQueue.isEmpty() && rightQueue.isEmpty()){
            return true;
        }
        return false;

    }

}
