package com.example.dp.code;

import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class SuperUglyNumber {

    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(12,new int[]{
                2,7,13,19
        }));
    }
    public static int nthSuperUglyNumber(int n, int[] nums) {
        PriorityQueue<Integer> queue =new PriorityQueue<>();
        queue.add(1);
        int count=1;
        while(count<n){
            int qVal = queue.poll();
            while(!queue.isEmpty() && queue.peek()==qVal){
                queue.poll();
            }
            count++;
            for(int i=0;i<nums.length;i++){
                queue.add(qVal * nums[i]);
            }
        }
        return queue.peek();
    }
}
