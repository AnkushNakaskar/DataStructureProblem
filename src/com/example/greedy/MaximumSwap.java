package com.example.greedy;

import java.util.Arrays;

/**
 * @author ankush.nakaskar
 */
public class MaximumSwap {

    public static void main(String[] args) {

        System.out.println(maximumSwap(1993));
        System.out.println(maximumSwap(115));
        System.out.println(maximumSwap(983682));
        System.out.println(maximumSwap(2736));
        System.out.println(maximumSwap(9973));
    }
    public static int maximumSwap(int num){
        int res =0;
        String input = ""+num;
        char[] arr = input.toCharArray();
        Arrays.sort(arr);
        String sortedStr = new StringBuilder(new String(arr)).reverse().toString();
//        System.out.println("Sorted :: "+sortedStr);
        StringBuilder sb = new StringBuilder();
        int notMatchIndex =-1;
        for(int i=0;i<sortedStr.length();i++){
            char prevChar = input.charAt(i);
            char sortedChar = sortedStr.charAt(i);
            if(prevChar!=sortedChar){
                notMatchIndex =i;
                sb.append(sortedStr.charAt(i));
                break;
            }else {
                sb.append(sortedStr.charAt(i));
            }
        }
        if(notMatchIndex>=0){
            String inputSubString = input.substring(notMatchIndex);
            int replacedIndex = inputSubString.lastIndexOf(sb.charAt(sb.length()-1));
            for(int i=1;i<inputSubString.length();i++){
                if(i==replacedIndex){
                    sb.append(inputSubString.charAt(0));
                }else{
                    sb.append(inputSubString.charAt(i));
                }
            }
            return Integer.parseInt(sb.toString());
        }else{
            return num;
        }

    }
    public static int maximumSwapOld(int num) {
        String input =""+num;
        char[] nums = input.toCharArray();


        int prevIndex =0;
        int currIndex =1;
        while(currIndex<nums.length){
            int prev = Integer.parseInt(""+nums[prevIndex]);
            int curr = Integer.parseInt(""+nums[currIndex]);
            if(prev==curr){
                currIndex++;
                continue;
            }
            if(prev<curr){
                int leftIndex = prevIndex;
                int rightIndex = currIndex;
                for(int j=rightIndex+1;j<nums.length;j++){
                    if(Integer.parseInt(""+nums[j]) > Integer.parseInt(""+nums[j-1])){
                        rightIndex=j;
                        continue;
                    }else{
                        break;
                    }
                }
                char tmp = nums[prevIndex];
                nums[prevIndex] = nums[rightIndex];
                nums[rightIndex]=tmp;
                break;
            }else {
                prevIndex=currIndex;
            }
            currIndex++;
        }
        String res = new String(nums);
        return Integer.parseInt(res);
    }

}
