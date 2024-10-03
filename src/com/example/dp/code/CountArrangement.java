package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class CountArrangement {

    public static int count;

    public static void main(String[] args) {
        System.out.println(countArrangement(2));
        System.out.println(countArrangement(3));
    }
    public static int countArrangement(int n) {
        count=0;
        int[] nums =new int[n+1];
        for(int i=0;i<=n;i++){
            nums[i]=i;
        }
        boolean[] visited =new boolean[nums.length];
        help(nums,1,visited);
        return count;

    }

    private static void help(int[] nums, int index, boolean[] visited) {
        if(index>= nums.length){
            count++;
        }
        for(int i=1;i<= nums.length;i++){
            if(!visited[i] && (i%nums[i]==0 || nums[i]%i==0)){
                visited[i]=true;
                help(nums, i+1, visited);
                visited[i]=false;
            }
        }
    }
}
