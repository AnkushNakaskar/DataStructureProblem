package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","ace"));
        System.out.println(longestCommonSubsequence("abc","abc"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int res =0;
        int[][] dp =new int[text1.length()][text2.length()];
        int rowMax=0;
        int columnMax =0;
        for(int i=0;i<text1.length();i++){
            for(int j=0;j<text2.length();j++){
                if(i==0){
                    if(text1.charAt(i)==text2.charAt(j)){
                        dp[i][j]=rowMax+1;
                        rowMax=rowMax+1;
                    }else{
                        dp[i][j]=rowMax;
                    }
                }
                if(j==0){
                    if(text1.charAt(i)==text2.charAt(j)){
                        dp[i][j]=columnMax+1;
                        columnMax=columnMax+1;
                    }else{
                        dp[i][j]=columnMax;
                    }
                }
            }
        }
        for(int i=1;i<text1.length();i++){
            for(int j=1;j<text2.length();j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]= dp[i-1][j-1]+1;
                }else{
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()-1][text2.length()-1];

    }
}
