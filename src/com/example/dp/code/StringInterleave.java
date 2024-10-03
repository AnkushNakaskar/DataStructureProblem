package com.example.dp.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ankush.nakaskar
 */
public class StringInterleave {

//    public static Map<String,Boolean> map;

    public static void main(String[] args) {
        System.out.println(isInterleave("aacc", "dbba", "aadbbacc"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
    public static boolean isInterleave(String s1, String s2, String s3) {
//        map =new HashMap<>();
        return helperInterleave(s1, s2, s3, 0, 0, 0,new HashMap<>());}
    private static boolean helperInterleave(String s1, String s2, String s3, int s1Index, int s2Index, int s3Index,Map<String,Boolean> map) {
/*
            aabcc   dbbca
                aadbbcbcac
 */
        if (s1Index == s1.length() && s3Index == s3.length() && s2.length() == s2Index) {
//            map.put(s3.substring(0,s3Index),true);
            return true;
        }
        if(s3Index>s3.length()){
            return false;
        }
        String tmp =s1+"|" +s2+ "|"+s3;
        if(map.containsKey(tmp)){
            return map.get(tmp);
        }

        boolean result = (s1Index < s1.length() && s3.charAt(s3Index) == s1.charAt(s1Index) && helperInterleave(s1, s2, s3, s1Index + 1, s2Index, s3Index + 1,map))
                    || (s2Index < s2.length() && s3.charAt(s3Index) == s2.charAt(s2Index) && helperInterleave(s1, s2, s3, s1Index, s2Index + 1, s3Index + 1,map));
        map.put(tmp,result);
        return map.get(tmp);

    }
}
