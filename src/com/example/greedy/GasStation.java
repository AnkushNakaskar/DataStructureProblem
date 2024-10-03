package com.example.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ankush.nakaskar
 */
public class GasStation {

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{2},new int[]{2}));
        System.out.println(canCompleteCircuit(new int[]{4},new int[]{5}));
        System.out.println(canCompleteCircuit(new int[]{4,5,2,6,5,3},new int[]{3,2,7,3,2,9}));
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
        System.out.println(canCompleteCircuit(new int[]{4,6,7,4},new int[]{6,5,3,5}));
        System.out.println(canCompleteCircuit(new int[]{2,3,4},new int[]{3,4,3}));
    }

    public int leastInterval(char[] tasks, int n) {
        int[] freq =new int[26];
        for(char ch : tasks){
            freq[ch-'a']++;
        }
        Arrays.sort(freq);
        int max = freq[25];
        int spaces = freq[25]-1;
        for(int i=24;i>=0;i--){
            spaces-=Math.min(max,freq[i]);
        }
        spaces = Math.max(spaces,0);
        return tasks.length+spaces;
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
/*
You can represent this into like :
[][]nums =
{
{1,3},
{2,4},
{3,5},
{4,1},
{5,2}
}
Since we are looking for next gas station when current Gas nums[0] >nums[1], this should be base condition at every step
This mean , total sum of first columns >= total sum second column, if not then return -1;
 */
        int[] diff =new int[gas.length];
        int sum =0;
        for(int i=0;i<gas.length;i++){
            diff[i]=gas[i]-cost[i];
            sum+=diff[i];
        }
        if(sum<0){
            return -1;
        }
        sum=0;
        int index =0;
        for(int i=0;i<gas.length;i++){
            diff[i]=gas[i]-cost[i];
            sum+=diff[i];
            if(sum<0){
                index = i+1;
                sum=0;
            }
        }

        return index;

    }
    public static int canCompleteCircuitOld(int[] gas, int[] cost) {


        int[][] nums = new int[gas.length][2];
        for(int i=0;i< gas.length;i++){

            nums[i][0]= gas[i];
            nums[i][1]= cost[i];
        }

        for(int i=0;i< nums.length;i++){
            int[] startIndex = nums[i];
            if(startIndex[0]==startIndex[1] && startIndex[0]==0){
                continue;
            }
            if(startIndex[0]>=startIndex[1]){
                boolean isTravelled = traverse(nums,i);
                if(isTravelled)return i;
            }

        }
        return -1;
    }

    private static boolean traverse(int[][] nums, int index) {
        int savePetrol =0;
        savePetrol = savePetrol + nums[index][0];
        int startIndex =index;
        int prevCost = nums[index][1];

        index =index+1;
        while(index< nums.length){
            if(savePetrol<prevCost){
                return false;
            }
            savePetrol = savePetrol + nums[index][0]-prevCost;
            prevCost=nums[index][1];
            index++;
        }
        if(index== nums.length){
            index=0;
            while(index<=startIndex){
                if(savePetrol<prevCost){
                    return false;
                }
                savePetrol =savePetrol + nums[index][0]-prevCost;
                prevCost=nums[index][1];
                index++;
            }
        }
        return true;
    }
}
