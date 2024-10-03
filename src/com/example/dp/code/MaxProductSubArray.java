package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class MaxProductSubArray {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{
                2,3,-2,4
        }));
        System.out.println(maxProduct(new int[]{
                -2,0,-1
        }));
    }
    public static int maxProduct(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[][] dp =new int[nums.length][nums.length];
        int max = Integer.MIN_VALUE;
        for(int i=0;i< nums.length;i++){
            for(int j=i;j< nums.length;j++){
                if(i==j){
                    dp[i][j] = nums[i];
                }else if(i==0){
                    dp[i][j] = nums[j] * dp[i][j-1];
                } else {
                    dp[i][j] = nums[j] * dp[i][j-1];
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
