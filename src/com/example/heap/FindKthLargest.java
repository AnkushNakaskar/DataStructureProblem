package com.example.heap;

import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums =new int[]{3,2,1,5,6,4};

    }

    public static int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length<k){
            return 0;
        }
        if(nums.length==k){
            return nums[nums.length-1];
        }
        PriorityQueue<Integer> queue =new PriorityQueue<>((a,b) ->{
            return b.compareTo(a);
        });
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
        }
        int res =-1;
        for(int i=0;i<k;i++){
            res = queue.poll();
        }
        return res;
    }
}
