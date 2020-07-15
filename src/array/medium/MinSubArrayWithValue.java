package array.medium;

public class MinSubArrayWithValue {

    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int result=Integer.MAX_VALUE;
        int val_max =0;
        int left=0;
        for(int i=0;i<nums.length;i++){
            val_max=val_max+nums[i];
            while(val_max>=s){
                result =Math.min(result,i+1-left);
                val_max=val_max-nums[left];
                left++;
            }
        }
        System.out.println(result);
        return result;

    }

    public int[] productExceptSelf(int[] nums) {
        if(nums==null || nums.length==0){
            return null;
        }
        if(nums.length==1){
            return nums;
        }
        if(nums.length==2){
            int tmp=nums[0];
            nums[0]=nums[1];
            nums[1]=tmp;
            return nums;
        }
        int[] result =new  int[nums.length];
        int[] leftA =new int[nums.length];
        int[] leftB =new int[nums.length];

        int prevLeft =1;
        int prevRight =1;
        for(int i=0,j=nums.length-1;i<nums.length;i++,j--){
            leftA[i]=prevLeft;
            prevLeft =nums[i]*prevLeft;

            leftB[j]=prevRight;
            prevRight =nums[j]*prevRight;

        }

        for(int i=0;i<nums.length;i++){
            result[i] =leftA[i]*leftB[i];
        }
        return result;

    }

    public static void main(String[] args) {
        int[]a =new int[]{2,3,1,2,4,3};
//        new MinSubArrayWithValue().minSubArrayLen(7,a);
        new MinSubArrayWithValue().productExceptSelf(new int[]{9,0,-2});
    }
}
