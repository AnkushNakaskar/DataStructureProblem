package array.easy;

public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length;
        return find(start,end,nums,target);
    }

    private boolean find(int start, int end, int[] nums, int target) {
        if(start>end){
            return false;
        }
        if((start<0 && start>nums.length) || (end>nums.length &&end<0)){
            return false;
        }
        int mid =(start+end)/2;
        if(mid<0 || mid>=nums.length){
            return false;
        }
        if(nums[mid]==target){
            return true;
        }
        if(find(start, mid-1, nums, target) || find(mid+1, end, nums, target)){
            System.out.println("found");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a =new int[]{2,5,6,0,0,1,2};
//        [2,5,6,0,0,1,2]

        new SearchInRotatedSortedArrayII().search(a,3);
    }
}
