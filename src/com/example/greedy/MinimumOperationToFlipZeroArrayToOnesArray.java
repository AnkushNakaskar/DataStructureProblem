package com.example.greedy;

/**
 * @author ankush.nakaskar
 */
public class MinimumOperationToFlipZeroArrayToOnesArray {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{0,1,0,0,1}));
        System.out.println(minOperations(new int[]{0,0,1,1,0,0,1}));
        System.out.println(minOperations(new int[]{1,0,1,1,1,0,1,0,0,0}));
        System.out.println(minOperations(new int[]{0,1,1,0,1}));
        System.out.println(minOperations(new int[]{1,0,0,0}));
        System.out.println(minOperations(new int[]{0,0,1}));
    }
    public static int minOperations(int[] nums) {
        int count =0;
        for(int i=0;i< nums.length;i++){
            if((nums[i]%2!=0 && nums[i]==1)||(nums[i]%2==0 && nums[i]==0)){
                count++;
            }
        }
        return count;
    }
    public static int minOperationsOld(int[] nums) {
        int count=0;
        int ans=0;
        int start=0;
        while(start< nums.length && nums[start]==1){
            start++;
        }
        boolean isPrevZero =false;
        int i = nums.length-1;
        while(i>=start) {
            if(nums[i]==1){
                count++;
                while(i>=start && nums[i]==1){
                    i--;
                }
                if(isPrevZero){
                    ans = ans + count+1;
                }else{
                    ans = ans + count;
                }
                isPrevZero=!isPrevZero;
            }else{
                i--;
            }
        }
        return ans;
    }
    public static int minOperationsOld1(int[] nums) {
        int ans =0;
        int i= nums.length-1;
        int count =0;
        int start=0;
        while(start< nums.length && nums[start]==1){
            start++;
        }
        int countOnes =0;
        for(int m=start;m< nums.length;m++){
            if(nums[m]==1){
                countOnes++;
            }
        }
        return countOnes+1;
//
//        boolean isOneFound=false;
//        while(i>=start){
//
//            while(i>=0 && nums[i]==1){
//                i--;
//                count++;
//                isOneFound=true;
//            }
//            ans+=count;
//            i--;
//        }
//        if(!isOneFound){
//            return 1;
//        }
//        return ans;
    }
}
