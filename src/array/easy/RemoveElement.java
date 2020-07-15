package array.easy;

import java.math.BigInteger;
import java.util.Arrays;

public class RemoveElement {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int prev = 0;
        int toSwap = -1;
        int fromSwap = prev;
        boolean isSwapped = false;
        boolean isAllElementInIncreasingOrder = true;
        for (int i = 1; i < nums.length; i++) {
            if (!isSwapped && (nums[prev] > nums[i])) {
                isSwapped = true;
                fromSwap = prev;
                toSwap = i;
            }
            if (isSwapped && (!(nums[prev] > nums[i]))) {
                isAllElementInIncreasingOrder = false;
            }
            prev = i;

        }
        if (!isSwapped) {
            swapElement(nums.length - 1, nums.length - 2, nums);
        }else if(isSwapped && !isAllElementInIncreasingOrder){
            swapElement(fromSwap,toSwap,nums);
        }else{
            Arrays.sort(nums);
        }
    }

    private void swapElement(int prev, int i, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[prev];
        nums[prev] = tmp;

    }



    public static int divide(int dividend, int divisor) {
//        System.out.println(Math.abs(-2147483648));
        BigInteger bg1 = new BigInteger(""+dividend);
        System.out.println(bg1.abs());
        System.out.println(Integer.MIN_VALUE);

        int dvd =Math.abs(dividend);
        int dv =Math.abs(divisor);
        int count =0;
        while(dvd>=dv){
            dvd =dvd-dv;
            count++;
        }
        if((dividend <0 && divisor>0) || (dividend >0 && divisor<0)){
            return -count;
        }
        return count;
    }

    public int maxSubArray(int[] nums,int start,int end) {
       int  max_so_far = 0;
        int  max_ending_here = 0;
        int max =Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max_ending_here =max_ending_here+nums[i];
            if(max_so_far<max_ending_here){
                max_so_far =max_ending_here;
            }
            if(max_ending_here<0){
                max_ending_here=0;
            }
        }
        System.out.println(max_so_far);
        return max_so_far;
    }


    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int[] sum =  new int[nums.length];
        sum[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            sum[i] = Math.max(nums[i], sum[i-1] + nums[i]);
            result = Math.max(result, sum[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums =new int[] {-2,1,-3,4,-1,2,1,-5,4};
//        new RemoveElement().maxSubArray(nums,0,nums.length);
        new RemoveElement().maxSubArray(nums);
    }

}
