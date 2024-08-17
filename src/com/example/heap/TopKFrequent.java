package com.example.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums =new int[]{1,1,1,2,2,3};

    }

    public static int[] topKFrequent(int[] nums, int k) {
        if(nums==null || nums.length<=k){
            return nums;
        }
        Map<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue =new PriorityQueue<>((a,b) ->{
            return b.getValue().compareTo(a.getValue());
        });
        map.entrySet().forEach(set ->{
            queue.add(set);
        });
        int[] res =new int[k];
        for(int i=0;i<k && !queue.isEmpty();i++){
            Map.Entry<Integer, Integer> value = queue.poll();
            res[i] = value.getKey();
        }
        return res;
    }
}
