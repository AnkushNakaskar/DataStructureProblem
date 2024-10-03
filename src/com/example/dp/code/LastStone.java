package com.example.dp.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ankush.nakaskar
 */
public class LastStone {

    public static int min;
    public static void main(String[] args) {
        System.out.println(lastStoneWeightII(new int[]{
                2,7,4,1,8,1
        }));
        System.out.println(lastStoneWeightII(new int[]{
                31,26,33,21,40
        }));
    }
    public static int lastStoneWeightII(int[] nums) {
//        This problem say , we need to find out the max value which is nearest to totalSum/2;
        int totalSum =0;
        for(int val : nums){
            totalSum+=val;
        }
        int W = totalSum/2;
        int diff = helpRec(0,nums,W);

        return totalSum-(2 * diff);
    }

    private static int helpRec(int index,int[] nums, int W) {
        if(index== nums.length-1){
            if(nums[index]<=W){
                return nums[index];
            }else{
                return 0;
            }
        }

            int notTake  = helpRec(index+1,nums, W);
            int take = Integer.MIN_VALUE+1000;
            if(nums[index]<=W){
                take = nums[index]+helpRec(index+1,nums, W-nums[index]);
            }
            return Math.max(notTake,take);

    }

    public static int lastStoneWeightIIOld(int[] nums) {
        min =Integer.MAX_VALUE-1000;
        List<Integer> list =new ArrayList<>();
        for(int val : nums){
            list.add(val);
        }
        helper(list);
        return min;
    }

    private static void helper(List<Integer> list) {
        List<List<Integer>> currLists = new ArrayList<>();
        for(int j=1;j<list.size();j++){
            List<Integer> currList = new ArrayList<>();
            currList.addAll(list);
            currList.remove(0);
            currList.remove(j-1);
            currList.add(Math.abs(list.get(j)-list.get(0)));
            currLists.add(currList);
        }
        int minVal =Integer.MAX_VALUE-1000;
        for(List<Integer> tmp : currLists){
            if(tmp.size()==1){
                min = Math.min(min,tmp.get(0));
            }else if(tmp.isEmpty()){
                min = Math.min(min,0);
            }else{
                helper(tmp);
            }
        }
    }
}
