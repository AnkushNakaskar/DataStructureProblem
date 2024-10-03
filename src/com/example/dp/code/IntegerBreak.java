package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class IntegerBreak {

    public static void main(String[] args) {
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(3));
        System.out.println(integerBreak(4));
        System.out.println(integerBreak(5));
        System.out.println(integerBreak(6));
        System.out.println(integerBreak(10));
    }
    public static int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i]=1;
            for(int j=1;j<=i-1;j++){
                dp[i]=Math.max(dp[i],Math.max(dp[j],j) * (i-j));
            }

        }
        return dp[n];
    }
}
