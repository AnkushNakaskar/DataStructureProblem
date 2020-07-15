package array.easy;

public class CanPlaceFlower {
    public boolean canPlaceFlowers(int[] nums, int n) {
        if(nums==null || nums.length==0){
            return false;
        }
        int count=0;
        if(n==0){
            System.out.println(" Count ::"+count);
            return true;
        }
        if(nums.length==1){
            System.out.println(" Count ::"+count);
            return nums[0]==0 && n<=1 ?true:false;
        }
        if(nums.length==2){
            if(nums[0]==1 || nums[1]==1){
                System.out.println(" Count ::"+count);
                return false;
            }else{
                System.out.println(" Count ::"+count);
                return 1>=n ?true:false;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(i==0 && nums[0]==0 && nums[1]==0){
                count++;
                nums[i]=1;
            }
            if(i==nums.length-1 && nums[nums.length-1]==0 && nums[nums.length-2]==0){
                count++;
                nums[i]=1;
            }
            if(i>0 && i<nums.length-1 && nums[i-1]==0 && nums[i+1]==0 && nums[i]==0){
                count++;
                nums[i]=1;
            }
            if(count>=n){
                System.out.println(" Count ::"+count);
                return true;
            }
        }


        if(count>=n){
            System.out.println(" Count ::"+count);
            return true;
        }
        System.out.println(" Count ::"+count);
        return false;

    }

    public static void main(String[] args) {
        int[] a =new int[]{0,0,0,0};
        new CanPlaceFlower().canPlaceFlowers(a,3);
    }
}
