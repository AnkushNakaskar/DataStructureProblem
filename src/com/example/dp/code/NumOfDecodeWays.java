package com.example.dp.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ankush.nakaskar
 */
public class NumOfDecodeWays {

    public static Map<String,Integer> map ;
    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
    }

    public static int numDecodings(String s) {
        map =new HashMap<>();
        return help(s,0,"");
    }

    private static int help(String s, int index,String sub) {

        if(index==s.length()){
            return 1;
        }
        if(index>s.length()){
            return 0;
        }
        if(!sub.isEmpty() && Integer.parseInt(sub)>26){
            return 0;
        }
        if(map.containsKey(s.substring(0,index))){
            return map.get(s.substring(0,index));
        }
        int left = help(s,index+1,""+s.charAt(index));
        int right =0;
        map.put(s.substring(0,index+1),left);
        if(index+1<s.length()) {
            right = help(s, index + 2, "" + s.charAt(index) + s.charAt(index + 1));
            map.put(s.substring(0,index+2),right);
        }
        return left+right;

    }
}
