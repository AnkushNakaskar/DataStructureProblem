package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class NumRollsToTarget {

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(2,6,7));
    }

    public static int numRollsToTarget(int n, int k, int target) {
        int res =0;
        res = helper(n,k,target);
        return res;
    }

    private static int helper(int n, int k, int target) {
        if(target==0 && n==0){
            return 1;
        }
        if(target<0 || n<=0){
            return 0;
        }
        int ans =0;
        for(int i=1;i<=k;i++){
            ans+=helper(n-1,k,target-i);
        }
        return ans;
    }
}
