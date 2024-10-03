package com.example.breadthfirstsearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author ankush.nakaskar
 */


public class BinaryRightSideView {

    public static void main(String[] args) {
        System.out.println(rightSideView(TreeNode.createBinaryTree()));

    }

    public static List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue =new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            res.add(queue.peek().val);
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.right!=null){
                    queue.add(node.right);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
            }
        }
        return res;
    }

}
