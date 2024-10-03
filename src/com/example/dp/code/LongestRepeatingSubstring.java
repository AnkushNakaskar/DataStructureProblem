package com.example.dp.code;

import java.util.HashSet;

/**
 * @author ankush.nakaskar
 */
public class LongestRepeatingSubstring {

    public static void main(String[] args) {
        System.out.println(longestRepeatingSubstring("aaaaa"));
        System.out.println(longestRepeatingSubstring("abcd"));
        System.out.println(longestRepeatingSubstring("abbaba"));
        System.out.println(longestRepeatingSubstring("aabcaabdaab"));
    }
    public static int longestRepeatingSubstring(String input) {
        if(input==null || input.isEmpty()){
            return 0;
        }
        int max =0;
        HashSet<String> set =new HashSet<>();
        for(int len=1;len<=input.length();len++){
            for(int i=0;i<=input.length()-len;i++){
                String curr = input.substring(i,i+len);
                if(set.contains(curr)){
                    max = Math.max(max,curr.length());
                    break;
                }
                set.add(curr);
            }
        }
//        System.out.println(set);
        return max;
    }

}
