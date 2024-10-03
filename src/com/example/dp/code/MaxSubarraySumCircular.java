package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class MaxSubarraySumCircular {

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{
                1,-2,3,-2
        }));
        System.out.println(maxSubarraySumCircular(new int[]{
                5,-3,5
        }));
        System.out.println(maxSubarraySumCircular(new int[]{
                -3,-2,-3
        }));
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int[] newNums = new int[nums.length*2];
        for(int i=0;i<newNums.length;i++){
            newNums[i]= nums[i% nums.length];
        }
        int[][] dp = new int[newNums.length][newNums.length];
        for(int i=0;i< newNums.length;i++){
            for(int j=0;j<newNums.length;j++){
                if(i==j){
                    dp[i][j] = newNums[i];
                }
            }
        }
        int i=0;
        int j=i+1;
        int prevIndex =j;
        while(i< newNums.length && j< newNums.length && prevIndex< newNums.length){

            if(i!=j){
                dp[i][j] = dp[i+1][j] + dp[i][j-1]-dp[i+1][j-1];
            }
            i++;
            j++;

            if(j== newNums.length){
                j=prevIndex+1;
                i=0;
                prevIndex=j;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int m=0;m< dp.length;m++){
            int length = nums.length;
            for(int n =m;n<dp[m].length && length>0;n++){
                int val = dp[m][n];
                max = Math.max(max,val);
                length--;
            }

        }
        return max;
    }
}
