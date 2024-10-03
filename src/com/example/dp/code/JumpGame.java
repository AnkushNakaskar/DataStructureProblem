package com.example.dp.code;

import java.util.Arrays;

/**
 * @author ankush.nakaskar
 */
public class JumpGame {
    public static void main(String[] args) {
        System.out.println(jumpDP(new int[]{2,3,1,1,4}));
        System.out.println(jumpDP(new int[]{2, 3, 0, 1, 4}));
    }

    public static int bruteForceJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] == 0) {
            return -1;
        }

        return canJumHelp(nums, 0);

    }

    //2,3,1,1,4
    private static int canJumHelp(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= nums[index]; j++) {
            min = Math.min(min, 1 + canJumHelp(nums, index + j));
        }

        return min;
    }


    //2,3,0,1,4
    public static int jumpDP(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE-100);
        int n =nums.length;
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            for(int jumpVal=nums[i];jumpVal>0;jumpVal--){
                int lastVal = dp[Math.min(n-1,i+jumpVal)];
                dp[i]=Math.min(dp[i],1+lastVal);
            }
        }
        return dp[0];
    }

    public static int jump(int[] nums) {
        int pos = 0;
        int des = 0;
        int jumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            des = Math.max(des, i + nums[i]);
            if (pos == i) {
                pos = des;
                jumps++;
            }
        }
        return jumps;
    }

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return false;
        }
        if (nums.length > 1 && nums[0] == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        boolean dp[] = new boolean[nums.length];
        dp[0] = true;
        int pos = nums.length;
        for (int i = nums.length - 1; i > 0; i--) {
            int max = nums[i - 1] + i;
            if (max >= pos) {
                pos = i;
            }
        }
        return pos == 1;
    }
}
