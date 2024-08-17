package com.example.heap;
/**
 * @author ankush.nakaskar
 */
public class HeapImpl {

    public static void main(String[] args) {
        System.out.println("Ankush");
        int[] nums =new int[]{16,4,10,14,7,9,3,2,8,1};
        heap(nums);
    }

    public static void heap(int[] nums){
        if(nums==null || nums.length<=1){
            return;
        }

        int half = nums.length/2-1;
        for(int i=half ;i>=0;i--){
            System.out.print("Value : "+nums[i]);
            max_heapFy(nums,i);
            System.out.println();
        }
        for(int j=0;j<nums.length;j++){
            System.out.print(" "+nums[j]);
        }
    }

    private static void max_heapFy(int[] nums, int i) {
        int left = leftArr(nums,i);
        int right = rightArr(nums,i);
        int largest =i;
        if(left< nums.length  && left>=0 && nums[left]>nums[i]){
            largest =left;
        }
        if(right< nums.length  && right>=0  && nums[right]>nums[largest]){
            largest =right;
        }
        if(largest!=i){
            int tmp = nums[i];
            nums[i]=nums[largest];
            nums[largest]=tmp;
            max_heapFy(nums, largest);
        }
    }

    private static int rightArr(int[] nums, int i) {
        int index =2* i +2;
        if(index>=nums.length){
            return -1;
        }
        return index;
    }

    private static int leftArr(int[] nums, int i) {
        int index =2* i +1;
        if(index>=nums.length){
            return -1;
        }
        return index;
    }


}
