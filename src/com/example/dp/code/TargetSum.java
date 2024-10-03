package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class TargetSum {
    public static int max ;

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{
                1,1,1,1,1
        },3));
        System.out.println(findTargetSumWays(new int[]{
                0,0,0,0,0,0,0,0,1
        },1));
    }
    public static int findTargetSumWays(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return 0;
        }
        max = 0;
        help(nums,0,target,0);
        return max;
    }

    private static void help(int[] nums, int index, int target, int currSum) {

        if(currSum==target && index>= nums.length){
            max = max+1;
        }
        if(index<nums.length){
            help(nums, index+1, target, currSum+nums[index]);
            help(nums, index+1, target, currSum-nums[index]);
        }
    }
}
