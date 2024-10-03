package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class MincostTickets {

    public static void main(String[] args) {
        System.out.println(mincostTickets(new int[]{
                1,4,6,7,8,20
        },new int[]{
                2,7,15
        }));

        System.out.println(mincostTickets(new int[]{
                1,2,3,4,5,6,7,8,9,10,30,31
        },new int[]{
                2,7,15
        }));
    }

    public static int mincostTickets(int[] days, int[] costs) {
        int res =0;
        int min = helper(days,0,0,-1,costs);
        return min;
    }

    private static int helper(int[] nums, int index, int currCost, int lastDayAllowed, int[] costs) {
        if(index<nums.length){
            if(nums[index]<=lastDayAllowed){
                return helper(nums, index+1, currCost, lastDayAllowed, costs);
            }else{
                return Math.min(Math.min(helper(nums, index+1, currCost+costs[0], nums[index], costs),
                        helper(nums, index+1, currCost+costs[1], nums[index]+6, costs)),helper(nums, index+1, currCost+costs[2], nums[index]+29, costs));
            }
        }
        return currCost;
    }
}
