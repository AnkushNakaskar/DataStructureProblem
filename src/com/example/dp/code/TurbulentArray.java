package com.example.dp.code;

import java.util.Arrays;

/**
 * @author ankush.nakaskar
 */
public class TurbulentArray {
    public static void main(String[] args) {

        System.out.println(maxTurbulenceSize(new int[]{
                0,8,45,88,48,68,28,55,17,24
        }));

        System.out.println(maxTurbulenceSize(new int[]{
                2,0,2,4,2,5,0,1,2,3
        }));
        System.out.println(maxTurbulenceSize(new int[]{
                9,4,2,10,7,8,8,1,9
        }));
        System.out.println(maxTurbulenceSize(new int[]{
                4,8,12,16
        }));

    }


    public static int maxTurbulenceSize(int[] nums) {
        if(nums==null|| nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int max =1;
        int count =1;

        /*
        For i <= k < j:
        arr[k] > arr[k + 1] when k is odd, and
        arr[k] < arr[k + 1] when k is even.
         */
        for(int i=0;i< nums.length-1;i++){
            if(i%2==0 && (nums[i]<nums[i+1])){
                count++;
            } else if (i%2==1 && (nums[i]>nums[i+1])) {
                count++;
            }else{
                max = Math.max(max,count);
                count=1;
            }
        }
        max = Math.max(max,count);

        /*
        Or, for i <= k < j:
arr[k] > arr[k + 1] when k is even, and
arr[k] < arr[k + 1] when k is odd.

         */
        count=1;
        for(int i=0;i< nums.length-1;i++){
            if (i % 2 == 0 && (nums[i]>nums[i+1])) {
                count++;
            } else if (i % 2 == 1 && (nums[i]<nums[i+1])) {
                count++;
            }else{
                max = Math.max(max,count);
                count=1;
            }
        }
        max = Math.max(max,count);

        return max;

    }


}
