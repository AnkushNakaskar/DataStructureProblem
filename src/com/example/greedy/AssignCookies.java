package com.example.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class AssignCookies {
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1,2},new int[]{1,2,3}));
        System.out.println(findContentChildren(new int[]{1,2,3},new int[]{1,1}));
        System.out.println(findContentChildren(new int[]{1,2,3},new int[]{3}));
    }

    public static int findContentChildren(int[] g, int[] s) {


        Arrays.sort(g);
        PriorityQueue<Integer> queue =new PriorityQueue<>((a,b)->{
            return b.compareTo(a);
        });
        for(int val : s){
            queue.add(val);
        }
        int count=0;
        for(int i=g.length-1;i>=0 && !queue.isEmpty();i--){
            int childGrid = g[i];
            int size = queue.peek();
            if(size>=childGrid){
                queue.poll();
                count++;
            }
        }
        return count;
    }
}
