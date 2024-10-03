package com.example.dp.code;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ankush.nakaskar
 */
public class WrappAroundString {

    public static void main(String[] args) {
        System.out.println(findSubstringInWraproundString("zab"));
        System.out.println(findSubstringInWraproundString("aabb"));

        System.out.println(findSubstringInWraproundString("cac"));
        System.out.println(findSubstringInWraproundString("abaab"));
        System.out.println(findSubstringInWraproundString("aabb"));



    }

    /*
        1 2 3
     */
    public static int findSubstringInWraproundString(String input) {
        if(input==null || input.length()==0){
            return 0;
        }
        Set<String> set =new HashSet<>();
        int[] dp =new int[input.length()];
        for(int i=0;i<input.length();i++){
            if(!set.contains(input.substring(i,i+1)))
                dp[i]=1;
            set.add(input.substring(i,i+1));
            for(int j=i;j>0;j--){

                String subString = input.substring(j-1,i+1);
                int leftVal = input.charAt(j-1)%26;
                int rightVal =(input.charAt(j)%26);
                if(leftVal+1 == (rightVal)) {
                    if(!set.contains(subString)){
                        dp[i] = dp[i]+1;
                        set.add(subString);
                    }
                }else if(input.charAt(j)=='a' && input.charAt(j-1)=='z'){
                    if(!set.contains(subString)){
                        dp[i] = dp[i]+1;
                        set.add(subString);
                    }

                }else{
                    break;
                }

            }
        }
        int sum =0;
        for(int val : dp){
            sum+=val;
        }
        return sum;
    }
}
