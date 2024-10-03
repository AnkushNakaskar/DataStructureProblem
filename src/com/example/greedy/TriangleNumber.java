package com.example.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ankush.nakaskar
 */
public class TriangleNumber {
    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{
                2,2,3,4
        }));
        System.out.println(triangleNumber(new int[]{
                7,0,0,0
        }));
        System.out.println(triangleNumber(new int[]{
                24,3,82,22,35,84,19
        }));

    }
    public static int triangleNumber(int[] nums) {
        int count =0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int a = nums[i];
            if(a!=0)
            for(int j=i+1;j<nums.length;j++){
                int b=nums[j];
                if(b!=0)
                for(int k=j+1;k<nums.length;k++){
                    int c = nums[k];
                    String key =""+a+""+b+""+c;
                    if(nums[k]!=0 && (a+b)>c ){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
