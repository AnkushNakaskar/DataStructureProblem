package com.example.breadthfirstsearch;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.right=new TreeNode(3);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(9);
        System.out.println(levelOrderBottom(root));
    }

    public static Node connect(Node root) {
        if(root==null){
            return null;
        }
        if(root.left==null && root.right==null){
            return root;
        }
        Queue<Node> queue =new ArrayDeque<>();

        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node node = queue.poll();
                if(i<size-1){
                    node.next=queue.peek();
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> res =new ArrayList<>();
        Stack<List<Integer>> stack =new Stack<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list =new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            stack.push(list);
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;

    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queueOne = new ArrayDeque<>();
        Queue<TreeNode> queueTwo = new ArrayDeque<>();
        queueOne.add(root);
        List<List<Integer>> res =new ArrayList<>();
        while(!queueOne.isEmpty() || !queueTwo.isEmpty()){
            List<Integer> list =new ArrayList<>();
            while(!queueOne.isEmpty()){
                TreeNode node = queueOne.poll();
                list.add(node.val);
                if(node.right!=null){
                    queueTwo.add(node.right);
                }
                if(node.left!=null){
                    queueTwo.add(node.left);
                }
            }
            if(!list.isEmpty()){
                res.add(list);
            }
            list =new ArrayList<>();
            while(!queueTwo.isEmpty()){
                TreeNode node = queueOne.poll();
                list.add(node.val);
                if(node.left!=null){
                    queueOne.add(node.left);
                }
                if(node.right!=null){
                    queueOne.add(node.right);
                }
            }
            if(!list.isEmpty()){
                res.add(list);
            }
        }
        return res;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> res =new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list =new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;

    }

    public static int sumOfLeftLeaves(TreeNode root) {
        int res =0;

        Queue<TreeNode> queue =new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null && node.left.left==null && node.left.right==null){
                    res+=node.left.val;
                }

                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }

        return res;

    }
}
