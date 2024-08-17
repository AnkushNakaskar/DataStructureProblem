package com.example.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class SortCharectorsByFrquency {
    public static void main(String[] args) {
        String input ="tree";
        sortChar(input);
    }

    private static void sortChar(String input) {
        if(input==null && input.isEmpty()){
            return;
        }
        Map<Character,Integer> countMap =new HashMap<>();
        for(int i=0;i<input.length();i++){
            char ch = input.charAt(i);
            countMap.put(ch,countMap.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> queue =new PriorityQueue<>((a,b) ->{
            return b.getValue().compareTo(a.getValue());
        });
        countMap.entrySet().forEach(keyset ->{
            queue.add(keyset);
        });
        StringBuilder sb =new StringBuilder();
        while(!queue.isEmpty()){
            Map.Entry<Character, Integer> entrySet = queue.poll();
            for(int i=0;i< entrySet.getValue();i++){
                sb.append(entrySet.getKey());
            }
        }
        System.out.println(sb.toString());
    }
}
