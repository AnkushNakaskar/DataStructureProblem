package com.example.dp.code;

import java.util.HashSet;

/**
 * @author ankush.nakaskar
 */
public class MaximumSum {
    public static int result;
    public static HashSet<Integer> visited;
    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{
                -1,5
        }));
        System.out.println(maximumSum(new int[]{
                1,-2,0,3
        }));
        System.out.println(maximumSum(new int[]{
                1,-2,-2,3
        }));
        System.out.println(maximumSum(new int[]{
                -1,-1,-1,-1
        }));
        System.out.println(maximumSum(new int[]{
                -1,5
        }));
    }
    public static int maximumSum(int[] nums) {
        int res =nums[0];
        int[] forwardSum = new int[nums.length];
        forwardSum[0]=nums[0];
        for(int i=1;i< nums.length;i++){
            forwardSum[i]=Math.max(nums[i], forwardSum[i-1]+nums[i]);
            res=Math.max(forwardSum[i],res);
        }
        int[] backwardSum = new int[nums.length];
        backwardSum[nums.length-1]=nums[nums.length-1];
        for(int i= nums.length-2;i>=0;i--){
            backwardSum[i]=Math.max(nums[i], backwardSum[i+1]+nums[i]);
            res=Math.max(backwardSum[i],res);
        }
        for(int i=1;i< nums.length-1;i++){
            res = Math.max(res,forwardSum[i-1]+backwardSum[i+1]);
        }
        return res;
    }

    public static int maximumSumOld(int[] nums) {
        int res =Integer.MIN_VALUE+1000;
        result =0;
        visited =new HashSet<>();
        for(int i=1;i< nums.length-1;i++){
            int leftSum=nums[i-1];
            int rightSum=nums[i+1];
            for(int j=i-1;j>=0;j--){
                if(j!=i-1)
                    leftSum+=nums[j];
                res = Math.max(res,Math.max(Math.max(leftSum,rightSum),leftSum+rightSum));
            }
            for(int m=i+1;m<nums.length;m++){
                if(m!=i+1)
                    rightSum+=nums[m];
                res = Math.max(res,Math.max(Math.max(leftSum,rightSum),leftSum+rightSum));
            }

        }
//        helper(nums,0);
        return res;
    }

    private static void helperNew(int[] nums, int index,int leftSum,int rightSum) {

        if(index< nums.length && !visited.contains(index)){
            visited.add(index);
            for(int i=index;i<nums.length;i++){
                if(i==0){
                    helperNew(nums, index, leftSum, rightSum+nums[i+1]);
                }else if(i== nums.length-1){
                    helperNew(nums, index, leftSum+nums[i-1], rightSum);
                }else{
                    helperNew(nums, index, leftSum+nums[i-1], rightSum+nums[i+1]);
                }

                System.out.println();
//                visited.remove(index);
            }
        }

        result = Math.max(result, Math.max(Math.max(leftSum,rightSum),leftSum+rightSum));
    }
    private static int helper(int[] nums, int index) {
        if(!visited.contains(index)){
            visited.add(index);
            int leftSum =0;
            for(int i=index+1;i< nums.length;i++){
                leftSum+=nums[i]+helper(nums, i+1);
            }
            int rightSum=0;
            for(int i=index-1;i>=0;i--){
                rightSum+=nums[i]+helper(nums, i-1);
            }
            int currSum =0;

            visited.remove(index);
            System.out.println(leftSum+rightSum);
            if(result<(leftSum+rightSum)){
                result = leftSum+rightSum;
            }
        }
        return 0;
    }

}
