package com.example.heap;

import java.util.*;

/**
 * @author ankush.nakaskar
 */

public class PointThatIntersectWithCar {

    public static void main(String[] args) {
        List<List<Integer>> nums =new ArrayList<>();
        nums.add(Arrays.asList(3,6));
        nums.add(Arrays.asList(1,5));
        nums.add(Arrays.asList(4,7));
        System.out.println(numberOfPoints(nums));
    }

    public static int numberOfPoints(List<List<Integer>> nums) {
        if(nums==null || nums.isEmpty()){
            return 0;
        }
        int res =0;

        Collections.sort(nums,(a,b) ->{
            return a.get(0)-b.get(0);
        });
        TreeSet<Integer> set =new TreeSet<>();
        for(int i=0;i<nums.size();i++){
            for(int j=nums.get(i).get(0);j<=nums.get(i).get(1);j++){
                set.add(j);
            }
        }

        return set.size();
    }
}
