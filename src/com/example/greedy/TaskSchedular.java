package com.example.greedy;

import java.util.Arrays;

/**
 * @author ankush.nakaskar
 */
public class TaskSchedular {
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A','A','B','B','C','C'},1));
    }
    public static int leastInterval(char[] tasks, int n) {
        int[] freq =new int[26];
        for(char ch : tasks){
            freq[ch-'A']++;
        }
        Arrays.sort(freq);
        int max =freq[25]-1;
        int spaces = max*n;
        for(int i=24;i>=0;i--){
            spaces-=Math.min(max,freq[i]);
        }
        spaces =Math.max(spaces,0);
        return tasks.length+spaces;

    }
}
