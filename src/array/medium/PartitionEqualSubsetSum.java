package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PartitionEqualSubsetSum {

    HashMap<Integer, Integer> mapOfIndexToValue = new HashMap<>();
    HashSet<Integer> values = new HashSet<>();
    boolean isFound = false;

    public boolean canPartition(int[] nums) {

        if (nums == null || nums.length < 1) {
            return false;
        }
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            values.add(nums[i]);
            mapOfIndexToValue.put(i, nums[i]);
        }

        int halfValue = sum / 2;
        if (halfValue * 2 != sum) {
            return false;
        }
        int mid = nums.length / 2;
        findElementWithSum(0, mid, halfValue, nums);
        return isFound;
    }

    private void findElementWithSum(int start, int end, int halfValue, int[] nums) {
        int sum = halfValue;
        List<Integer> list = new ArrayList<>();
        if (start > nums.length) {
            return;
        }
        for (int i = start; i < end && i < nums.length; i++) {
            sum = sum - nums[i];
            list.add(nums[i]);
        }
        if (sum == 0) {
            System.out.println("Found List ::" + list);
            isFound = true;
        }
        findElementWithSum(start + 1, end + 1, halfValue, nums);
    }

    public boolean canPartitionLatest(int[] nums) {

        if (nums == null || nums.length < 1) {
            return false;
        }
        Arrays.sort(nums);
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            leftSum -= nums[j];
            rightSum += nums[j];
            if (leftSum == rightSum) {
                if (nums[j - 1] < nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canPartitionFinal(int[] nums) {
        int total = 0;
        for (int val : nums) {
            total += val;
        }
        if (total % 2 != 0) {
            return false;
        }
        return partitionCheckForEveryCombinations(nums, 0, 0, total);
    }

    private boolean partitionCheckForEveryCombinations(int[] nums, int index, int currSum, int total) {
        if (currSum * 2 == total) {

            return true;
        }
        int half = total / 2;
        if (currSum > half || index >= nums.length) {
            return false;
        }
        //First call check for single value if it equal to half of sum
        //Second call check for every combinations
        boolean isFound =partitionCheckForEveryCombinations(nums, index+1, currSum, total) || partitionCheckForEveryCombinations(nums, index+1, currSum+nums[index], total);
        if(isFound){
            System.out.print(" "+nums[index]);
        }
        return isFound;
    }


    public static void main(String[] args) {
//        int[] a =new int[]{2,3,-2,4,2,1,2};
//        int[] a =new int[]{1,5,5,11};
        int[] a = new int[]{1, 2, 3, 4, 5,6,7};
        System.out.println(new PartitionEqualSubsetSum().canPartitionFinal(a));
    }
}
