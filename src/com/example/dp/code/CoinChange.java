package com.example.dp.code;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class CoinChange {
    public static List<Integer> minValues;
    public static Set<List<Integer>> set;
    public static void main(String[] args) {
        System.out.println(coinChangeOld(new int[]{1,2,5},5));
//        System.out.println(coinChange(new int[]{1,2,5},11));
//        System.out.println(coinChange(new int[]{3,5},4));
//

//        System.out.println(coinChange(4));
//        System.out.println(coinChange(5));
//        System.out.println(coinChange(6));
//        System.out.println(coinChange(16));
    }

    public static int coinChange(int[] coins, int amount) {
        int[]dp= new int[amount+1];
        for(int i=1;i<=amount;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int coin : coins){
                if(coin<=i && dp[i-coin]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],1+dp[i-coin]);
                }
            }
        }
        return dp[amount]!=Integer.MAX_VALUE ? dp[amount]:-1;
    }
    public static int coinChangeOld(int[] coins, int amount) {
       int res =0;
        set =new HashSet<>();
        res =help(amount,coins,new ArrayList<Integer>());
        System.out.println(set);
       return res;
    }

    private static int help(int amount,int[] coins,ArrayList<Integer> list) {
        if(amount==0){
           set.add(new ArrayList<>(list));
           return 1;
        }
        int count=0;
        for(int i=0;i<coins.length;i++){

            if(amount>=coins[i]){
                list.add(coins[i]);
                count+=help(amount-coins[i], coins,list);
                list.remove(list.size()-1);
            }
        }
        return count;
    }

    public static int coinChange(int amount) {
        minValues =new LinkedList<>();
        minValues.add(Integer.MAX_VALUE);
        help(amount,0,0,0);
        return new ArrayList<>(minValues).get(0);
    }

    private static void help(int amount, int coin1, int coin2, int coin5) {
        if(amount==0){
            int min = Math.min(minValues.remove(0),coin1+coin2+coin5);
            minValues.add(min);
        }
        if(amount>=1){
            help(amount-1, coin1+1, coin2, coin5);
        }
        if(amount>=2){
            help(amount-2, coin1, coin2+1, coin5);
        }
        if(amount>=5){
            help(amount-5, coin1, coin2, coin5+1);
        }
    }
}
