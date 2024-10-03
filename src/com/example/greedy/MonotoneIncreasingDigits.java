package com.example.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ankush.nakaskar
 */
public class MonotoneIncreasingDigits {
    public static void main(String[] args) {

        System.out.println(monotoneIncreasingDigits(989998));
        System.out.println(monotoneIncreasingDigits(101));
        System.out.println(monotoneIncreasingDigits(100));
        System.out.println(monotoneIncreasingDigits(1232));
        System.out.println(monotoneIncreasingDigits(2432));
        System.out.println(monotoneIncreasingDigits(2431));
        System.out.println(monotoneIncreasingDigits(10));
        System.out.println(monotoneIncreasingDigits(332));
        System.out.println(monotoneIncreasingDigits(1234));
        System.out.println(monotoneIncreasingDigits(120));
        /*
100
1229
2399
2399
9
299
1234
119
         */
    }
    public static int monotoneIncreasingDigits(int n) {
        String input = ""+n;
        char[] nums = input.toCharArray();
        LinkedList<Integer> list =new LinkedList<>();
        int index =-1;
        for(int i=1;i< nums.length;i++){
            Integer prev = Integer.parseInt(""+nums[i-1]);
            Integer curr = Integer.parseInt(""+nums[i]);
            if(curr<prev){
                int prevIndex =i-1;
                for(int j=prevIndex-1;j>=0;j--){
                    if(Integer.parseInt(""+nums[j]) ==Integer.parseInt(""+nums[j+1])){
                        prevIndex=j;
                    }else{
                        break;
                    }
                }
                prev = Integer.parseInt(""+nums[prevIndex]);
                nums[prevIndex]=new String(""+(prev-1)).charAt(0);
                index=prevIndex+1;
                break;
            }
        }
        if(index>0){
            for(int i=index;i<nums.length;i++){
                nums[i]='9';
            }
        }
        String res =new String(nums);
        return Integer.parseInt(res);
    }
    public static int monotoneIncreasingDigitsOld(int n) {
        String input = ""+n;
        char[] nums = input.toCharArray();
        LinkedList<Integer> list =new LinkedList<>();
        Stack<Integer> stack =new Stack<>();
        for(char ch : nums){
            Integer curr = Integer.parseInt(""+ch);
            stack.push(curr);
        }

        while(!stack.isEmpty() && stack.size()>1){
            int prev = stack.pop();
            int curr = stack.pop();
            if(curr==0 && prev>0){
                list.addFirst(9);
                stack.push(curr);
                continue;
            }else if(curr>0 && prev==0){
                list.addFirst(9);
                stack.push(curr-1);
                continue;
            }else if(curr==0 && prev==0){
                list.addFirst(9);
                stack.push(curr);
                continue;
            }else if(prev<curr){
                list.addFirst(9);
                stack.push(curr-1);
            }else{
                stack.push(curr);
                stack.push(prev);
                break;
            }
        }
        while(!stack.isEmpty()){
            list.addFirst(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int val : list){
            sb.append(val);
        }
        return Integer.parseInt(sb.toString());
    }
}
