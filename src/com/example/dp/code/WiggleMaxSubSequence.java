package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class WiggleMaxSubSequence {

    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
        System.out.println(wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(wiggleMaxLength(new int[]{84}));
    }

    public static int wiggleMaxLength(int[] nums) {

        if(nums==null|| nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }


        int max = 1;
        for (int i = 1; i < nums.length; i++) {

            boolean isCurrentGreater =false;
            if(nums[i]>nums[i-1]){
                isCurrentGreater=true;
            } else if (nums[i]==nums[i-1]) {
                continue;
            }
            int currMax = 2;
            int prev = nums[i];
            for (int j = i-1; j>0; j--) {
                if(isCurrentGreater){
                    if(nums[j]<nums[j-1]){
                        currMax++;
                        isCurrentGreater=false;
                    }else {
                        continue;
                    }
                }else{
                    if(nums[j]>nums[j-1]){
                        currMax++;
                        isCurrentGreater=true;
                    }else {
                        continue;
                    }
                }
            }
            max = Math.max(currMax,max);
        }
        return max;
    }
}
