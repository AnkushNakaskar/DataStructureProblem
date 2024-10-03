package com.example.dp.code;

import java.util.HashMap;

/**
 * @author ankush.nakaskar
 */
public class StoneGame {

    public static HashMap<String,Boolean> result;
    public static void main(String[] args) {
        System.out.println(stoneGame(new int[]{
                5,3,4,5
        }));
        System.out.println(stoneGame(new int[]{
                1,1,3,3
        }));
    }
    public static boolean stoneGame(int[] nums) {
        if(nums==null || nums.length==0){
            return true;
        }

        if(nums.length==1){
            return true;
        }
        result =new HashMap<>();
        return helper(nums,0,nums.length-1,true,0,0);
    }

    private static boolean helper(int[] nums, int left, int right,boolean isAliceTurn,int aliceSum, int bobSum) {
        if(left<=right){
            if(result.containsKey(""+left+right+isAliceTurn)){
                return result.get(""+left+right+isAliceTurn);
            }
            if(isAliceTurn){
                boolean resultTmp =helper(nums, left+1, right, false, aliceSum+nums[left], bobSum) || helper(nums, left, right-1, false, aliceSum+nums[right], bobSum);
                result.put(""+left+right+isAliceTurn,resultTmp);
                return result.get(""+left+right+isAliceTurn);
            }else{
                boolean resultTmp =helper(nums, left+1, right, true, aliceSum, bobSum+nums[left]) || helper(nums, left, right-1, true, aliceSum, bobSum+nums[right]);
                result.put(""+left+right+isAliceTurn,resultTmp);
                return result.get(""+left+right+isAliceTurn);
            }
        }else{
            return aliceSum>bobSum;
        }
    }
    private static int helper(int[] nums, int left, int right,boolean isAliceTurn) {
        int aliceSum =0;
        int bobSum =0;
        if(left<=right){
            if(isAliceTurn){
                int leftSum = nums[left] + helper(nums, left+1, right,false);
                int rightSum = nums[right] + helper(nums, left, right-1, false);
                aliceSum = Math.max(leftSum,rightSum);
            }else{
                int leftSum = nums[left] + helper(nums, left+1, right,true);
                int rightSum = nums[right] + helper(nums, left, right-1, true);
                bobSum = Math.max(leftSum,rightSum);
            }

        }else {
            if(aliceSum>bobSum){

            }
        }

        return 0;
    }
}
