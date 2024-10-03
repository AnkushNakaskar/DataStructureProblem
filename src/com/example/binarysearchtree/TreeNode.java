package com.example.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankush.nakaskar
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
/*
                12
              /     \
             5        18
           /   \      / \
          2     9    14   19
 */
    public static TreeNode getSampleTree(){
        TreeNode node =new TreeNode(12);
        node.left =new TreeNode(5);
        node.left.left =new TreeNode(2);
        node.left.right =new TreeNode(9);
        node.right =new TreeNode(18);
        node.right.left =new TreeNode(14);
        node.right.right =new TreeNode(19);
        return node;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        if(root!=null){
            return inOrder(root,res);
        }
        return res;
    }

    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        if(root!=null){
            return preOrder(root,res);
        }
        return res;
    }

    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        if(root!=null){
            return postOrder(root,res);
        }
        return res;
    }

    private static List<Integer> inOrder(TreeNode root, List<Integer> res) {
        if(root!=null){
            inOrder(root.left,res);
            res.add(root.val);
            inOrder(root.right, res);
        }
        return res;
    }

    private static List<Integer> preOrder(TreeNode root, List<Integer> res) {
        if(root!=null){
            res.add(root.val);
            preOrder(root.left,res);
            preOrder(root.right, res);
        }
        return res;
    }

    private static List<Integer> postOrder(TreeNode root, List<Integer> res) {
        if(root!=null){
            postOrder(root.left,res);
            postOrder(root.right, res);
            res.add(root.val);
        }
        return res;
    }
}
