package com.example.dp.code;

import java.util.HashMap;

/**
 * @author ankush.nakaskar
 */
public class DeleteOperationOfTwoString {

    public static HashMap<String,Integer> map ;

    public static void main(String[] args) {
        System.out.println(minDistance("sea","eat"));
        System.out.println(minDistance("sea","ate"));
    }
    public static int minDistance(String word1, String word2) {
        int[][] dp =new int[word1.length()+1][word2.length()+1];
        for(int i=0;i< dp.length;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static int minDistanceMemory(String word1, String word2) {
        if(word1==null && word2==null){
            return 0;
        }
        map =new HashMap<>();
        int res = help(word1,word2,word1.length(),word2.length());
        return res;
    }

    private static int help(String word1, String word2, int word1Length, int word2Length) {
        if(word1Length==0 || word2Length==0){
            return word1Length+word2Length;
        }
        if(map.containsKey(""+word1Length+word2Length)){
            return map.get(""+word1Length+word2Length);
        }
        if(word1.charAt(word1Length-1)==word2.charAt(word2Length-1)){
            map.put(""+word1Length+word2Length,help(word1,word2,word1Length-1,word2Length-1));
            return help(word1,word2,word1Length-1,word2Length-1);
        }else{
            map.put(""+word1Length+word2Length,Math.min(help(word1, word2, word1Length-1, word2Length),help(word1, word2, word1Length, word2Length-1))+1);
        }
        return map.get(""+word1Length+word2Length);
    }

    public static int minDistanceOld(String word1, String word2) {
        int[] dp1 =new int[26];
        int[] dp2 =new int[26];
        for(char ch : word1.toCharArray()){
            int index = ch-'a';
            dp1[index]++;
        }
        for(char ch : word2.toCharArray()){
            int index = ch-'a';
            dp2[index]++;
        }
        int sum =0;
        for(int i=0;i<26;i++){
            sum = sum+Math.abs(dp1[i]-dp2[i]);
        }
        return sum;
    }
}
