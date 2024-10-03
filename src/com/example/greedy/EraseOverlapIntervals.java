package com.example.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class EraseOverlapIntervals {

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{
                {1,2},
                {2,3},
                {3,4}
        }));
        System.out.println(eraseOverlapIntervals(new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {1,3}
        }));
        System.out.println(eraseOverlapIntervals(new int[][]{
                {1,2},
                {1,2},
                {1,2}
        }));
        System.out.println(eraseOverlapIntervals(new int[][]{
                {1,2},
                {2,3},
        }));
        System.out.println(eraseOverlapIntervals(new int[][]{
                {0,2},{1,3},{1,3},{2,4},{3,5},{3,5},{4,6}
        }));
        System.out.println(eraseOverlapIntervals(new int[][]{
                {0,2},{1,3},{2,4},{3,5},{4,6}
        }));
        System.out.println(eraseOverlapIntervals(new int[][]{
                {1,100},{11,22},{1,11},{2,12}
        }));
//        [[0,2],[1,3],[1,3],[2,4],[3,5],[3,5],[4,6]]
    }
    public static int eraseOverlapIntervals(int[][] nums) {
        Arrays.sort(nums,(a,b)->{
            return a[0]-b[0];
        });
        PriorityQueue<int[]> queue =new PriorityQueue<>((a,b)->{
            return a[1]-b[1];

        });
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
        }
        int count =0;
        int[] prev = queue.poll();
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(curr[0]<prev[1] && prev[1]>curr[0]){
                count++;
            }else{
                prev[1]=curr[1];
            }
        }
        return count;
    }
}
