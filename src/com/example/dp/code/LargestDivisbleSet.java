package com.example.dp.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ankush.nakaskar
 */
public class LargestDivisbleSet {

    public static int max;
    public static List<List<Integer>> finalList = new LinkedList<>();
    public static List<Integer> visitedList;

    public static void main(String[] args) {
//        System.out.println(largestDivisibleSubset(new int[]{1, 2, 3}));
//        System.out.println(largestDivisibleSubset(new int[]{1,2,4,8}));
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 3, 8, 9, 15}));
    }

    public static List<Integer> largestDivisibleSubsetOld(int[] nums) {
        Arrays.sort(nums);

        // get the max size of divisible subset
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxSz = 0;
        for (int n : dp) maxSz = Math.max(maxSz, n);

        // For case [1,2,3,4,9,36], res can be [1,2,4,36] or [1,3,9,36], and dp be [1,2,2,3,3,4].
        // This loop from back to front, pick one path, and "prev % nums[i] == 0" does the path matching
        LinkedList<Integer> res = new LinkedList<>();
        int prev = -1;
        for (int i = nums.length-1; i >= 0; i--) {
            if (maxSz != dp[i]) continue;

            if (prev == -1 || prev % nums[i] == 0) {
                res.addFirst(nums[i]);
                maxSz--;
                prev = nums[i];
            }
        }
        return res;
    }


    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
       LinkedList<Integer> list  = new LinkedList<>();
       int[] dp =new int[nums.length];
       for(int i=0;i< nums.length;i++){
           for(int j=0;j<i;j++){
               if (nums[i] % nums[j] == 0) {
                   dp[i] = Math.max(dp[i], dp[j] + 1);
               }
           }
       }
       int max =0;
       for(int val : dp){
           max =Math.max(max,val);
       }
       int prev =-1;
       for(int i= nums.length-1;i>=0;i--){
           if(max!=dp[i])continue;
           if(prev==-1 || prev%nums[i]==0){
               list.addFirst(nums[i]);
               max--;
               prev = nums[i];
           }
        }
        return list;
    }

    private static boolean help(int[] nums, int index, List<Integer> list) {
//1, 2, 3, 8, 9, 15


        for (int i = index; i < nums.length; ) {
            if(!visitedList.contains(i) && nums[i] % list.get(list.size() - 1) == 0){
                list.add(nums[i]);
                visitedList.add(i);
                help(nums, i + 1, list);
                i++;
            }else{
                if(!list.isEmpty() && nums[i]==list.get(list.size()-1)){
                    list.remove(list.size()-1);
                    visitedList.remove(visitedList.size()-1);
                }else{
                    i++;
                }


            }
        }
        finalList.add(new ArrayList<>(list));
        return false;
    }

}
