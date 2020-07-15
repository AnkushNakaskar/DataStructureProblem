package array.medium;

public class RemoveDuplicatesfromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int left = 2;
        for (int right = 2; right < nums.length; right++) {
            if (nums[left - 2] != nums[right]) {
                nums[left++]=nums[right];
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(new RemoveDuplicatesfromSortedArray2().removeDuplicates(a));

    }
}
