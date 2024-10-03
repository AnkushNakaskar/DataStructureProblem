package com.example.greedy;

import java.util.HashMap;

/**
 * @author ankush.nakaskar
 */
public class NumRabbits {

    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{
                1,0,1,0,0
        }));
        System.out.println(numRabbits(new int[]{
                1,1,2
        }));
        System.out.println(numRabbits(new int[]{
                10,10,10
        }));

    }
    public static int numRabbits(int[] nums) {
        int res =0;
        HashMap<Integer,Integer> map =new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            if(map.containsKey(curr)){
                map.put(curr,map.get(curr)-1);
                if(map.get(curr)<=0){
                    map.remove(curr);
                }
                continue;
            }else{
                res = res+nums[i]+1;
                if(curr!=0)
                    map.put(curr,curr);
            }
        }
        return res;
    }
}
