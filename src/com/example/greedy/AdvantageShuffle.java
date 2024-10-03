package com.example.greedy;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class AdvantageShuffle {

    public static void main(String[] args) {
//        TreeMap<Integer,Integer> map =new TreeMap<>();
//        map.put(8,8);
//        System.out.println(map.higherKey(9));
        System.out.println(advantageCount(new int[]{12,24,8,32},new int[]{13,25,32,11}));
        System.out.println(advantageCount(new int[]{2,7,11,15},new int[]{1,10,4,11}));
    }
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int[] originalNum2 = Arrays.copyOf(nums2,nums2.length);
        Arrays.sort(nums2);
        TreeMap<Integer,Integer> treeMap =new TreeMap<>();
        for(int val : nums1){
            treeMap.put(val,treeMap.getOrDefault(val,0)+1);
        }
        HashMap<Integer,List<Integer>> map =new HashMap<>();
        for(int i=0;i< nums1.length;i++){
            int num2Val = nums2[i];
            if(!treeMap.isEmpty()){
                if(!map.containsKey(num2Val)){
                    map.put(num2Val,new LinkedList<>());
                }
                Integer mapValued = treeMap.higherKey(num2Val);
                if(mapValued==null){
                    mapValued = treeMap.firstKey();
                }
                if(treeMap.containsKey(mapValued)){
                    if(treeMap.get(mapValued)>1){
                        treeMap.put(mapValued,treeMap.get(mapValued)-1);
                    }else{
                        treeMap.remove(mapValued);
                    }
                }
                map.get(num2Val).add(mapValued);
            }

        }
        int[] res =new int[originalNum2.length];
        for(int i=0;i< originalNum2.length;i++){
            int currVal = originalNum2[i];
            if(map.containsKey(currVal)){
                if(!map.get(currVal).isEmpty()){
                    res[i]=map.get(currVal).remove(0);
                }
            }
        }
        return res;

    }
}
