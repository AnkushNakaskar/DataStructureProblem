package com.example.dp.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ankush.nakaskar
 */
public class PaintHouse {
    public static Map<String,Integer> map;
//    Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
public static void main(String[] args) {
    map =new HashMap<>();
    System.out.println(minCost(new int[][]{
            {17,2,17},
            {16,16,5},
            {14,3,19}
    }));
    System.out.println(minCost(new int[][]{
            {3,5,3},
            {6,17,6},
            {7,13,18},
            {9,10,18}
    }));
//
    /*
            [
                [3,5,3],
                [6,17,6],
                [7,13,18],
                [9,10,18]
            ]
     */
}
        public static int minCost(int[][] nums) {
            if(nums==null || nums.length==0){
                return 0;
            }
            map =new HashMap<>();
           return help(nums,0,-1);
        }

    private static int help(int[][] nums, int index,int prevIndex) {
            if(index>= nums.length){
                return 0;
            }
            if(map.containsKey("" +index +"_"+prevIndex)){
                return map.get("" +index +"_"+prevIndex);
            }
            int min =Integer.MAX_VALUE-1000;
            for(int i=0;i<nums[index].length;i++){
                if(i==prevIndex)continue;
                min = Math.min(nums[index][i] + help(nums, index+1,i),min);
                map.put("" +index +"_"+prevIndex,min);
            }
        return min;
    }

}
