package com.example.breadthfirstsearch;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class BinaryTreeVerticleOrder {

    public static void main(String[] args) {
        System.out.println(verticalOrder(TreeNode.createBinaryTree()));
    }

    static class TreeNodeTest{
        TreeNode treeNode;
        Integer ref;
    }
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer,List<Integer>> map =new HashMap<>();
        int val=0;
        if(root==null){
            return new ArrayList<>();
        }
        TreeNodeTest  node = new TreeNodeTest();
        node.treeNode = root;
        node.ref=0;
        Queue<TreeNodeTest> queue =new ArrayDeque<>();
        queue.add(node);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            TreeNodeTest treeNodeTest = queue.poll();
            if(!map.containsKey(treeNodeTest.ref)){
                map.put(treeNodeTest.ref, new ArrayList<>());
            }
            min = Math.min(min, treeNodeTest.ref);
            max = Math.max(max, treeNodeTest.ref);
            map.get(treeNodeTest.ref).add(treeNodeTest.treeNode.val);
            if(treeNodeTest.treeNode.left!=null){
                TreeNodeTest test = new TreeNodeTest();
                test.treeNode=treeNodeTest.treeNode.left;
                test.ref = treeNodeTest.ref-1;
                queue.add(test);
            }
            if(treeNodeTest.treeNode.right!=null){
                TreeNodeTest test = new TreeNodeTest();
                test.treeNode=treeNodeTest.treeNode.right;
                test.ref = treeNodeTest.ref+1;
                queue.add(test);
            }
        }
        List<List<Integer>> lists =new ArrayList<>();
        for(int i=min;i<=max;i++){
            lists.add(map.get(i));
        }
        return lists;
    }
}
