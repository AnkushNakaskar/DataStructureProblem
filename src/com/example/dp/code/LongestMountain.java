package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class LongestMountain {

    public static void main(String[] args) {


        System.out.println(longestMountain(new int[]{
                0,2,0,2,1,2,3,4,4,1
        }));
        System.out.println(longestMountain(new int[]{
                0,1,2,3,4,5,4,3,2,1,0
        }));
        System.out.println(longestMountain(new int[]{
                2,1,4,7,3,2,5
        }));
        System.out.println(longestMountain(new int[]{
                2,2,2,2
        }));

    }
    public static int longestMountain(int[] nums) {
        int max = 0;
        for(int i=1;i< nums.length-1;i++){
            if(nums[i-1]<nums[i] && nums[i+1]<nums[i]){
                max =Math.max(max, helper(nums,i));

            }
        }
        return max;
    }

    private static int helper(int[] nums, int index) {
        int count=1;
        for(int i=index;i>0;i--){
            if(nums[i]>nums[i-1]){
                count++;
            }else{
                break;
            }
        }
        for(int i=index;i< nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}
