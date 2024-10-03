package com.example.greedy;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ankush.nakaskar
 */
public class HandOFStraight {

    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8},3));
        System.out.println(isNStraightHand(new int[]{1,2,3,4,5},4));
    }
    public static boolean isNStraightHand(int[] nums, int groupSize) {
        if(nums.length%groupSize!=0){
            return false;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        while(!map.isEmpty()){
            for(int i=1;i<groupSize;i++){
                if(map.size()>1){
                    Map.Entry<Integer, Integer> prevEntry = map.pollFirstEntry();
                    Map.Entry<Integer, Integer> currEntry = map.pollFirstEntry();
                    if(prevEntry.getKey()+1 != currEntry.getKey()){
                        return false;
                    }else{
                        if(prevEntry.getValue()>1){
                            map.put(prevEntry.getKey(), prevEntry.getValue()-1);
                        }
                        map.put(currEntry.getKey(), currEntry.getValue());
                    }

                }else{
                    return false;
                }

            }
            Map.Entry<Integer, Integer> lastEntry = map.pollFirstEntry();
            if(lastEntry.getValue()>1){
                map.put(lastEntry.getKey(), lastEntry.getValue()-1);
            }

        }
        return true;
    }

}
