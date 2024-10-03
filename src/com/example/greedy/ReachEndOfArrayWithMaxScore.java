package com.example.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ankush.nakaskar
 */
public class ReachEndOfArrayWithMaxScore {
    public static void main(String[] args) {
        System.out.println(findMaximumScore(new ArrayList<>(Arrays.asList(1,3,1,5))));
        System.out.println(findMaximumScore(new ArrayList<>(Arrays.asList(4,3,1,3,2))));
    }

    public static long findMaximumScore(List<Integer> nums) {

        int ans =0;
        int count=0;
        int i=0;
        int j=i+1;
        while(i<nums.size() && j<nums.size()){
            while( j<nums.size()-1 && nums.get(j)< nums.get(i)){
                j++;
            }
            ans = ans+ ((j-i) *nums.get(i));
            i=j;
            j=i+1;
        }
        return ans;
    }
}
