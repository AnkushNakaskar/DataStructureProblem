package com.example.dp.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ankush.nakaskar
 */
public class CombinationSum4 {

    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1,2,3},4));
    }
    /*
    Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.

     */

    public static int combinationSum4(int[] nums, int target) {
        Map<Integer,Integer> map =new HashMap<>();
        return help(nums,target,map);
    }

    private static int help(int[] nums, int target, Map<Integer, Integer> map) {
        if(target==0){
            return 1;
        }
        if(map.containsKey(target)){
            return map.get(target);
        }
        int ans =0;
        for(int i=0;i< nums.length;i++){
            if(target-nums[i]>=0){
                ans+=help(nums, target-nums[i], map);
            }
        }
        map.put(target,ans);
        return map.get(target);
    }
}
