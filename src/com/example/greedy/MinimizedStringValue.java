package com.example.greedy;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class MinimizedStringValue {

    public static void main(String[] args) {

        System.out.println(minimizeStringValue("g?xvgroui??xk?zqb?da?jan?cdhtksme"));
        System.out.println(minimizeStringValue("eq?umjlasi"));
        System.out.println(minimizeStringValue("abcdefghijklmnopqrstuvwxy??"));
        System.out.println(minimizeStringValue("???"));
        System.out.println(minimizeStringValue("a?a?"));
        System.out.println(minimizeStringValue("a?b?"));
    }
    public static  String minimizeStringValue(String s) {
        int[] charArr = new int[26];

        for(int i=0;i<s.length();i++){
            Character currChar = s.charAt(i);
            if(currChar=='?'){
                continue;
            }
            charArr[currChar-'a']++;
        }
        StringBuilder sb =new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='?'){
                int minVal = charArr[0];
                int index =0;
                for(int j=1;j<26;j++){
                    if(minVal>charArr[j]){
                        index=j;
                        minVal = charArr[j];
                    }
                }
                char minChar =(char) ('a'+index);
                charArr[index]++;
                tmp.append(minChar);
            }
        }
        char[] replace = tmp.toString().toCharArray();
        Arrays.sort(replace);
        int a =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='?'){
                sb.append(replace[a++]);
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static  String minimizeStringValueOld(String s) {

       int[] charArr = new int[26];

       for(int i=0;i<s.length();i++){
           Character currChar = s.charAt(i);
           if(currChar=='?'){
               continue;
           }
           charArr[currChar-'a']++;
       }

        StringBuilder sb =new StringBuilder();
        for(int i=0;i<s.length();i++){
            Character currChar = s.charAt(i);
            if(currChar=='?'){
                StringBuilder tmp = new StringBuilder();
                while(i<s.length() && s.charAt(i)=='?'){
                    int minVal = charArr[0];
                    int index =0;
                    for(int j=1;j<26;j++){
                        if(minVal>charArr[j]){
                            index=j;
                            minVal = charArr[j];
                        }
                    }
                    char minChar =(char) ('a'+index);
                    tmp.append(minChar);
                    charArr[index]++;
                    i++;
                }
                i--;
                char[] replace = tmp.toString().toCharArray();
                Arrays.sort(replace);
                sb.append(new String(replace));

            }else{
                sb.append(currChar);
            }
        }
        return sb.toString();
    }
}
