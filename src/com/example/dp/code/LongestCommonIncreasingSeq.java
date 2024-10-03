package com.example.dp.code;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class LongestCommonIncreasingSeq {

    public static Map<Integer,Integer> maximusVals;
    public static void main(String[] args) {
//        System.out.println(lengthOfLIS(new int[]{
//                10,9,2,5,3,4
//        }));
//        System.out.println(lengthOfLIS(new int[]{
//                2,5,7,101
//        }));
        System.out.println(lengthOfLIS(new int[]{
                10,9,2,5,3,7,101,18
        }));
        System.out.println(lengthOfLIS(new int[]{
                0,1,0,3,2,3
        }));
//
        System.out.println(lengthOfLIS(new int[]{
                7,7,7,7,7,7,7
        }));
        System.out.println(lengthOfLIS(new int[]{
                4,10,4,3,8,9
        }));
    }
    public static int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int[] dp =new int[nums.length];
        //                10,9,2,5,3,7,101,18
        Arrays.fill(dp,1);

        for(int i=nums.length-1;i>=0;i--){
            for(int j=i;j< nums.length;j++){
                if(nums[i]<nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }


        int max =Integer.MIN_VALUE;
        for(int val : dp){
            max =Math.max(max,val);
        }
        return max;
    }

    private static int helpPre(int[] nums) {
        int maxValue =0;
        for(int i= nums.length-1;i>=0;i--){
            int max =help(nums,i);
            maximusVals.put(i,max);
            maxValue = Math.max(maxValue,max);
        }
        return maxValue;
    }

    private static int help(int[] nums, int index) {
        int max =1;
        int curr =nums[index];
        for(int i=index+1;i< nums.length;i++){
            if(curr<nums[i] || nums[i]==0){
                if(maximusVals.containsKey(i)){
                    max =1+ maximusVals.get(i);
                    break;
                }else{
                    max++;
                    curr=nums[i];
                }

            }
        }
        return max;
    }
}
