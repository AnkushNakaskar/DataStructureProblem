package com.example.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class FindMinArrowShots {

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{
                {10,16},{2,8},{1,6},{7,12}
        }));

        System.out.println(findMinArrowShots(new int[][]{
                {1,2},
                {3,4},
                {5,6},
                {7,8}
        }));
        System.out.println(findMinArrowShots(new int[][]{
                {-2147483646,-2147483645},
                {2147483646,2147483647}
        }));
    }

    public static int minArrows(int points[][])
    {
        // To sort our array according
        // to end position of balloons
        Arrays.sort(points,
                (a, b) -> Integer.compare(a[1], b[1]));

        // Initialize end variable with
        // the end of first balloon
        int end = points[0][1];

        // Initialize arrow with 1
        int arrow = 1;

        // Iterate through the entire
        // arrow of points
        for (int i = 1; i < points.length; i++) {

            // If the start of ith balloon
            // <= end than do nothing
            if (points[i][0] <= end) {
                continue;
            }

            // if start of the next balloon
            // >= end of the first balloon
            // then increment the arrow
            else {

                // Update the new end
                end = points[i][1];
                arrow++;
            }
        }

        // Return the total count of arrows
        return arrow;
    }

    public static int findMinArrowShots(int[][] nums) {
        if(nums==null || nums.length<=0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        Arrays.sort(nums,(a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> queue =new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        int[] prev =nums[0];
        int count =1;
        for(int i=1;i<nums.length;i++){
            int[] curr =nums[i];
            if(prev[1]>=curr[0]){
                continue;
            }else {
                count++;
                prev =curr;
            }
        }
        return count;
    }
}
