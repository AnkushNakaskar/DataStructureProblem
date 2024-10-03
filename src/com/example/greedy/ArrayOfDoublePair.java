package com.example.greedy;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class ArrayOfDoublePair {

    public static void main(String[] args) {
//        int val = -5;
//        System.out.println(val%2);
        System.out.println(canReorderDoubled(new int[]{-3,-4,2,6}));
        System.out.println(canReorderDoubled(new int[]{-33,0}));
        System.out.println(canReorderDoubled(new int[]{2,4,0,0,8,1}));
        System.out.println(canReorderDoubled(new int[]{2,1,2,6}));
        System.out.println(canReorderDoubled(new int[]{4,-2,2,-4}));
        System.out.println(canReorderDoubled(new int[]{3,1,3,6}));
    }
    public static boolean canReorderDoubled(int[] nums){
        Map<Integer, TreeSet<Integer>> map =new HashMap<>();
        Arrays.sort(nums);
        for(int i=0;i< nums.length;i++){
            int curr = nums[i];
            TreeSet<Integer> list = map.getOrDefault(curr, new TreeSet<>());
            list.add(i);
            map.put(curr,list);

        }
        boolean[] visisted =new boolean[nums.length];
        for(int i=0;i< nums.length;i++){

            if(visisted[i]){
                continue;
            }
            int curr = nums[i];
            if(!map.containsKey(curr) || map.get(curr).isEmpty()){
                return false;
            }

            if(curr==0){
                if(map.get(curr).size()<=1){
                    return false;
                }
                visisted[map.get(curr).pollFirst()]=true;
                visisted[map.get(curr).pollFirst()]=true;
            }else if(curr<0){
                if(curr%2!=0){
                    return false;
                }
                int valueToCheck = curr/2;
                if(map.containsKey(valueToCheck) && !map.get(valueToCheck).isEmpty()){
                    visisted[map.get(curr).pollFirst()]=true;
                    visisted[map.get(valueToCheck).pollFirst()]=true;
                }
            }else{
                int valueToCheck = curr*2;
                if(map.containsKey(valueToCheck) && !map.get(valueToCheck).isEmpty()){
                    visisted[map.get(curr).pollFirst()]=true;
                    visisted[map.get(valueToCheck).pollFirst()]=true;
                }
            }
        }
        return !map.values().stream().filter(e -> !e.isEmpty()).findAny().isPresent();
    }
    public static boolean canReorderDoubledOld(int[] nums) {

        HashMap<Integer,Integer> map =new HashMap<>();
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }

        for(int i=0;i< nums.length;i++){
            if(map.isEmpty()){
                return true;
            }else{
                int curr = nums[i];
                if(map.containsKey(2*curr)){
                    if(map.get(curr)>1){
                        map.put(curr,map.get(curr)-1);
                    }else{
                        map.remove(curr);
                    }
                    if(map.get(2*curr)>1){
                        map.put(2*curr,map.get(2*curr)-1);
                    }else{
                        map.remove(2*curr);
                    }
                }else if(curr%2==0 && map.containsKey(curr/2)){
                    if(map.get(curr)>1){
                        map.put(curr,map.get(curr)-1);
                    }else{
                        map.remove(curr);
                    }
                    if(map.get(curr/2)>1){
                        map.put(curr/2,map.get(2*curr)-1);
                    }else{
                        map.remove(curr/2);
                    }
                }else{
                    return false;
                }
            }
        }
        return map.isEmpty();
    }


}
