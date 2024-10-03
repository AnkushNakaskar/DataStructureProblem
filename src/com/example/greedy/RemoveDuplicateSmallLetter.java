package com.example.greedy;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class RemoveDuplicateSmallLetter {

    public static void main(String[] args) {

        System.out.println(removeDuplicateLetters("abacb"));//abc
        System.out.println(removeDuplicateLetters("cbacdcbc"));//acdb
        System.out.println(removeDuplicateLetters("bcabc"));//acdb
    }
//     System.out.println(removeDuplicateLetters("abacb"));//abc
//        System.out.println(removeDuplicateLetters("cbacdcbc"));//acdb
//        System.out.println(removeDuplicateLetters("bcabc"));//acdb
    public static String removeDuplicateLetters(String input) {
//        Stack is use to make sure values are added as per their occurance
        Stack<Character> stack =new Stack<>();

//        This map maintain the last occurance of value
        Map<Character,Integer> lastOccurance = new HashMap<>();
        for(int i=0;i<input.length();i++){
            lastOccurance.put(input.charAt(i),i);
        }
//        Finally added is use to make sure , value with less index is add
        Set<Character> finallyAdded =new HashSet<>();
        for(int i=0;i<input.length();i++){
            char ch = input.charAt(i);
//            This loop check for if we have stack peek, which is last added value is more than current value and also check for do we stack peek value last index is more
//            And current is not added already, that mean we need to remove the stack peek since this value is less and is present in string
            while(!stack.isEmpty() && ch<stack.peek() && !finallyAdded.contains(ch) && i< lastOccurance.get(stack.peek())){
                finallyAdded.remove(stack.pop());
            }
//            If value is not selected already, we can add in stack
            if(!finallyAdded.contains(ch)){
                stack.push(ch);
                finallyAdded.add(ch);
            }

        }
//        Reverse the stack values to get your result
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
