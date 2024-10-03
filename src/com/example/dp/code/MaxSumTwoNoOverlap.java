package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class MaxSumTwoNoOverlap {

    public static void main(String[] args) {
        System.out.println(maxSumTwoNoOverlap(new int[]{
                1,0,3
        },1,2));
        System.out.println(maxSumTwoNoOverlap(new int[]{
                8,20,6,2,20,17,6,3,20,8,12
        },5,4));
        System.out.println(maxSumTwoNoOverlap(new int[]{
                2,1,5,6,0,9,5,0,3,8
        },4,3));
        System.out.println(maxSumTwoNoOverlap(new int[]{
                3,8,1,3,2,1,8,9,0
        },3,2));
        System.out.println(maxSumTwoNoOverlap(new int[]{
                0,6,5,2,2,5,1,9,4
        },1,2));
    }
    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] dpLeftMax = new int[nums.length];
        int[] dpRightMax = new int[nums.length];
        int maxLength = Math.max(firstLen,secondLen);
        int minLength = Math.min(firstLen,secondLen);
        int currSum =0;
        int leftMaxSum =0;
        for(int i=0;i<maxLength;i++){
            currSum+=nums[i];
        }
        leftMaxSum=currSum;
        dpLeftMax[maxLength-1]=currSum;
        for(int i=maxLength;i< nums.length;i++){
            currSum=currSum-nums[i-maxLength]+nums[i];
            leftMaxSum= Math.max(leftMaxSum,currSum);
            dpLeftMax[i]= leftMaxSum;
        }
        currSum =0;
        for(int i= nums.length-1;i> nums.length-1-maxLength;i--){
            currSum+=nums[i];
        }
        int rightMaxSum =currSum;
        dpRightMax[nums.length-maxLength]=currSum;
        for(int i=nums.length-maxLength-1;i>=0;i--){
            currSum=currSum-nums[i+maxLength]+nums[i];
            rightMaxSum= Math.max(rightMaxSum,currSum);
            dpRightMax[i]= rightMaxSum;
        }
        currSum=0;
        for(int i=0;i<minLength;i++){
            currSum+=nums[i];
        }
        int max = Math.max(0,dpRightMax[minLength]+currSum);
        for(int i=minLength;i< nums.length;i++){
            if(i>maxLength){
                if(i< nums.length-maxLength){
                    int leftSum = dpLeftMax[i-minLength];
                    int rightSum = dpRightMax[i+1];
                    currSum = currSum - nums[i-minLength]+nums[i];
                    max = Math.max(Math.max(leftSum,rightSum)+currSum,max);
                }else{
                    int leftSum = dpLeftMax[i-minLength];
                    currSum = currSum - nums[i-minLength]+nums[i];
                    max = Math.max(Math.max(leftSum,0)+currSum,max);
                }

            }else{
                if(i== nums.length-1){
                    continue;
                }
                int rightSum = dpRightMax[i+1];
                currSum = currSum - nums[i-minLength]+nums[i];
                max = Math.max(Math.max(0,rightSum)+currSum,max);
            }
        }
        return max;
    }
}
