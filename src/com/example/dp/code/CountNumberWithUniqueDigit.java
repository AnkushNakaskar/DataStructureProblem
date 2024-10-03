package com.example.dp.code;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ankush.nakaskar
 */
public class CountNumberWithUniqueDigit {

    public static void main(String[] args) {
        Set<Integer> set =new HashSet<>();
        for(int i=1000;i<2000;i++){
            String str =""+i;
            Set<Character> tmp =new HashSet<>();
            tmp.add(str.charAt(0));
            tmp.add(str.charAt(1));
            tmp.add(str.charAt(2));
            tmp.add(str.charAt(3));
            if(tmp.size()<4)continue;

            set.add(i);
        }

        int[] dp =new int[9];
        dp[0]=1;
        for(int i=1;i<8;i++){
            dp[i]=1;
            int val =dp[i];
            for(int j=i;j>0;j--){
                val =val*(9-(i-j));
            }
            dp[i]=val;
        }
        for(int i=0;i<dp.length;i++){
            dp[i]*=9;
        }

        System.out.println((8*9*9 + 9*9 +9*1+1));
        System.out.println(set.size());
        System.out.println(set);
//        System.out.println(countNumbersWithUniqueDigits(0));
//        System.out.println(countNumbersWithUniqueDigits(1));
        System.out.println(countNumbersWithUniqueDigits(2));
        System.out.println(countNumbersWithUniqueDigits(3));

    }

    public static int countNumbersWithUniqueDigits(int n) {
        if(n==0){
            return 1;
        }
        if(n==1){
            return 10;
        }
        int[] dp =new int[9];
        dp[0]=1;
        for(int i=1;i<8;i++){
            dp[i]=1;
            int val =dp[i];
            for(int j=i;j>0;j--){
                val =val*(9-(i-j));
            }
            dp[i]=val;
        }
        for(int i=0;i<dp.length;i++){
            dp[i]*=9;
        }
        int sum =1;
        for(int i=0;i<n;i++){
            sum+=dp[i];
        }

        return sum;
    }
}
