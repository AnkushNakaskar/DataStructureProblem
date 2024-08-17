package com.example.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 * https://leetcode.com/problems/meeting-rooms-ii/solutions/1216777/super-easy-java-solution-with-explanation/
 */
public class MinMeetingRooms {
    public static void main(String[] args) {

        System.out.println(minMeetingRooms(new int[][]{
                {0,30},
                {5,10},
                {15,20}
        }));
        System.out.println(minMeetingRooms(new int[][]{
                {5,8},
                {6,8}
        }));
        System.out.println(minMeetingRooms(new int[][]{
                {1,5},
                {8,9},
                {8,9}
        }));

        System.out.println(minMeetingRooms(new int[][]{
                {6,15},
                {13,20},
                {6,17}
        }));

        System.out.println(minMeetingRooms(new int[][]{
                {1,13},
                {13,17}
        }));

        System.out.println(minMeetingRooms(new int[][]{
                {9,10},
                {4,9},
                {4,17}

        }));
        System.out.println(minMeetingRooms(new int[][]{
                {2,11},
                {6,16},
                {11,16}

        }));
        System.out.println(minMeetingRooms(new int[][]{
                {13,15},
                {1,13}
        }));
    }

    public static int minMeetingRooms(int[][] nums){

        if(nums==null || nums.length<1){
            return 0;
        }

        Arrays.sort(nums , (a,b) ->{
            return a[0]-b[0];
        });
        PriorityQueue<int[]> queue =new PriorityQueue<>((a,b) ->{
            return a[1]-b[1];
        });
        for(int i=0;i<nums.length;i++){
            if(!queue.isEmpty() && queue.peek()[1]<=nums[i][0]){
                queue.poll();
            }
            queue.add(nums[i]);
        }
        return queue.size();
    }














    public static int minMeetingRoomsRunning(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);

        for(int[] arr:intervals){
            if(pq.isEmpty()) pq.add(arr);
            else{
                if(pq.peek()[1]<=arr[0]){
                    pq.poll();
                }
                pq.offer(arr);
            }
        }
        return pq.size();
    }

    public static int minMeetingRoomsOld(int[][] nums) {
        int min =Integer.MAX_VALUE;
        int count=1;
        PriorityQueue<int[]> queue =new PriorityQueue<>((a,b) ->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            if(b[1]==a[1]){
                return b[0]-a[0];
            }
           return a[0] - b[0];
        });
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
        }
        int[] prev =queue.poll();
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currValue = curr[0];
            int betw1 = prev[0];
            int betw2 = prev[1];
            if(currValue==betw2){
                int[] tmp =new int[]{Math.min(prev[0],curr[0]),Math.min(prev[1],curr[1])};
                prev=tmp;
                continue;
            }
            if(currValue>= betw1 && currValue<=betw2){
                count++;
            }else {
                prev=curr;
                continue;
            }
            prev=curr;
        }
        return Math.min(min,count);
    }
}
