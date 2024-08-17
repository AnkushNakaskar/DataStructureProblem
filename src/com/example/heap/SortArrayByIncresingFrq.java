package com.example.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class SortArrayByIncresingFrq {

    public static void main(String[] args) {
        int[] nums =new int[]{-1,1,-6,4,5,-6,1,4,1};
        int[] res =frequencySort(nums);
        for(int i=0;i<res.length;i++){
            System.out.print(" "+res[i]);
        }
        // -1 5 -6 -6 4 4 1 1 1
    }
    public static int[] frequencySort(int[] nums) {
        if(nums==null || nums.length<=1){
            return nums;
        }
        Map<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue =new PriorityQueue<>((a,b)->{
            if(a.getValue().equals(b.getValue())){
                return b.getKey().compareTo(a.getKey());
            }
            return a.getValue().compareTo(b.getValue());
        });
        map.entrySet().forEach(set ->{
            queue.add(set);
        });
        int[] res =new int[nums.length];
        int index=0;
        while (!queue.isEmpty()){
            Map.Entry<Integer, Integer> value = queue.poll();
            for(int i=0;i<value.getValue();i++){
                res[index]= value.getKey();
                index++;
            }
        }
        return res;
    }
}
