package com.example.greedy;

import java.util.Arrays;

/**
 * @author ankush.nakaskar
 */
public class WiggleSort2 {

    public static void main(String[] args) {
        wiggleSort(new int[]{
                1,3,2,2,3,1
        });
    }
    public static void wiggleSort(int[] arr) {
        int[] nums = Arrays.copyOf(arr,arr.length);
        Arrays.sort(nums);
        int left = (nums.length-1)/2;
        int right = nums.length-1;
        Arrays.fill(arr,0);
        int i=0;
        while(left>=0){
            arr[i++]=nums[left--];
            if(i>= nums.length)break;
            arr[i++]=nums[right--];
        }
//        arr[arr.length-1]=nums[left];
        for(int val : arr){
            System.out.print(val + " ");
        }
    }
}
