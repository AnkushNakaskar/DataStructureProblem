package com.example.dp.code;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class CoinChange2 {

    public static Set<List<Integer>> set ;
    public static void main(String[] args) {
        System.out.println(change(5,new int[]{1,2,5}));
//        System.out.println(change(3,new int[]{5}));
//        System.out.println(change(3,new int[]{3}));
    }

    public static int change(int amount, int[] coins) {
        set =new HashSet<>();
        help(amount,coins,0,new LinkedList<>());
        return set.size();
    }

    private static void help(int amount, int[] coins, int index, LinkedList<Integer> list) {
        if(amount==0){
            Collections.sort(list);
            set.add(new ArrayList<>(list));
        }
        if(amount>0){
            for(int i=0;i<coins.length;i++){
                if(amount>=coins[i]){
                    list.add(new Integer(coins[i]));
                    help(amount-coins[i], coins, i, list);
                    list.remove(new Integer(coins[i]));
                }
            }
        }
    }
}
