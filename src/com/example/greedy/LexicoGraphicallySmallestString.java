package com.example.greedy;

/**
 * @author ankush.nakaskar
 */
public class LexicoGraphicallySmallestString {

    public static void main(String[] args) {
        System.out.println(getSmallestString("45320"));
        System.out.println(getSmallestString("001"));
    }

    public static String getSmallestString(String s) {
        char[] input = s.toCharArray();
        for(int i=1;i<input.length;i++){
            char prev = input[i-1];
            char curr = input[i];
            if(Integer.parseInt(""+prev)%2 == Integer.parseInt(""+curr)%2){
                if(prev>curr){
                   input[i-1]=curr;
                    input[i]=prev;
                    break;
                }
            }
        }
        return new String(input);
    }
}
