package com.example.dp.code;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class DeleteAndEarn {

    public static void main(String[] args) {

        System.out.println(deleteAndEarn(new int[]{8,10,4,9,1,3,5,9,4,10}));
        System.out.println(deleteAndEarn(new int[]{3,4,2}));
        System.out.println(deleteAndEarn(new int[]{3}));
        System.out.println(deleteAndEarn(new int[]{3,4}));
        System.out.println(deleteAndEarn(new int[]{2,2,3,3,3,4}));
        System.out.println(deleteAndEarn(new int[]{8,3,4,7,6,6,9,2,5,8,2,4,9,5,9,1,5,7,1,4}));
        System.out.println(deleteAndEarn(new int[]{4,10,10,8,1,4,10,9,7,6}));

    }
    public static int result ;
    public static int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        Map<Integer,Integer> map =new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> queue =new PriorityQueue<>((a,b) ->{
            return b.getValue()-a.getValue();
        });
        int max = 0;
        for(int value : nums){
            map.put(value, map.getOrDefault(value,0)+value);
            max = Math.max(max,value);
        }
        int[] freq  =new int[max+1];
        for(int i=1;i<freq.length;i++){
            freq[i]=map.getOrDefault(i,0);
        }
        int[] dp = new int[max+1];
        dp[1] = freq[1];

        for(int i=2;i< freq.length;i++){
            dp[i] = Math.max(dp[i-2]+freq[i],dp[i-1]);
        }


//
        return dp[dp.length-1];
    }
    private static int help(int[] nums,int index){
        int currSum=0;
        for(int i=index;i< nums.length-1;i++){
            currSum= currSum+nums[i]-nums[i-1]-nums[i+1] + help(nums, i+2);
        }
        if(currSum>result){
            result = Math.max(result,currSum);
        }

        return 0;
    }
    private static int help(int[] nums, int index,int currSumValue, int prev) {
        if(index>0 && index< nums.length-1)
        {
//            int leftSum = help(nums, index+1, currSumValue+nums[index]-prev-next, nums[index], nums[index+1]);
//            int rightSum = help(nums, index+1, currSumValue, nums[index], nums[index+1]);
            return Math.max(help(nums, index+2, currSumValue+nums[index]-prev-nums[index+1], 0),
                    help(nums, index+1, currSumValue, nums[index]));
        }
        return currSumValue;

    }

    private static int helpOld(int[] nums, int index,int currSumValue,boolean isSelect) {
        if(index< nums.length){
            int currSum =0;
            int selectSum =0;
            int skipSum =0;
            if(isSelect){
                int prev =0;
                int next =0;
                if(index>0){
                    prev = nums[index-1];
                }
                if(index < nums.length-1){
                    next = nums[index+1];
                }

                 selectSum =  helpOld(nums, index+1,nums[index]-prev-next ,!isSelect);
                currSum = Math.max(selectSum,currSum);
            }else{
                int prev =0;
                int next =0;
                if(index>0){
                    prev = nums[index-1];
                }
                if(index < nums.length-1){
                    next = nums[index+1];
                }
                skipSum =  helpOld(nums, index+1,currSumValue ,!isSelect);
                currSum = Math.max(skipSum,currSum);
            }
            if(currSum>result){
               result = Math.max(result,currSum);
            }
        }
        return currSumValue;
    }
}
