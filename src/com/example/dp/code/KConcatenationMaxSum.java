package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class KConcatenationMaxSum {

    public static void main(String[] args) {
        System.out.println(kConcatenationMaxSum(new int[]{1,2},3));
    }

    public static int kConcatenationMaxSum(int[] arr, int k) {
        int[] nums =new int[arr.length*k];
        int max =Integer.MIN_VALUE+1000;
        for(int i=0;i< nums.length;i++){
            int index = i% (arr.length);
            nums[i]= arr[index];
            max = Math.max(max,nums[i]);
        }
        int[][] dp =new int[nums.length][nums.length];
        for(int i=0;i< nums.length;i++){
            dp[i][i]=nums[i];
        }
        int i=0;
        int prev =i+1;
        int j=prev;
        while(i< nums.length && j< nums.length){
            if(i==j){
                i++;
                j++;
                continue;
            }else {
                dp[i][j] = dp[i][j-1]+dp[i+1][j]- dp[i+1][j-1];
                max=Math.max(max,dp[i][j]);
                i++;
                j++;
            }
            if(j== nums.length){
                j=prev+1;
                prev=prev+1;
                i=0;
            }
            if(prev== nums.length){
                break;
            }

        }
        return Math.max(0,max);
    }
}
