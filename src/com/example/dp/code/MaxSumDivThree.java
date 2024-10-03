package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class MaxSumDivThree {
    public static  int max ;
    public static void main(String[] args) {
        System.out.println(maxSumDivThree(new int[]{
                1,2,3,4,4
        }));

        System.out.println(maxSumDivThree(new int[]{
                3,6,5,1,8
        }));
        System.out.println(maxSumDivThree(new int[]{
                3,6,5
        }));
        System.out.println(maxSumDivThree(new int[]{
                3,6,5,1,7
        }));
        System.out.println(maxSumDivThree(new int[]{
                8
        }));
        System.out.println(maxSumDivThree(new int[]{
                3,6,9,15
        }));
    }
    public static int maxSumDivThree(int[] nums) {
        max =0;
//        max = helper(nums,0,3,0);
        return helper(nums,0,3,0);

    }

    private static int helper(int[] nums, int index, int n,int currSum) {
        if(index== nums.length){
            return 0;
        }
        int ans =0;
        if((currSum + helper(nums, index+1, n, currSum%n))%n==0){
            ans = helper(nums, index+1, n, currSum%n);
        }
        if((nums[index]+currSum + helper(nums, index+1, n, (nums[index]+currSum)%n))%n==0){
            ans = Math.max(ans,nums[index]+helper(nums, index+1, n, (nums[index]+currSum)%n));
        }
        return ans;
    }
}
