package com.example.greedy;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author ankush.nakaskar
 */
public class FindPermutation {

    public static void main(String[] args) {
        System.out.println(findPermutation("IDID"));
//        System.out.println(findPermutation("D"));
//        System.out.println(findPermutation("I"));
//        System.out.println(findPermutation("DI"));
//        System.out.println(findPermutation("ID"));
//        System.out.println(findPermutation("DDDDDID"));
//        System.out.println(findPermutation("DDDDDIDDDDD"));
    }
    public static int[] findPermutation(String s) {
        int[] res =new int[s.length()+1];
        for(int i=0;i<=s.length();i++){
            res[i]=i;
        }
        char[] nums = s.toCharArray();
        int i=0;
        while(i< nums.length){
            if(nums[i]=='D'){
                int left =i;
                int right=i;
                Stack<Integer> stack =new Stack<>();
                while(i< nums.length && nums[i]=='D'){
                    right=i;
                    i++;
                }
                for(int m=left;m<=i;m++){
                    stack.push(res[m]);
                }
                while(!stack.isEmpty()){
                    res[left++]=stack.pop();
                }
            }
            i++;
        }
        return res;
    }
    public static int[] findPermutationOld(String s) {
        int[] res =new int[0];
       int i=0;
       char[] nums = s.toCharArray();
       LinkedList<String> list =new LinkedList<>();
       int count=1;
       while(i< nums.length){
           if(nums[i]=='D'){
               int left =i;
               int right=i;
               while(i< nums.length && nums[i]=='D'){
                   right=i;
                   i++;
               }
               i--;
               Stack<String> stack =new Stack<>();
               while(right+1>=left){
                   stack.push(""+count);
                   right--;
                   count++;
               }
               while(!stack.isEmpty()){
                   list.add(stack.pop());
               }
           }else{
               list.add(""+nums[i]);
           }
           i++;
       }
        System.out.println(list);
       if(!list.isEmpty() && list.getFirst().equals("I")){
           Stack<String> stack =new Stack<>();
           list.removeFirst();
           stack.push(""+(count));
           count++;
           stack.push(""+count);
           while(!stack.isEmpty()){
               list.addFirst(stack.pop());
           }

       }else{
           for(int m=1;m<list.size();m++){
               if(list.get(m).equals("I")){
                   String prev = list.get(m-1);
                   list.set(m,new String(""+count));
                   count= count+1;
               }
           }
       }
       System.out.println(list);
        return res;
    }
}
