package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class LongestPalindromeSubseq {

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("babababab"));
    }

    public static int longestPalindromeSubseq(String input) {

        int[][] dp =new int[input.length()+1][input.length()+1];
        String reverse = new StringBuilder(input).reverse().toString();
        for(int i=0;i<=input.length();i++){
            dp[i][0]=0;
        }
        for(int i=0;i<input.length()+1;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=input.length();i++){
            for(int j=1;j<=input.length();j++){
                if(input.charAt(i-1)==reverse.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[input.length()][input.length()];

    }
}
