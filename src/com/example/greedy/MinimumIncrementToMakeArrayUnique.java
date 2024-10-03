package com.example.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class MinimumIncrementToMakeArrayUnique {

    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{
                3,2,1,2,1,7
        }));
        System.out.println(minIncrementForUnique(new int[]{
                1,2,2
        }));
    }
    public static int minIncrementForUnique(int[] nums) {
        int count=0;
        Arrays.sort(nums);
        int prev = nums[0];
        for(int i=1;i<nums.length;i++){
            int curr = nums[i];
            while(prev>=curr){
                count++;
                curr++;
            }
            prev =curr;
        }
        return count;
    }
}
