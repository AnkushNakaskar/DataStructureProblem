package com.example.binarysearchtree;

import java.util.Stack;

/**
 * @author ankush.nakaskar
 */
public class InorderSuccessor {
    public static Stack<TreeNode> stack =new Stack<>();

    public static void main(String[] args) {
        TreeNode node =new TreeNode(2);
        node.left =new TreeNode(1);
        node.right =new TreeNode(3);
        TreeNode succ = inorderSuccessor(node,new TreeNode(1));
        System.out.println(succ);
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        stack =new Stack<>();
        inorderCheck(root,p);
        if(!stack.isEmpty()){
            TreeNode top = stack.pop();
            if(top.val!=p.val)return top;
            return null;
        }
        return null;
    }

    private static void inorderCheck(TreeNode node, TreeNode p) {
        if(node!=null){
            inorderCheck(node.left,p);
            if(stack.size()<=1 && node.val>=p.val){
                stack.push(node);
            }
            inorderCheck(node.right,p);
        }
    }
}
