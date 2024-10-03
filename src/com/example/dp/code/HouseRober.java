package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class HouseRober {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }
    public static int rob(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        return helpRob(nums,0);
    }

    private static int helpRob(int[] nums, int index) {
        if(index>= nums.length){
            return 0;
        }

        return Math.max(nums[index] + helpRob(nums, index+2),helpRob(nums, index+1));

    }
}
