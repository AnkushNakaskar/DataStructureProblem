package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class SightSeeing {
    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[]{
                8,1,5,2,6
        }));
        System.out.println(maxScoreSightseeingPair(new int[]{
                1,2
        }));
    }
    public static  int maxScoreSightseeingPair(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int[] dp =new int[nums.length];
        dp[nums.length-1]=nums[nums.length-1]- nums.length-1;
        int max = nums[nums.length-1]- nums.length-1;
        for(int i= nums.length-1;i>=0;i--){
            max = Math.max(max,nums[i]-i);
            dp[i]=max;
        }
        int res = 0;
        for(int i=0;i< nums.length-1;i++){
            int curr = nums[i]+i+dp[i+1];
            res = Math.max(res,curr);
        }
        return res;
    }
}
