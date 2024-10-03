package com.example.binarysearchtree;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class KthLargest {
    PriorityQueue<Integer> queue;
    int k;
    public KthLargest(int k, int[] nums) {
        queue =new PriorityQueue<>((a,b) ->{
            return b.compareTo(a);
        });
        this.k=k;
        for(int i=0;i< nums.length;i++){
            queue.add(nums[i]);
            if(queue.size()>k) queue.poll();
        }
    }

    public int add(int val) {
        queue.add(val);
        List<Integer> list =new ArrayList<>();
        for(int i=0;i<k-1 && !queue.isEmpty();i++){
            list.add(queue.poll());
        }
        if(!queue.isEmpty()){
            int res = queue.peek();
            queue.addAll(list);
            return res;
        }
        return -1;
    }

}
