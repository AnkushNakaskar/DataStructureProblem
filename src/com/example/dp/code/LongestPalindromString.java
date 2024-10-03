package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class LongestPalindromString {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String  longestPalindrome(String input) {
        if(input==null || input.length()==0){
            return input;
        }
        if(input.length()==1){
            return input;
        }
        String palindrom= "";
        int max =0;
        boolean[][] dp = new boolean[input.length()][input.length()];
        for(int lenOfPalin =0;lenOfPalin<input.length();lenOfPalin++){
            for(int i=0,j=lenOfPalin;j<input.length();i++,j++){
                if(lenOfPalin==0){
                    dp[i][j]=true;
                }else if(lenOfPalin==1){
                    dp[i][j] = input.charAt(i)==input.charAt(j);
                }else{
                    dp[i][j] = input.charAt(i)==input.charAt(j) && dp[i+1][j-1];
                }
                if(dp[i][j] && lenOfPalin+1 > max){
                    max =Math.max(lenOfPalin+1,max);
                    palindrom = input.substring(i,j+1);
                }
            }
        }
        return palindrom;







    }

    public static String  longestPalindromeTest(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        if (input.length() == 1) {
            return input;
        }

        int max = 0;
        String palindrom ="";
        boolean[][] dp = new boolean[input.length()][input.length()];
        for (int gap = 0; gap < input.length(); gap++) {
            for (int i = 0,j=gap; j < input.length(); i++,j++) {
                if(gap==0){
                    dp[i][j]=true;
                }else if(gap==1){
                    dp[i][j]= input.charAt(i)==input.charAt(j);
                }else {
                    dp[i][j]=input.charAt(i)==input.charAt(j) && dp[i+1][j-1];
                }
                if(dp[i][j] && gap+1 > max){
                    palindrom =input.substring(i,j+1);
                    max =Math.max(max,gap+1);
                }

            }
        }
        System.out.println(palindrom);
        return palindrom;
    }


    public static String longestPalindromeOld(String input) {
        if (input == null || input.length() < 2) {
            return input;
        }

        /*
            babad
            dabab
        */
        String out = "";
        int len = input.length();
        int n = input.length();
        String reverse = new StringBuilder(input).reverse().toString();
        while (len > 1) {
            for (int i = 0; i <= input.length() - len; i++) {
                String s1 = input.substring(i, len + i);
                String s2 = reverse.substring(n - len - i, n - i);
                System.out.println(s1 + " " + s2);
                if (s1.equals(s2)) {
                    return s1;
                }
            }
            len--;
        }
        if (out.isEmpty()) {
            return input.substring(0, 1);
        }
        return out;


    }
}
