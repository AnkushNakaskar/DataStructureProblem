package com.example.dp.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ankush.nakaskar
 */
public class Tribonacci {

    public static Map<Integer,Integer> map;
    public static void main(String[] args) {
        System.out.println(tribonacci(2));
        System.out.println(tribonacci(3));
        System.out.println(tribonacci(4));
    }

    public static int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        map =new HashMap<>();
        return help(n);
    }

    private static int help(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        int val = help(n-1)+help(n-2)+help(n-3);
        map.put(n,val);
        return map.get(n);
    }
}
