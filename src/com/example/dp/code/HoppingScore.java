package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class HoppingScore {

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1,5,8}));
        System.out.println(maxScore(new int[]{4,5,2,8,9,1,3}));
    }
    public static int maxScore(int[] nums) {

        int max =0;
        int[] dp =new int[nums.length];
        dp[0]=0;
        for(int i=1;i< nums.length;i++){
            for(int j=i;j>=0;j--){
                dp[i] = Math.max(dp[i],dp[j]+(i-j)*nums[i]);
            }
        }
        return dp[nums.length-1];
    }
}
