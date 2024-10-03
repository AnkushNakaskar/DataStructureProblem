package com.example.dp.code;

import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class FindMaxForm {

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10","0001","111001","1","0"},5,3));
        System.out.println(findMaxForm(new String[]{"10","0001","111001","1","0"},4,3));
        System.out.println(findMaxForm(new String[]{"111","1000","1000","1000"},9,3));
//        "10","0001","111001","1","0"
    }
    public static int findMaxForm(String[] nums, int m, int n){

       return help(nums,0,m,n,0);

    }

    private static int help(String[] nums, int index, int allowedZeros, int allowedOnes, int count) {
        if(allowedZeros==0 && allowedOnes==0){
            return 0;
        }
        for(int i=index;i<nums.length;i++){
            String currStr =nums[i];
            int zeros=0;
            int ones =0;
            for(char ch : currStr.toCharArray()) {
                if (ch == '0') zeros++;
                else ones++;
            }
            if(allowedZeros>=zeros && allowedOnes>=ones){
                return Math.max(1+ help(nums, i+1, allowedZeros-zeros, allowedOnes-ones, count),help(nums, i+1, allowedZeros, allowedOnes, count));
            }else{
                return help(nums, i+1, allowedZeros, allowedOnes, count);
            }
        }
        return 0;
    }

    public static int findMaxFormOld(String[] nums, int m, int n) {

        PriorityQueue<String> queue =new PriorityQueue<>((a,b) ->{
            return a.length()-b.length();
        });
        for(String val : nums){
            queue.add(val);
        }
        int zeros =0;
        int ones =0;
        int count=0;
        while(!queue.isEmpty()){
            String currStr = queue.poll();

            boolean isConsider =true;
            for(char ch : currStr.toCharArray()){
                if(ch=='0') zeros++;
                else ones++;
                if(zeros>m){
                    isConsider=false;
                    break;
                }
                if(ones>n){
                    isConsider=false;
                    break;
                }
            }
            if(isConsider && (ones<=n) && (zeros<=m)){
                count++;
            }
        }

        return count;
    }
}
