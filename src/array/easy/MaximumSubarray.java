package array.easy;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int curr_max =nums[0];
        int[] max =new int[nums.length];
        max[0] =curr_max;
        for(int i=1;i<nums.length;i++){
            curr_max =Math.max(nums[i],curr_max+nums[i]);
            max[i]=curr_max;
        }
        System.out.println(max);
        return 0;
    }

    public static void main(String[] args) {
        int[]a =new int[]{-2,1,-3,4,-1,2,1,-5,4};
        new MaximumSubarray().maxSubArray(a);
    }
}
