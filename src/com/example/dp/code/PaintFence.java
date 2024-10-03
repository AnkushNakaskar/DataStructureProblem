package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class PaintFence {

    public static void main(String[] args) {
        System.out.println(numWays(3,2));
        System.out.println(numWays(2,2));
        System.out.println(numWays(1,1));
        System.out.println(numWays(7,2));
    }
    public static int numWays(int n, int k) {
        if (n == 0 || k == 0) return 0;

        // Previous color set to -1 (allowing any color) and last two neighbors were not the same color to start
        int[] nums =new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        return help(nums,0,k,-1,false);
    }

    private static int help(int[] nums,int index, int k,int prevColour,boolean isLastSame) {
        if(index==nums.length){
            return 1;
        }
        if(index>nums.length){
            return 0;
        }
        int ways =0;
        for(int colour =0;colour<k;colour++){
            if(prevColour==colour && isLastSame) continue;
            ways += help(nums, index+1, k,colour,prevColour==colour) ;
        }
        return ways;
    }


}
