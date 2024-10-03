package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class NumberOfArithmeticSlices {

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4}));
        System.out.println(numberOfArithmeticSlices(new int[]{1,3,5,7,9}));
        System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,8,9,10}));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length<3){
            return 0;
        }
//        1,3,5,7,9
        int[] dp =new int[nums.length];
        for(int i=1;i<nums.length;i++){
            int prev = nums[i-1];
            for(int j=i+1;j<nums.length;j++){
                int curr = nums[j-1];
                int next = nums[j];
                if(curr-prev == next-curr){
                    dp[j] = 1+dp[j];
                }else{
                    break;
                }
                prev = curr;
            }
        }
        int sum =0;
        for(int val : dp){
            sum+=val;
        }
        return sum;

    }
}
