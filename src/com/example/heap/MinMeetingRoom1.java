package com.example.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class MinMeetingRoom1 {

    public static void main(String[] args) {

        System.out.println(minMeetingRooms(new int[][]{
                {2,11},{6,16},{11,16}
        }));

        System.out.println(canAttendMeetings(new int[][]{
                {0,30},{5,10},{15,20}
        }));

        System.out.println(canAttendMeetings(new int[][]{
                {7,10},{2,4}
        }));

        System.out.println(canAttendMeetings(new int[][]{
                {5,8},{6,8}
        }));
        System.out.println(canAttendMeetings(new int[][]{
                {13,17},{1,13}
        }));
        System.out.println(canAttendMeetings(new int[][]{
                {0,30},{60,240},{90,120}
        }));
        System.out.println(canAttendMeetings(new int[][]{
                {8,11},{17,20},{17,20}
        }));
//        [0,30],[60,240],[90,120]
//        [8,11],[17,20],[17,20]
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

    public static int minAttendMeetings(int[][] nums) {

        int res =1;
        Arrays.sort(nums,(a,b)->{
            return a[1]-b[1];
        });
        for(int i=1;i< nums.length;i++){
            int[] prev = nums[i-1];
            int[] curr = nums[i];
            if(prev[1]<=curr[0]){
                continue;
            }else{
                res++;
            }
        }
        return res;

    }
    public static boolean canAttendMeetings(int[][] nums) {

        boolean res =true;
        Arrays.sort(nums,(a,b)->{
            return a[1]-b[1];
        });
        for(int i=1;i< nums.length;i++){
            int[] prev = nums[i-1];
            int[] curr = nums[i];
            if(prev[1]<=curr[0]){
                continue;
            }else{
                return false;
            }
        }
        return res;

    }
    public static boolean canAttendMeetingsOld(int[][] nums) {
        if(nums ==null|| nums.length<=1){
            return true;
        }
        Arrays.sort(nums, (a,b)->{
            return a[0]-b[0];
        });
        boolean canAttend =true;
        PriorityQueue<int[]> queue =new PriorityQueue<>((a,b) -> {
            return a[0]-b[0];
        });
       for(int i=0;i<nums.length;i++){
           if(!queue.isEmpty()){
               int[] peek = queue.peek();
               if(peek[1]<=nums[i][0]){
                   queue.poll();
               }
           }
           queue.add(nums[i]);
       }
       if(!queue.isEmpty()) queue.poll();
        return queue.isEmpty();
    }
}
