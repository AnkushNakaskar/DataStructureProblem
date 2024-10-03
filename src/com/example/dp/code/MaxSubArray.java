package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{
                -2,1,-3,4,-1,2,1,-5,4
        }));
    }

    public static int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int max =Integer.MIN_VALUE+1000;
        int[][]dp =new int[nums.length][nums.length];
        for(int i=0;i< nums.length;i++){
            for(int j=i;j< nums.length;j++){
                if(i==j){
                    dp[i][j]=nums[i];
                    max = Math.max(max,dp[i][j]);
                }else {
                    dp[i][j] = dp[i][j-1]+nums[j];
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }
}
