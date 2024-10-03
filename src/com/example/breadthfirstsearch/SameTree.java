package com.example.breadthfirstsearch;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author ankush.nakaskar
 */
public class SameTree {
    public static void main(String[] args) {

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null && q!=null){
            return false;
        }
        if(p!=null && q==null){
            return false;
        }
        Queue<TreeNode> queueP =new ArrayDeque<>();
        queueP.add(p);
        Queue<TreeNode> queueQ =new ArrayDeque<>();
        queueQ.add(q);
        while(!queueQ.isEmpty() && !queueP.isEmpty()){
            TreeNode nodeP = queueP.poll();
            TreeNode nodeQ = queueQ.poll();
            if(nodeP.val!= nodeQ.val){
                return false;
            }

            if(nodeP.left!=null && nodeQ.left!=null) {
                if(nodeP.left.val != nodeQ.left.val){
                    return false;
                }
                queueP.add(nodeP.left);
                queueQ.add(nodeQ.left);
            }else if(nodeP.left!=null || nodeQ.left!=null){
                return false;
            }
            if(nodeP.right!=null && nodeQ.right!=null) {
                if(nodeP.right.val!= nodeQ.right.val){
                    return false;
                }
                queueP.add(nodeP.right);
                queueQ.add(nodeQ.right);
            }else if(nodeP.right!=null || nodeQ.right!=null){
                return false;
            }
        }

        if(queueP.isEmpty() && queueQ.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
