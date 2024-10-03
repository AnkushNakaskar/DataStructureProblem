package com.example.greedy;

import java.util.Stack;

/**
 * @author ankush.nakaskar
 */
public class ValidParanthesisString {

    public static void main(String[] args) {
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*))"));
        System.out.println(checkValidString("(*)))"));
        System.out.println(checkValidString("(()"));
        System.out.println(checkValidString("(()*"));
        System.out.println(checkValidString("(*"));
    }
    public static boolean checkValidString(String input) {
        Stack<Integer> openStack =new Stack<>();
        Stack<Integer> starStack =new Stack<>();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='('){
                openStack.push(i);
            }else if(input.charAt(i)=='*'){
                starStack.push(i);
            }else{
                if(!openStack.isEmpty()){
                    openStack.pop();
                }else if(!starStack.isEmpty()){
                    starStack.pop();
                }else{
                    return false;
                }
            }
        }
        while(!openStack.isEmpty()){
            if(starStack.isEmpty()) return false;
            int start = openStack.pop();
            int ei = starStack.pop();
            if(start>ei) return false;
        }

      return openStack.isEmpty() ? true : openStack.size()==starStack.size();
    }
}
