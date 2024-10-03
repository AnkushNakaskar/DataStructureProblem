package com.example.binarysearchtree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ankush.nakaskar
 */
public class ModeOFBST {
    public static Map<Integer,Integer> map ;
    public static void main(String[] args) {


    }
    public static int[] findMode(TreeNode root) {
        map =new HashMap<>();
        if(root==null){
            return new int[]{};
        }
        inOrder(root);
        PriorityQueue<Map.Entry<Integer,Integer>> queue =new PriorityQueue<>((a,b) ->{
            return b.getValue()-a.getValue();
        });
        map.entrySet().stream().forEach(set ->{
            queue.add(set);
        });
        int count =1;
        List<Integer> resList =new ArrayList<>();
        Map.Entry<Integer, Integer> first = queue.poll();
        resList.add(first.getKey());
        while(!queue.isEmpty()){
            Map.Entry<Integer, Integer> curr = queue.poll();
            if(curr.getValue()<first.getValue()){
                break;
            }else{
                resList.add(curr.getKey());
                count++;
            }
        }
        int[] res = new int[count];
        for(int i =0;i< res.length;i++){
            res[i]=resList.get(i);
        }
        return res;
    }

    private static void inOrder(TreeNode root) {
        if(root!=null){
            inOrder(root.left);
            map.put(root.val, map.getOrDefault(root.val,0)+1);
            inOrder(root.right);
        }
    }
}
