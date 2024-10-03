package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class IntegerReplacement {

    public static int min ;

    public static void main(String[] args) {
        System.out.println(integerReplacement(8));
    }
    public static  int integerReplacement(int n) {
        if(n<=0){
            return 0;
        }

        return help(n);
    }
/*
Input: n = 8
Output: 3
Explanation: 8 -> 4 -> 2 -> 1
 */
    private static int help(int n) {
        if(n==Integer.MAX_VALUE)return 32;
        if(n==1){
            return 0;
        }
        if(n%2==0){
            return 1+ help(n/2);
        }
        return Math.min((1+help(n-1)),(1+help(n+1)));
    }
}
