package array.hard;

public class ConsecutiveProduct {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int curr_min = nums[0];
        int curr_max = nums[0];
        int final_max = nums[0];
        for(int i=1;i<nums.length;i++){
            int tmp =curr_max;
            curr_max =Math.max(Math.max(curr_max*nums[i],curr_min*nums[i]),nums[i]);
            curr_min =Math.min(Math.min(tmp*nums[i],curr_min*nums[i]),nums[i]);
            if(curr_max>final_max){
                final_max=curr_max;
            }
        }

        return final_max;
    }


    public static void main(String[] args) {
//        int[] a =new int[]{2,3,-2,4};
        int[] a = new int[]{-2, 3, -4};
        System.out.println(new ConsecutiveProduct().maxProduct(a));
    }
}
