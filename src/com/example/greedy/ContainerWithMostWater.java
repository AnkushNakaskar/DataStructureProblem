package com.example.greedy;

/**
 * @author ankush.nakaskar
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{
                1,8,6,2,5,4,8,3,7
        }));
        System.out.println(maxArea(new int[]{
                1,1
        }));
    }
    public static int maxArea(int[] nums) {
        int max = Integer.MIN_VALUE;
        int left =0;
        int right= nums.length-1;
        while(left<right){
            if(nums[left]<nums[right]){
                max = Math.max(max,nums[left]*(right-left));
                left++;
            }else{
                max = Math.max(max,nums[right]*(right-left));
                right--;
            }
        }
        return max;
    }
}
