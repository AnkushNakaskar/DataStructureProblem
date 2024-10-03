package com.example.dp.book.dpbook;

/**
 * @author ankush.nakaskar
 */
public class CuttingRod {

    public static void main(String[] args) {
        System.out.println(cutRod(new int[]{1,5,8,9},3));
    }

    private static int cutRod(int[] nums, int n) {
        if(nums.length==0){
            return 0;
        }

        return helper(nums,n);
    }

    private static int helper(int[] nums, int n) {
        if(n<=0){
            return 0;
        }
        int max =0;
        for(int i=1;i<n ;i++){
            max =Math.max(max ,nums[i]+helper(nums, n-i));
        }
        return max;
    }
}
