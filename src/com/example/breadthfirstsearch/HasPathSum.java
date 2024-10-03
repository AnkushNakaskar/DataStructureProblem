package com.example.breadthfirstsearch;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author ankush.nakaskar
 */
public class HasPathSum {

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if(root==null){
            return false;
        }
        Queue<TreeNode> queue =new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.val==targetSum && node.left==null && node.right==null){
                    return true;
                }
                if(node.left!=null){
                    node.left.val +=node.val;
                    queue.add(node.left);
                }
                if(node.right!=null){
                    node.right.val+=node.val;
                    queue.add(node.right);
                }
            }
        }
        return false;
    }
}
