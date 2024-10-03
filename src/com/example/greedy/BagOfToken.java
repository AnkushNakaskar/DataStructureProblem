package com.example.greedy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ankush.nakaskar
 */
public class BagOfToken {

    public static void main(String[] args) {
        System.out.println(bagOfTokensScore(new int[]{91,4,75,70,66,71,91,64,37,54},20));
        System.out.println(bagOfTokensScore(new int[]{33,4,28,24,96},35));
        System.out.println(bagOfTokensScore(new int[]{100,200,300,400},200));
        System.out.println(bagOfTokensScore(new int[]{200,100},150));
        System.out.println(bagOfTokensScore(new int[]{100},50));
    }
    public static int bagOfTokensScore(int[] tokens, int power) {
        int score =0;

        Queue<Integer> queue = new ArrayDeque<>();
        Arrays.sort(tokens);
        for(int val : tokens){
            queue.add(val);
        }
        int remainingCount=tokens.length;
        boolean[] visited = new boolean[tokens.length];
        boolean isPlayable =power>0 || score>0;

        while(isPlayable){
            boolean isPlayed =false;
            for(int i=0;i<tokens.length;i++){
                if( !visited[i] && power>=tokens[i]){
                    visited[i]=true;
                    score = score+1;
                    power = power-tokens[i];
                    isPlayed=true;
                    remainingCount--;
                }
            }
            for(int i=tokens.length-1;i>=0 && score>0;i--){
                if(remainingCount>1 && !visited[i]){
                    power = power+ tokens[i];
                    score= score-1;
                    isPlayed=true;
                    visited[i]=true;
                    remainingCount--;
                    break;
                }
            }
            if(!isPlayed){
                break;
            }
            isPlayable =power>0 || score>0;

        }

        return score;
    }
}
