package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class AlternatingSubArraySum {

    public static void main(String[] args) {
        System.out.println(maximumAlternatingSubarraySum(new int[]{
                3,-1,1,2
        }));
        System.out.println(maximumAlternatingSubarraySum(new int[]{
                2,2,2,2,2
        }));
        System.out.println(maximumAlternatingSubarraySum(new int[]{
                -1
        }));
        System.out.println(maximumAlternatingSubarraySum(new int[]{
                5,100
        }));
    }

    public static long maximumAlternatingSubarraySum(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int max =Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]+ help(nums,i+1,false));
        }
        return max;

    }

    private static int help(int[] nums, int index,boolean isAdd) {
       if(index== nums.length)return 0;
       int res =0;
       int sum = (isAdd?1:-1)* nums[index]+help(nums, index+1, !isAdd);
       res = Math.max(res,sum);
       return res;

    }

    public static long maximumAlternatingSubarraySumOld(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int maxSum =Integer.MIN_VALUE;
        for(int i=0;i< nums.length;i++){
            int currSum= 0;
            int multiple=  i%2==0? 1:-1;
            for(int j=i;j>=0;j--){
                currSum = currSum + multiple * nums[j];
                multiple = -1 * multiple;
                maxSum = Math.max(currSum,maxSum);
            }
            maxSum = Math.max(currSum,maxSum);
        }
        return maxSum;
    }
}
