package array.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

    HashSet<Integer> set = new HashSet<>();
    TreeSet<Integer> longest =new TreeSet<>();

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        set.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        for (int i = 0; i < nums.length; i++) {
            populateValue(longest,nums[i],nums.length);
        }
        System.out.println(longest);
        return longest.last();
    }

    private void populateValue(TreeSet<Integer> longest, int num, int length) {
        int max =1+checkLessThanValue(num-1,length)+checkMoreThanValue(num+1,length);
        longest.add(max);
    }

    private int checkMoreThanValue(int value, int length) {
        int max =0;
        for(int i=0;i<length;i++){
            if(set.contains(value+i)){
                max=max+1;
            }else{
                break;
            }
        }
        return max;
    }

    private int checkLessThanValue(int value, int length) {
        int max =0;
        for(int i=0;i<length;i++){
            if(set.contains(value-i)){
                max=max+1;
            }else{
                break;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a =new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(a));
    }
}
