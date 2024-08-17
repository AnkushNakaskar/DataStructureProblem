package com.example.quick;

/**
 * @author ankush.nakaskar
 */

public class QuickSortImpl {

    public static void main(String[] args) {
        int[] nums =new int[]{2 ,8 ,7 ,1 ,3 ,5 ,6 ,4};
        quickSort(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++){
            System.out.print(" "+nums[i]);
        }
    }

    private static void quickSort(int[] nums, int startIndex, int endIndex) {
        if(startIndex<endIndex){
            int mid = partition(nums,startIndex,endIndex);
            quickSort(nums, startIndex, mid-1);
            quickSort(nums, mid+1, endIndex);
        }
    }

    // 2 8 7 1 3 5 6 4
    private static int partition(int[] nums, int startIndex, int endIndex) {
        int x = nums[endIndex];
        int i=startIndex-1;
        for(int j=startIndex;j<=endIndex-1;j++){
            if(nums[j]<x){
                i=i+1;
                int tmp = nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
            }
        }
        int tmp = nums[i+1];
        nums[i+1]=nums[endIndex];
        nums[endIndex]=tmp;
        return i+1;
    }
}
