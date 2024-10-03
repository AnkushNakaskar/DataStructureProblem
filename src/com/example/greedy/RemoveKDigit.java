package com.example.greedy;

import java.util.Stack;

/**
 * @author ankush.nakaskar
 */
public class RemoveKDigit {

    public static void main(String[] args) {
        System.out.println(removeKdigits("112",1));
        System.out.println(removeKdigits("1432219",3));
        System.out.println(removeKdigits("10200",1));
    }
    public static String removeKdigits(String num, int k) {
        if(k>=num.length()){
            return "0";
        }
        Stack<Integer> stack =new Stack<>();
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<num.length();i++){
            int curr = Integer.parseInt(""+num.charAt(i));
            while(!stack.isEmpty() && stack.peek()>curr && k>0){
                stack.pop();
                k--;
            }
            stack.push(curr);
        }
        while(k>0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
       while(!stack.isEmpty()){
           sb.append(stack.pop());
       }
       while(!sb.isEmpty() && sb.charAt(sb.length()-1)=='0'){
           sb.deleteCharAt(sb.length()-1);
       }
       if(sb.isEmpty()){
           return "0";
       }
       return sb.reverse().toString();
    }

}
