package com.example.dp.code;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ankush.nakaskar
 */
public class CanPartition {


    public static boolean[] globalVisited;
    public static void main(String[] args) {

        System.out.println(canPartitionKSubsets(new int[]{
                1,1,1,1,2,2,2,2
        },4));

        System.out.println(canPartitionKSubsets(new int[]{
                2,2,2,2,3,4,5
        },4));

        System.out.println(canPartitionKSubsets(new int[]{
                2,4,3,1,5
        },3));
//
        System.out.println(canPartitionKSubsets(new int[]{
                4,3,2,3,5,2,1
        },4));
        System.out.println(canPartitionKSubsets(new int[]{
                1,2,3,4
        },3));
        System.out.println(canPartitionKSubsets(new int[]{
                3,2,1,3,6,1,4,8,10,8,9,1,7,9,8,1
        },9));

    }
    public static int count ;
    public static boolean found ;
    public static boolean canPartitionKSubsets(int[] nums, int k) {

        int sum =0;
        count =0;
        for(int val : nums){
            sum+=val;
        }
        if(sum%k!=0){
            return false;
        }
        int subSum = sum/k;
        boolean[] visited =new boolean[nums.length];
        found =false;
        boolean res = help(nums, 0, 0,subSum, visited, k);

        return res;
    }



    private static boolean help(int[] nums, int index, int currSum,int targetSum, boolean[] visited,int k) {
        if(k==0){
            return true;
        }

        if(currSum==targetSum){

            return help(nums, 0, 0,targetSum, visited, k-1);
        }
        for(int i=index;i<nums.length;i++){

            if(targetSum+nums[i]>=0 & !visited[i]){
                visited[i]=true;
                if(help(nums, i+1, currSum+nums[i],targetSum, visited, k)){
                    return true;
                }
                visited[i]=false;
                if(currSum==0)return false;
            }

        }
        return false;
//        System.out.println("Index :: "+index);
    }
}
