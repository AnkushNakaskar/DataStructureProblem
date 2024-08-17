package com.example.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class FindRelativeRanks {
    public static void main(String[] args) {
     int[] nums =new int[]{10,3,8,9,4};
        String[] res = findRelativeRanks(nums);
        for(int i=0;i<res.length;i++){
            System.out.print(" "+res[i]);
        }
    }
    public static String[] findRelativeRanks(int[] nums) {
        if(nums ==null || nums.length<=0){
            return new String[]{};
        }
        String[] res =new String[nums.length];
        String gold ="Gold Medal";
        String silver ="Silver Medal";
        String bronze ="Bronze Medal";
        PriorityQueue<Integer> queue =new PriorityQueue<>((a,b) -> {
            return b.compareTo(a);
        });
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
        }
        Map<Integer,String> map =new HashMap<>();
        if(!queue.isEmpty()){

            map.put(queue.poll(),gold);
        }
        if(!queue.isEmpty()){
            map.put(queue.poll(),silver);
        }
        if(!queue.isEmpty()){
            map.put(queue.poll(),bronze);
        }
        int count =4;
        while(!queue.isEmpty()){
            map.put(queue.poll(),""+count);
            count++;
        }
        for(int i=0;i<nums.length ;i++){
            res[i]=map.get(nums[i]);
        }
        return res;
    }
}
