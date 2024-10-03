package com.example.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class BrokenCalc {

    public static void main(String[] args) {
        System.out.println(brokenCalc(2,3));
        System.out.println(brokenCalc(5,8));
        System.out.println(brokenCalc(3,10));
    }
    public static int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> queue =new PriorityQueue<>();
        for(int val : nums){
            queue.add(val);
        }
        while(k>0 && !queue.isEmpty()){
            int curr = queue.poll();
            curr = -1*curr;
            queue.add(curr);
            k--;
        }
        int sum = 0;
        while(!queue.isEmpty()){
            sum+=queue.poll();
        }
        return sum;

    }
    public static int brokenCalc(int startValue, int target) {
        int res =0;
        res = helper(0,startValue,target);
        return res;
    }

    private static int helper(int count, int currTarget, int target) {
        if(currTarget==target){
            return count;
        }
        if(count>=0 && count<2*target && currTarget>0 && currTarget<= (2*target)){
            return Math.min(helper(count+1, currTarget-1, target),helper(count+1, currTarget*2, target));
        }
        return Integer.MAX_VALUE;
    }
}
