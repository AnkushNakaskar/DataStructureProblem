package com.example.greedy;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ankush.nakaskar
 */
public class ShortestContinuosSubArray {
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{
                2,6,4,8,10,9,15
        }));
        System.out.println(findUnsortedSubarray(new int[]{
                1,2,3,4
        }));
        System.out.println(findUnsortedSubarray(new int[]{
                1
        }));
    }
    public static int findUnsortedSubarray(int[] nums) {
        int[] arr = Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        int leftIndex =0;
        int rightIndex =0;
        int count=0;
        for(int i =0;i< nums.length;i++){
            if(nums[i]!=arr[i]){
                leftIndex=i;
                break;
            }
        }
        for(int i= nums.length-1;i>=0;i--){
            if(nums[i]!=arr[i]){
                rightIndex=i;
                break;
            }
        }
        if(leftIndex==rightIndex){
            return 0;
        }
        return Math.abs(rightIndex-leftIndex+1);
    }
}
