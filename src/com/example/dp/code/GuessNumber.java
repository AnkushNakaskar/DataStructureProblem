package com.example.dp.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ankush.nakaskar
 */
public class GuessNumber {

    public static void main(String[] args) {
        System.out.println(guessNumber(2,2));
    }

    public static int guessNumber(int n,int num) {
        ArrayList<Integer> list =new ArrayList<>();
        list.addAll(Arrays.asList(1,2));
        int left = 0;
        int right=n-1;

        while(left<right){
            int mid = left+(right-left)/2;
            if(list.get(mid)==num){
                return mid;
            }else if(list.get(mid)<num){
                left =mid+1;
            }else{
                right =mid-1;
            }
        }
        return -1;
    }
}
