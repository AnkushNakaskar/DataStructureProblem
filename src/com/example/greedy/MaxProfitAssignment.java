package com.example.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author ankush.nakaskar
 */
public class MaxProfitAssignment {

    public static void main(String[] args) {
        System.out.println(maxProfitAssignment(new int[]{2,4,6,8,10},new int[]{10,20,30,40,50},new int[]{4,5,6,7}));
        System.out.println(maxProfitAssignment(new int[]{85,47,57},new int[]{24,66,99},new int[]{40,25,25}));
        System.out.println(maxProfitAssignment(new int[]{68,35,52,47,86},new int[]{67,17,1,81,3},new int[]{92,10,85,84,82}));
    }
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int sum=0;
        PriorityQueue<int[]> queue =new PriorityQueue<>((a,b) ->{
            return b[1]-a[1];
        });
        for(int i=0;i< difficulty.length;i++){
            queue.add(new int[]{difficulty[i],profit[i]});
        }
        Arrays.sort(worker);
        for(int i= worker.length-1;i>=0;i--){
            while(!queue.isEmpty() && queue.peek()[0]>worker[i]){
                queue.poll();
            }
            if(!queue.isEmpty()){
                sum+=queue.peek()[1];
            }
        }
        return sum;
    }

}
