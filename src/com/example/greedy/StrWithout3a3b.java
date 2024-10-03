package com.example.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class StrWithout3a3b {

    public static void main(String[] args) {
        System.out.println(strWithout3a3b(4,1));
        System.out.println(strWithout3a3b(1,2));
        System.out.println(strWithout3a3b(3,7));
    }
    public static String strWithout3a3b(int a, int b) {
        Map<Character,Integer> map =new HashMap<>();
        map.put('a',a);
        map.put('b',b);
        PriorityQueue<Map.Entry<Character,Integer>> queue =new PriorityQueue<>((m,n)->{
            return n.getValue().compareTo(m.getValue());
        });
        queue.addAll(map.entrySet());
        StringBuilder sb =new StringBuilder();
        while(!queue.isEmpty()) {
            Map.Entry<Character, Integer> currEntry = queue.poll();
            if(sb.length()>1 && (sb.charAt(sb.length()-1)==sb.charAt(sb.length()-2) && currEntry.getKey() == sb.charAt(sb.length()-1))){
                Map.Entry<Character, Integer> newEntry = queue.poll();
                sb.append(newEntry.getKey());
                newEntry.setValue(newEntry.getValue()-1);
                if(newEntry.getValue()>0){
                    queue.add(newEntry);
                }
                queue.add(currEntry);
            }else{
                sb.append(currEntry.getKey());
                currEntry.setValue(currEntry.getValue()-1);
                if(currEntry.getValue()>0){
                    queue.add(currEntry);
                }
            }
        }
        return sb.toString();
    }
    public static String strWithout3a3bOld(int a, int b) {

        Map<Character,Integer> map =new HashMap<>();
        map.put('a',a);
        map.put('b',b);
        PriorityQueue<Map.Entry<Character,Integer>> queue =new PriorityQueue<>((m,n)->{
            return n.getValue().compareTo(m.getValue());
        });
        queue.addAll(map.entrySet());
        StringBuilder sb =new StringBuilder();
        while(!queue.isEmpty()){
            Map.Entry<Character, Integer> currEntry = queue.poll();
            if(sb.isEmpty()){

                if(currEntry.getValue()>1){
                    sb.append(currEntry.getKey());
                    sb.append(currEntry.getKey());
                    currEntry.setValue(currEntry.getValue()-1);
                    currEntry.setValue(currEntry.getValue()-1);
                }else{
                    sb.append(currEntry.getKey());
                    currEntry.setValue(currEntry.getValue()-1);
                }
                if(currEntry.getValue()!=0) {
                    queue.add(currEntry);
                }
            }else if(sb.length()>1){
                if(sb.charAt(sb.length()-1)==sb.charAt(sb.length()-2) && currEntry.getKey() == sb.charAt(sb.length()-1)){
                    Map.Entry<Character, Integer> newEntry = queue.poll();
                    if(newEntry.getValue()>1){
                        sb.append(newEntry.getKey());
                        sb.append(newEntry.getKey());
                        newEntry.setValue(newEntry.getValue()-1);
                        newEntry.setValue(newEntry.getValue()-1);
                    }else{
                        sb.append(newEntry.getKey());
                        newEntry.setValue(newEntry.getValue()-1);
                    }
                    if(newEntry.getValue()!=0) {
                        queue.add(newEntry);
                    }
                    queue.add(currEntry);
                }else{
                    if(currEntry.getValue()>1){
                        sb.append(currEntry.getKey());
                        sb.append(currEntry.getKey());
                        currEntry.setValue(currEntry.getValue()-1);
                        currEntry.setValue(currEntry.getValue()-1);
                    }else{
                        sb.append(currEntry.getKey());
                        currEntry.setValue(currEntry.getValue()-1);
                    }
                    if(currEntry.getValue()!=0) {
                        queue.add(currEntry);
                    }
                }
            }else{
                if(currEntry.getValue()>1){
                    sb.append(currEntry.getKey());
                    sb.append(currEntry.getKey());
                    currEntry.setValue(currEntry.getValue()-1);
                    currEntry.setValue(currEntry.getValue()-1);
                }else{
                    sb.append(currEntry.getKey());
                    currEntry.setValue(currEntry.getValue()-1);
                }
                if(currEntry.getValue()!=0) {
                    queue.add(currEntry);
                }
            }
        }
        return sb.toString();
    }
}
