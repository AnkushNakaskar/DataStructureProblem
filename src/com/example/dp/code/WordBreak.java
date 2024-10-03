package com.example.dp.code;

import java.util.Arrays;
import java.util.List;

/**
 * @author ankush.nakaskar
 */
public class WordBreak {

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet","code")));
        System.out.println(wordBreak("a", Arrays.asList("b")));
    }
//    Input: s = "leetcode", wordDict = ["leet","code"]
    public static boolean wordBreak(String input, List<String> wordDict) {
        if(input==null || input.isEmpty()){
            return false;
        }
        boolean[] dp =new boolean[input.length()+1];
//        dp[0]=true;
        for(int i=0;i<input.length();i++){
            for(int j=i;j>=0;j--){
                if(wordDict.contains(input.substring(j,i+1))){
                    if(j==0){
                        dp[i]=true;
                    }else if (dp[j-1]){
                        dp[i]=true;
                    }
                }
            }
        }
        return dp[input.length()-1];

    }
}
