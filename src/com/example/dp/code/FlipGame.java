package com.example.dp.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankush.nakaskar
 */
public class FlipGame {

    public static void main(String[] args) {
        System.out.println(canWin("++++"));
    }

    public static boolean canWin(String input) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<input.length()-1;i++){
            if(input.charAt(i)=='+' && input.charAt(i+1)=='+'){
                list.add(input.substring(0,i) +"--"+ input.substring(i+2,input.length()));
            }
        }
        for(String str : list){
            if(!canWin(str)){
                return true;
            }
        }
        return false;
    }



    public static List<String> generatePossibleNextMoves(String currentState) {
        if(currentState==null || currentState.isEmpty()){
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        for(int i=0;i<currentState.length()-1;i++){
            if(currentState.charAt(i)=='+' && currentState.charAt(i+1)=='+'){
                list.add(currentState.substring(0,i) +"--"+ currentState.substring(i+2,currentState.length()));
            }
        }
        return list;
    }


    public static boolean canWinOld(String s) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+')
                list.add(s.substring(0, i) + "--" + s.substring(i + 2, s.length()));         // generate all possible sequence after every attempt
        }
    /*if(list.isEmpty())
        return false;*/
        for(String str : list){
            if(!canWin(str))             // if there is any one way the next player can't win, take it and you'll win
                return true;
        }
        return false;
    }
}
