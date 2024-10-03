package com.example.greedy;

/**
 * @author ankush.nakaskar
 */
public class MaximusArrayHoppingScore2 {

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1,5,8}));
        System.out.println(maxScore(new int[]{4,5,2,8,9,1,3}));
    }
    public static long maxScore(int[] nums) {

        int ans =0;
        int i= nums.length-1;
        int j= i;
        //Need to check for larger value from last and check the difference ,
//        Basically the equation says when num[j] is maximum then that value is addable
        while(i>0){
            while(j>0 && nums[i]>nums[j]) {
                j--;
            }
            ans = ans+ ((i-j) *nums[i]);
            i=j;
            j=i-1;
        }
        return ans;
    }
    public static long maxScoreOld(int[] nums) {

        int[] dp =new int[nums.length];
        for(int i=1;i< nums.length;i++){
//            dp[i]=nums[i];
            for(int j=i-1;j>=0;j--){
                int val = (i-j)*nums[i];
                dp[i]=Math.max(dp[i],dp[j]+val);
            }
        }
        return dp[nums.length-1];

    }
}
