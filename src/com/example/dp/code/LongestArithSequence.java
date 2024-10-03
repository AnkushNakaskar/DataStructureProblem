package com.example.dp.code;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ankush.nakaskar
 */
public class LongestArithSequence {

    public static void main(String[] args) {


        System.out.println(longestArithSeqLength(new int[]{
                3,6,8,11
        }));
        System.out.println(longestArithSeqLength(new int[]{
                9,4,7,2,10
        }));
        System.out.println(longestArithSeqLength(new int[]{
                3,6,9,12
        }));
        System.out.println(longestArithSeqLength(new int[]{
                20,1,15,3,10,5,8
        }));
        System.out.println(longestArithSeqLength(new int[]{
               3,6
        }));
    }

    public static  int longestArithSeqLength(int[] nums) {
        int max =1;
        int len= nums.length;
        int[][] dp = new int[len][2000];
        for(int i =0;i<nums.length;i++){
            for(int j=i+1;j< nums.length;j++){
                int diff = nums[j]-nums[i]+1000;
                dp[j][diff] = Math.max(2,dp[i][diff]+1);
                max = Math.max(max,dp[j][diff]);
            }
        }
        return max;
    }
    public static  int longestArithSeqLengthOld(int[] nums) {

        HashMap<Integer,Integer> map =new HashMap<>();
        int max =1;
        for(int i=0;i< nums.length;i++){
            int currMax=1;
            for(int j=i+1;j< nums.length;j++){
                int diff = nums[j]-nums[i];

                currMax=2;
                int curr = nums[j];
                for(int k=j+1;k< nums.length;k++){
                    if(nums[k]==(curr+diff)){
                        currMax++;
                        curr = nums[k];
                    }
                    max = Math.max(max,currMax);
                }
                max = Math.max(max,currMax);
            }
        }

        return max;
    }
}
