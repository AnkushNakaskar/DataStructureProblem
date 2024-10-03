package com.example.greedy;

import java.util.Arrays;
import java.util.List;

/**
 * @author ankush.nakaskar
 */
public class MaximumDistaceInArray {
    public static void main(String[] args) {

        System.out.println(maxDistance(Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4,5),Arrays.asList(1,2,3))));
        System.out.println(maxDistance(Arrays.asList(Arrays.asList(1),Arrays.asList(1))));
    }
    public static int maxDistance(List<List<Integer>> arrays) {
        int[] maxVal = new int[arrays.size()];
        int[] minVal = new int[arrays.size()];
        for(int i=0;i<arrays.size();i++){
            maxVal[i]= arrays.get(i).get(arrays.get(i).size()-1);
            minVal[i]=arrays.get(i).get(0);
        }
        Arrays.sort(minVal);
        int maxDiff = 0;
        for(int i=0;i<arrays.size();i++){
            int currMax = arrays.get(i).get(arrays.get(i).size()-1);
            int currMin = arrays.get(i).get(0);
            if(currMin!=minVal[0]){
                maxDiff = Math.max(maxDiff,Math.abs(minVal[0]-currMax));
            }else{
                maxDiff = Math.max(maxDiff,Math.abs(minVal[1]-currMax));
            }
        }
        return maxDiff;
    }
}
