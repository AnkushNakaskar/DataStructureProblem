package com.example.greedy;

/**
 * @author ankush.nakaskar
 */
public class IncreasingTripplet {

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{
                1,2,3,4,5
        }));
        System.out.println(increasingTriplet(new int[]{
                5,4,3,2,1
        }));
        System.out.println(increasingTriplet(new int[]{
                5,2,3,2,1
        }));
    }
    public static boolean increasingTriplet(int[] nums) {
        int[] minNums =new int[nums.length];
        int[] maxNums =new int[nums.length];
        int min = nums[0];
        for(int i =0;i< nums.length;i++){
            min = Math.min(min,nums[i]);
            minNums[i] = min;
        }
        int max = nums[nums.length-1];
        for(int i= nums.length-1;i>=0;i--){
            max = Math.max(max,nums[i]);
            maxNums[i]=max;
        }
        for(int i=1;i< nums.length-1;i++){
            if(minNums[i-1]<nums[i] && nums[i] < maxNums[i+1]){
                return true;
            }
        }
        return false;
    }
}
