package com.example.greedy;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ankush.nakaskar
 */
public class PartitionLabel {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("eccbbbbdec"));
        System.out.println(partitionLabels("abcdef"));
        System.out.println(partitionLabels("aaaaa"));
    }
    public static List<Integer> partitionLabels(String input) {
        List<Integer> list =new LinkedList<>();
        int[] lastIndexChar =new int[26];
        for(int i=0;i<input.length();i++){
            char ch = input.charAt(i);
            lastIndexChar[ch-'a']=i;
        }
        for(int i=0;i<input.length();i++){
            char ch = input.charAt(i);
            int currMaxIndex = lastIndexChar[ch-'a'];
            int leftIndex =i;
            while(i<input.length() && i<currMaxIndex){
                char tmpCh = input.charAt(i);
                if(lastIndexChar[tmpCh-'a']<=currMaxIndex){
                    i++;
                    continue;
                }else{
                    currMaxIndex = lastIndexChar[tmpCh-'a'];
                    i++;
                }
            }
            int diff = currMaxIndex-leftIndex+1;
            list.add(diff);
        }
        return list;
    }
}
