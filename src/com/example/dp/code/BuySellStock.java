package com.example.dp.code;

import java.util.HashMap;

/**
 * @author ankush.nakaskar
 */
public class BuySellStock {

    public static HashMap<String,Integer> map;
    public static void main(String[] args) {
//        System.out.println(maxProfitNewTwo(new int[]{7,1,5,3,6,4}));
//        System.out.println(maxProfitNewTwo(new int[]{3,6}));
        System.out.println(maxProfit(new int[]{
                1,3,2,8,4,9
        },2));
    }

    public static int maxProfit(int[] nums, int fee) {
//        map =new HashMap<>();
        int profit = help(nums,0,true,fee);
        return profit;
    }
    private static int help(int[] nums, int index,boolean buy,int fee) {
        if(index== nums.length) return 0;
        int currProfit =0;
        if(buy){
            int buyProfit = -nums[index]+help(nums, index+1, false, fee);
            int skipProfit = 0 + help(nums, index+1, true, fee);
            currProfit = Math.max(buyProfit,skipProfit);
        }else{
            int sellProfit = nums[index]-fee + help(nums, index+1, true, fee);
            int ignoreProfit = 0+ help(nums, index+1, false, fee);
            currProfit = Math.max(sellProfit,ignoreProfit);
        }
        return currProfit;
    }

    public static int maxProfitNewTwo(int[] nums) {
        map =new HashMap<>();
        int profit = help(nums,0,true);
        return profit;
    }

    private static int help(int[] nums, int index,boolean buy) {
        if(index== nums.length){
            return 0;
        }
        if(map.containsKey(""+index+buy)){
            return map.get(""+index+buy);
        }
        int currProfit =0;
        if(buy){
            int buyProfit =-nums[index]+help(nums, index+1, false); //want to buy
            int skipProfit= 0+help(nums, index+1, true);//dont want to buy
            currProfit = Math.max(buyProfit,skipProfit);
        }else{
            int sellProfit = +nums[index]+ help(nums, index+1, true); //Want to sell
            int ignore = 0+ help(nums, index+1, false);
            currProfit = Math.max(sellProfit,ignore);
        }
        map.put(""+index+buy,currProfit);
        return map.get(""+index+buy);

    }

    public static int maxProfitNewTwoEfficient(int[] nums) {

        int max =0;
        int min = nums[0];
        for(int i=1;i< nums.length;i++){
            if(nums[i]-nums[i-1]>0){
                max+=nums[i]-nums[i-1];
            }
        }
        return max;
    }


    public static int maxProfitNew(int[] nums) {
        int[] maxArr =new int[nums.length];
        maxArr[nums.length-1] = nums[nums.length-1];
        int min=nums[nums.length-1];
        for(int i= nums.length-2;i>=0;i--){
            maxArr[i]=Math.max(maxArr[i+1],nums[i]);
        }
        int max = Integer.MIN_VALUE+1000;
        for(int i=0;i< nums.length;i++){
            max = Math.max(max,maxArr[i]-nums[i]);
        }
        return max;
    }

















    public static int maxProfit(int[] nums) {
        int[] dp =new int[nums.length];
        int max = nums[nums.length-1];
        for(int i= nums.length-2;i>=0;i--){
            max = Math.max(nums[i],max);
            dp[i]=max;
        }
        int diff =0;
        int currMax = 0;
        for(int i=0;i< nums.length;i++){
            diff = dp[i]-nums[i];
            if(diff >0 && diff>currMax){
                currMax = diff;
            }
        }
        return currMax;
    }
}
