package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class MaximumLengthOfSubArray {

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1,2,3,2,1},new int[]{3,2,1,4,7}));
        System.out.println(findLength(new int[]{0,0,0,0,0},new int[]{0,0,0,0,0}));
        System.out.println(findLength(new int[]{0,1,1,1,1},new int[]{1,0,1,0,1}));
    }

    public static int findLength(int[] nums1, int[] nums2) {

        int[][] dp =new int[nums1.length+1][nums2.length+1];
//        for(int i=0;i< nums1.length;i++){
//            for(int j=0;j< nums2.length;j++){
//                if(i==0){
//                    if(nums1[i]==nums2[j]){
//                        dp[i][j]=1;
//                    }
//                }else if(j==0){
//                    if(nums1[i]==nums2[j]){
//                        dp[i][j]=1;
//                    }
//                }
//            }
//        }
        int res = Integer.MIN_VALUE;
        for(int i=1;i< nums1.length+1;i++) {
            for (int j = 1; j < nums2.length+1; j++) {
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                    res = Math.max(res,dp[i][j]);
                }
            }
        }

        return res;
    }
}
