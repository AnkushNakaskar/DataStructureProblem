package com.example.dp.code;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ankush.nakaskar
 */
public class LongestUnequalSubsequence {

    public static List<String> getLongestSubsequence(String[] words, int[] groups) {

        LinkedList<String> list =new LinkedList<>();
        list.add(words[0]);
        int prev= groups[0];
        for(int i=1;i<words.length;i++){
            if(groups[i]!=prev){
                prev=groups[i];
                list.add(words[i]);
            }
        }
        return list;

    }
}
