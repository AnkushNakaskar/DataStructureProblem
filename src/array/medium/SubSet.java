package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubSet {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);

        List<Integer> subset = new ArrayList<>();
        generate( nums,  res,subset,0);
        return res;
    }

    private void generate( int[] nums, List<List<Integer>> res,List<Integer> subset,int startIndex) {
        res.add(new ArrayList<>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            generate(nums, res, subset, i+1);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new SubSet().subsets(nums));
    }
}
