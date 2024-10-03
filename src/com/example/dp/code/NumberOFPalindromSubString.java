package com.example.dp.code;

import java.util.Arrays;

/**
 * @author ankush.nakaskar
 */
public class NumberOFPalindromSubString {

    public static void main(String[] args) {
        System.out.println(countSubstrings("aba"));
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String input) {
        boolean[][] dp =new boolean[input.length()][input.length()];
        int count =0;
        for(int i=0;i<input.length();i++){
            dp[i][i]=true;
            count++;
        }
        for(int i=0;i<input.length()-1;i++){
            if(input.charAt(i)==input.charAt(i+1)){
                dp[i][i+1]=true;
                count++;
            }
        }
        for(int len=3;len<=input.length();len++){
            for(int i=0;i<=input.length()-len;i++){
                int j = len+i-1;
                if(input.charAt(i)==input.charAt(j) && dp[i+1][j-1]){
                    dp[i][j]=true;
                    count++;
                }
            }
        }
        return count;
    }
    public static int countSubstringsOld(String input) {
        String reverse = new StringBuilder(input).reverse().toString();
        int[][] dp =new int[input.length()+1][input.length()+1];
//        for(int i=0;i<=input.length();i++){
//            dp[i][0]=1;
//            dp[0][i]=1;
//        }

        for(int i=1;i<=input.length();i++){
            for(int j=1;j<=reverse.length();j++){
                if(input.charAt(i-1)==reverse.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;

                }else{
                    dp[i][j]= Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int count =0;
        for(int j=0;j<dp[input.length()].length;j++){
            count+=dp[input.length()][j];
        }
        return count;
    }
}
