package com.example.greedy;

import java.util.Arrays;

/**
 * @author ankush.nakaskar
 */
public class LargestPerimeterTriangle {

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{7,10,2,1,2}));
    }
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i= nums.length-3;i>=0;i--){
            int a = nums[i+2];
            int b = nums[i+1];
            int c = nums[i];
            if(b+c >a){
                return a+b+c;
            }
        }
        return 0;
    }

}
