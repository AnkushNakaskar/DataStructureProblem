package com.example.count;

/**
 * @author ankush.nakaskar
 */
//25302303
public class CountSort {
    public static void main(String[] args) {
//        int[] res = countSort(new int[]{2,5,3,0,2,3,0,3},5);
//        printArr(res);

        int[] res1 = countSort(new int[]{2,5,3,1,2,3,1,3},5);
        printArr(res1);
    }

    private static void printArr(int[] res) {
        for(int i = 0; i< res.length; i++){
            System.out.print(" "+ res[i]);
        }
    }

    private static int[] countSort(int[] nums,int k) {
        if(nums==null || nums.length<=1){
            return nums;
        }
        int[] count =new int[k+1];
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }
        int[]sum =new int[k+1];
        int sumVal=0;
        for(int i=0;i< count.length;i++){
            sumVal =sumVal+ count[i];
            sum[i]=sumVal;
        }
        printArr(nums);
        System.out.println();
        printArr(sum);
        System.out.println();
        int[] res =new int[nums.length+1];
        for(int i= nums.length-1;i>=0;i--){
            int index = nums[i];
            int val =sum[index];
            res[val]=nums[i];
            sum[index]=sum[index]-1;
        }
        return res;
    }
}
