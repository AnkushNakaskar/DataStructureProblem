package com.example.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class FindLongestChain {

    public static void main(String[] args) {

        System.out.println(findLongestChain(new int[][]{
                {-10,-8},
                {8,9},
                {-5,0},
                {6,10},
                {-6,-4},
                {1,7},
                {9,10},
                {-4,7}
        }));
        System.out.println(findLongestChain(new int[][]{
                {1,2},
                {2,3},
                {3,4}
        }));
        System.out.println(findLongestChain(new int[][]{
                {1,2},
                {7,8},
                {4,5}
        }));
        System.out.println(findLongestChain(new int[][]{
                {8,9},
                {6,10},
                {1,7}
        }));
    }
    public static int findLongestChain(int[][] nums) {
       Arrays.sort(nums,(a,b)->{
           return a[1]-b[1];
       });
       int max =0;
       for(int i=0;i< nums.length;i++){
           int[] prev = nums[i];
           int tmp =1;
           for(int j=i+1;j< nums.length;j++){
               int[] curr = nums[j];
               if(curr[0]>prev[1]){
                   tmp++;
                   prev=curr;
               }
           }
           max = Math.max(max,tmp);
       }
       return max;

    }
    public static int findLongestChainOld(int[][] nums) {
        PriorityQueue<int[]> queue =new PriorityQueue<>((a,b) ->{
            return a[1]-b[1];
        });
        for(int[] val : nums){
            queue.add(val);
        }
        int count=0;
        while(!queue.isEmpty()){
            int[] prev = queue.poll();
            while(!queue.isEmpty() && queue.peek()[0]>=prev[0] && queue.peek()[0]<=prev[1]){
                queue.poll();
            }
            count++;
        }
        return count;

    }


}
