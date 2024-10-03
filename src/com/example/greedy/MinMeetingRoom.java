package com.example.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class MinMeetingRoom {
    public static void main(String[] args) {

        System.out.println(minMeetingRooms(new int[][]{
                {8,9},
                {6,10},
                {1,7}
        }));
        System.out.println(minMeetingRooms(new int[][]{
                {1,2},
                {3,4},
                {5,7}
        }));

        System.out.println(minMeetingRooms(new int[][]{

                {5,8},
                {6,8}
        }));
        System.out.println(minMeetingRooms(new int[][]{

                {13,15},
                {1,13},
                {6,9}
        }));
        System.out.println(minMeetingRooms(new int[][]{
                {0,30},
                {5,10},
                {15,20}
        }));
    }
    public static int OverlapIntervals(int[][] nums) {
        Arrays.sort(nums,(a,b)->{
            return a[0]-b[0];
        });
        PriorityQueue<int[]> queue =new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }

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
    public static int minMeetingRooms(int[][] nums) {
        Arrays.sort(nums,(a,b)->{
            return a[0]-b[0];
        });
        PriorityQueue<int[]> queue =new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        for(int i=0;i< nums.length;i++){
            if(!queue.isEmpty() && queue.peek()[1]<=nums[i][0]){
                queue.poll();
            }
            queue.add(nums[i]);
        }
        return queue.size();
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
}
