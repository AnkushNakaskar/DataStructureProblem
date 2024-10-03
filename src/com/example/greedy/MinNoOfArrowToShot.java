package com.example.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class MinNoOfArrowToShot {

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{
                {9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}
        }));
        System.out.println(findMinArrowShots(new int[][]{
                {1,2},{4,5},{1,5}
        }));
        System.out.println(findMinArrowShots(new int[][]{
                {10,16},{2,8},{1,6},{7,12}
        }));
        System.out.println(findMinArrowShots(new int[][]{
                {13,16},{1,2},{3,6},{7,12}
        }));
        System.out.println(findMinArrowShots(new int[][]{
                {1,2},{2,3},{3,4},{4,5}
        }));
    }
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum =0;
        for(int i=0;i<nums.length;i=i+2){
            sum+=nums[i];
        }
        return sum;
    }

    public static int findMinArrowShots(int[][] nums) {
        Arrays.sort(nums,(a,b) ->{
            return a[0]-b[0];
        });
        int count=0;
        PriorityQueue<int[]> queue =new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
       for(int i=0;i< nums.length;i++){
           queue.add(nums[i]);
       }
//       int[] prev = queue.poll();

       while(!queue.isEmpty()){
//           {1,2},{4,5},{1,5}
           int[] prev = queue.poll();
           while(!queue.isEmpty() && (queue.peek()[0]<=prev[1] && prev[1]<=queue.peek()[1])){
               queue.poll();
           }
           count++;
       }
        return count;
    }

    public static int findMinArrowShotsOld(int[][] nums) {
        Arrays.sort(nums,(a,b) ->{
            return a[0]-b[0];
        });
        int count=0;
        PriorityQueue<int[]> queue =new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        for(int i=0;i< nums.length;i++){
            while(!queue.isEmpty() && queue.peek()[1]<=nums[i][0]){
                queue.poll();
            }
            count++;
        }
        return count;


    }
}
