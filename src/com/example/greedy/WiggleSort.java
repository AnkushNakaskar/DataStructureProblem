package com.example.greedy;

import java.util.Arrays;

/**
 * @author ankush.nakaskar
 */
public class WiggleSort {

    public static void main(String[] args) {
//        System.out.println();
//        wiggleSort(new int[]{
//                3,5,2,1,6,4
//        });
//        System.out.println();
//        wiggleSort(new int[]{
//                6,6,5,6,3,8
//        });
        System.out.println();
        wiggleSort(new int[]{
                1,2,3
        });
        System.out.println();
        wiggleSort(new int[]{
                1,2,3,4
        });

    }
    public static void wiggleSort(int[] arr) {
        int[] nums = Arrays.copyOf(arr,arr.length);
        Arrays.sort(nums);
        int left =0;
        int right = nums.length-1;
        Arrays.fill(arr,0);
        for(int i=0;i<arr.length-1;){
            arr[i++]= nums[left++];
            arr[i++]= nums[right--];
        }
        arr[arr.length-1]=nums[left];
        for(int val : arr){
            System.out.print(val + " ");
        }
    }
}
