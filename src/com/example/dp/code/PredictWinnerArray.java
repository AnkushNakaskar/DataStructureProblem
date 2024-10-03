package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class PredictWinnerArray {

    public static void main(String[] args) {
        System.out.println(predictTheWinner(new int[]{
                1,5,2,7
        }));
        System.out.println(predictTheWinner(new int[]{
                1,5,2
        }));

        System.out.println(predictTheWinner(new int[]{
                1,5,233,7
        }));

        System.out.println(predictTheWinner(new int[]{
                1,1,1
        }));
    }

    public static boolean predictTheWinner(int[] nums) {
        if(nums==null || nums.length<=1){
            return true;
        }
        return help(nums,0, nums.length-1, 0,0,false);

    }

    private static boolean help(int[] nums, int leftIndex, int rightIndex, int sum1, int sum2,boolean isP1) {
        if(leftIndex>rightIndex){
            if((isP1 && sum1>=sum2)){
                return true;
            }
            return false;
        }
        if(!isP1){
            return help(nums, leftIndex+1, rightIndex, sum1+nums[leftIndex], sum2, !isP1) ||  help(nums, leftIndex, rightIndex-1, sum1+nums[rightIndex], sum2, !isP1);
        }else{
            return help(nums, leftIndex+1, rightIndex, sum1, sum2+nums[leftIndex], !isP1) ||  help(nums, leftIndex, rightIndex-1, sum1, sum2+nums[rightIndex], !isP1);
        }

    }




    private static boolean helpOld(int[] nums, int leftIndex, int rightIndex, int sum1, int sum2,boolean isP1) {
        if(leftIndex>rightIndex){
            if(isP1 && sum1>=sum2){
                return true;
            }
            return false;
        }
        if(leftIndex>nums.length && rightIndex<0){
            return sum1>=sum2;
        }
        if(nums[leftIndex]>nums[rightIndex]){
            if(isP1){
                return help(nums, leftIndex+1, rightIndex, sum1+nums[leftIndex], sum2,!isP1);
            }else{
                return help(nums, leftIndex+1, rightIndex, sum1, sum2+nums[leftIndex],!isP1);
            }

        }else {
            if(isP1){
                return help(nums, leftIndex, rightIndex-1, sum1+nums[rightIndex], sum2,!isP1);
            }else{
                return help(nums, leftIndex, rightIndex-1, sum1, sum2+nums[rightIndex],!isP1);
            }
        }

    }
}
