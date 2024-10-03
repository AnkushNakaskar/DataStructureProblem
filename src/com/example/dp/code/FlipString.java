package com.example.dp.code;

import java.util.Arrays;

/**
 * @author ankush.nakaskar
 */
public class FlipString {

    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("00110"));
        System.out.println(minFlipsMonoIncr("001100"));
        System.out.println(minFlipsMonoIncr("00011000"));
    }
    public static int minFlipsMonoIncr(String s) {
        int index = s.indexOf("1");
        if(index==-1){
            return 0;
        }
        String input = s.substring(index);
        char[] ones = new char[input.length()];
        Arrays.fill(ones,'1');

        char[] zeros = new char[input.length()];
        Arrays.fill(zeros,'0');

        int minOne = helperOnes(input.toCharArray(),ones,0,0,0);
        int minZero = helperZero(input.toCharArray(),zeros,0,0,0);
        return Math.min(minOne,minZero);
    }

    private static int helperZero(char[] input, char[] zeros, int index, int zeroIndex, int minFlip) {
        if(index<input.length && zeroIndex<zeros.length && index>=0 && zeroIndex>=0){
            if(zeros[zeroIndex]==input[index]){
                return helperOnes(input,zeros,index+1,zeroIndex+1,minFlip);
            }else{
                input[index]='0';
                return helperOnes(input, zeros, index+1, zeroIndex+1, minFlip+1);
            }
        }
        return minFlip;
    }

    private static int helperOnes(char[] input,char[] ones,int index, int oneIndex, int minFlip) {
       if(index<input.length && oneIndex<ones.length && index>=0 && oneIndex>=0){
           if(ones[oneIndex]==input[index]){
               return helperOnes(input,ones,index+1,oneIndex+1,minFlip);
           }else{
               input[index]='1';
               return helperOnes(input, ones, index+1, oneIndex+1, minFlip+1);
           }
       }
        return minFlip;
    }

}
