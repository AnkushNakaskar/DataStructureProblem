package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class MaxSumAfterPartitioning {

    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{
                1,15,7,9,2,5,10
        },3));
    }

    public static int maxSumAfterPartitioning(int[] nums, int k) {
        int res =0;
        res = helper(nums,0,k);
        return res;
    }

    private static int helper(int[] nums, int index, int k) {
        if(index== nums.length){
            return 0;
        }
        int max = 0;
        int maxSum =0;
        for(int i=index;i<index+k && i< nums.length;i++){
            max = Math.max(max,nums[i]);
            maxSum = Math.max(maxSum,helper(nums, i+1,k)+(i-index+1)*max);
        }
        return maxSum;
    }

}
