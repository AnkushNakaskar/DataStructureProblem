package com.example.greedy;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class BoatToSavePeople {

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3,2,3,2,2},6));
        System.out.println(numRescueBoats(new int[]{2,2},6));
        System.out.println(numRescueBoats(new int[]{3,5,3,4},5));
        System.out.println(numRescueBoats(new int[]{3,2,2,1},3));
    }
    public static int numRescueBoats(int[] nums, int limit) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        int count =0;
        for(int i=nums.length-1;i>=0;i--){
            int currLimit = limit;
            int curr = nums[i];
            if(visited[i]){
                continue;
            }
            visited[i]=true;
            currLimit = currLimit-curr;
            for(int j=0;j<i;j++){
                int oneMorePerson = nums[j];
                if(currLimit<oneMorePerson){
                    break;
                }
                if(!visited[j] && oneMorePerson<=currLimit){
                    visited[j]=true;
                    currLimit=currLimit-oneMorePerson;
                    break;
                }
            }
            count++;
        }
        return count;
    }
    public static int numRescueBoatsOld(int[] nums, int limit) {
        HashMap<Integer, TreeSet<Integer>> map =new HashMap<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            if(!map.containsKey(val)){
                map.put(val,new TreeSet<>());
            }
            map.get(val).add(i);
        }
        int count =0;
        boolean[] visited = new boolean[nums.length];
        int currLimit = limit;
        for(int i=nums.length-1;i>=0;i--){
            int curr = nums[i];
            if(visited[i]){
                continue;
            }
            count++;
            visited[i]=true;
            currLimit = currLimit-curr;

        }
        return count;

    }
}
