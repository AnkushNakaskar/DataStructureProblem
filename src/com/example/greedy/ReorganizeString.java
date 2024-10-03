package com.example.greedy;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class ReorganizeString {

    public static void main(String[] args) {
//        System.out.println(reorganizeString("aaaabbbb"));
//        System.out.println(reorganizeString("aaaabbbbcc"));
//        System.out.println(reorganizeString("aaaabbbbccc"));
//        System.out.println(reorganizeString("aaabbbcc"));
//        System.out.println(reorganizeString("aaabbbccccc"));

        System.out.println(reorganizeString("kkkkzrkatkwpkkkktrq"));
//        System.out.println(reorganizeString("aab"));
//        System.out.println(reorganizeString("bfrbs"));
    }
    public static String reorganizeString(String input) {
        Map<Character,Integer> map =new HashMap<>();
        for(char ch : input.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> queue =new PriorityQueue<>((a,b)->{
            return b.getValue().compareTo(a.getValue());
        });
        Queue<Character> singleQueue =new ArrayDeque<>();
        for(Map.Entry<Character,Integer> val : map.entrySet()){
            if(val.getValue()==1){
                singleQueue.add(val.getKey());
            }else{
                queue.add(val);
            }
        }
//        StringBuilder sb = new StringBuilder();
        ArrayList<Character> list =new ArrayList<>();
        while(!queue.isEmpty()){
            if(list.isEmpty()){
                Map.Entry<Character, Integer> entry = queue.poll();
                list.add(entry.getKey());
                if(entry.getValue()>1){
                    entry.setValue(entry.getValue()-1);
                    queue.add(entry);
                }
            }else{
                Map.Entry<Character, Integer> entry = queue.poll();
                if(list.get(list.size()-1) == entry.getKey()){
                    if(list.get(0)==entry.getKey()){
                        if(!queue.isEmpty()){
                            Map.Entry<Character, Integer> newEntry = queue.poll();
                            list.add(newEntry.getKey());
                            if(newEntry.getValue()>1){
                                newEntry.setValue(newEntry.getValue()-1);
                                queue.add(newEntry);
                            }
                            queue.add(entry);
                        }else if(!singleQueue.isEmpty()){
                            list.add(singleQueue.poll());
                            queue.add(entry);
                        }else{
                            return "";
                        }
                    }else{
                        list.add(0,entry.getKey());
                        if(entry.getValue()>1){
                            entry.setValue(entry.getValue()-1);
                            queue.add(entry);
                        }
                    }

                }else{
                    list.add(entry.getKey());
                    if(entry.getValue()>1){
                        entry.setValue(entry.getValue()-1);
                        queue.add(entry);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character ch : list){
            sb.append(ch);
        }
        for(Character ch : singleQueue){
            sb.append(ch);
        }

//        System.out.println(" Size :  "+ input.length() + " : "+sb.length());
//        if(sb.length()!=input.length()){
//            return "";
//        }
        return sb.toString();
    }
}
