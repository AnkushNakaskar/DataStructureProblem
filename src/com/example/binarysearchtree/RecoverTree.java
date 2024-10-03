package com.example.binarysearchtree;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ankush.nakaskar
 */
public class RecoverTree {
    public static void main(String[] args) {
//        TreeNode node =new TreeNode(3);
//        node.left =new TreeNode(1);
//        node.right =new TreeNode(4);
//        node.right.left =new TreeNode(2);

//        5,3,9,-2147483648,2
        TreeNode node =new TreeNode(5);
        node.left =new TreeNode(3);
        node.right =new TreeNode(9);
        node.left.left =new TreeNode(-2147483648);
        node.left.right =new TreeNode(2);
//        System.out.println(TreeNode.inorderTraversal(node));
        recoverTree(node);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
    public static void recoverTree(TreeNode node) {
        if(node==null){
            return;
        }
        List<Integer> sortInorderTraversal = TreeNode.inorderTraversal(node);
        Collections.sort(sortInorderTraversal);
        List<Integer> inorderTraversal  = TreeNode.inorderTraversal(node);
        System.out.println(sortInorderTraversal);
        System.out.println(inorderTraversal);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<sortInorderTraversal.size();i++){
            Integer sortCurr = sortInorderTraversal.get(i);
            Integer nonSortCurr = inorderTraversal.get(i);
//            if(sortCurr==Integer.MIN_VALUE && nonSortCurr.equals(Integer.MIN_VALUE))
            if(!sortCurr.equals(nonSortCurr)){
                map.put(sortCurr,nonSortCurr);
                map.put(nonSortCurr,sortCurr);
                break;
            }
        }
        inOrderTraversalCorrection(node,map);
        System.out.println(TreeNode.inorderTraversal(node));

    }

    private static void inOrderTraversalCorrection(TreeNode node, Map<Integer, Integer> map) {
        if(node!=null){
            inOrderTraversalCorrection(node.left,map);
            if(map.containsKey(node.val)){
                node.val=map.get(node.val);
//                map.remove(node.val);
            }
            inOrderTraversalCorrection(node.right,map);
        }
    }
}
