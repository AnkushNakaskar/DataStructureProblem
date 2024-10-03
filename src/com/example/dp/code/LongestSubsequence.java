package com.example.dp.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ankush.nakaskar
 */
public class LongestSubsequence {

    public static void main(String[] args) {
        System.out.println(longestSubsequence(new int[]{
                1,2,3,4
        },1));
        System.out.println(longestSubsequence(new int[]{
                3,6,9,12
        },3));
        System.out.println(longestSubsequence(new int[]{
                1,5,7,8,5,3,4,2,1
        },-2));
    }
    public static int longestSubsequence(int[] nums, int diff) {
        int res =0;
        Map<Integer,Integer> map =new HashMap<>();
        for(int val : nums){
            map.put(val,map.getOrDefault(val-diff,0)+1);
            res = Math.max(res,map.get(val));
        }
        return res;
    }
    public static int longestSubsequenceOld(int[] nums, int diff) {
//        Arrays.sort(nums);

        int[][] dp =new int[nums.length][Math.abs(diff)+1];
        int max =1;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j< nums.length;j++){
                int diffVal = nums[j]-nums[i];
                if(diffVal!=diff)continue;
                else{
                    diffVal = Math.abs(diffVal);
                    dp[j][diffVal] = Math.max(2,dp[i][diffVal]+1);
                    max = Math.max(max,dp[j][diffVal]);
                }

            }
        }
        return max;
    }
}
