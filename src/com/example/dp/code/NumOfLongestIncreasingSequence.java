package com.example.dp.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ankush.nakaskar
 */
public class NumOfLongestIncreasingSequence {

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{
                1,3,5,4,7
        }));
    }
    public static int findNumberOfLIS(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int[] dp =new int[nums.length];
        int[] count =new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }

                    // If another subsequence of the
                    // same length is found, add to the count
                    else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }

                }
            }
        }
        int max = Integer.MIN_VALUE;
        Map<Integer,Integer> map =new HashMap<>();

        for(int val : dp){
            max = Math.max(max,val);
        }
        int result =0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == max) {
                result += count[i];
            }
        }
        return result;
    }
}
