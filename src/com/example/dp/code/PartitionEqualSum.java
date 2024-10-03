package com.example.dp.code;

import java.util.Arrays;

/**
 * @author ankush.nakaskar
 */
public class PartitionEqualSum {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{
                1,5,11,5
        }));

        System.out.println(canPartition(new int[]{
                1,2,3,5
        }));
        System.out.println(canPartition(new int[]{
                2,2,1,1
        }));
    }
    public static boolean canPartition(int[] nums) {
        if(nums==null || nums.length==0){
            return false;
        }
        if(nums.length==1){
            return false;
        }
        int sum = 0;
        for(int val : nums){
            sum+=val;
        }
        if(sum%2!=0){
            return false;
        }
        Arrays.sort(nums);

        boolean isEqualSum = help(nums,sum/2,0);
        return isEqualSum;
    }
    //        1,1,2,2
    private static boolean help(int[] nums, int amount, int index) {
        if(amount==0){
            return true;
        }
        if(amount>0){
            for(int i=index;i< nums.length;i++){
                if(nums[i]<=amount){
                    return help(nums, amount-nums[i], i+1) || help(nums, amount, i+1);
                }else{
                    return help(nums, amount, i+1);
                }
            }
        }
        return false;
    }
}
