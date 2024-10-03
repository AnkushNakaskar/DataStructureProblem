package com.example.dp.code;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ankush.nakaskar
 */
public class LongestStrChain {

    public static void main(String[] args) {

        System.out.println(longestStrChain(new String[]{"bdca","bda","ca","dca","a"}));
        System.out.println(longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
        System.out.println(longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
        System.out.println(longestStrChain(new String[]{"abcd","dbqca"}));

    }

    public static int longestStrChain(String[] words) {
        int res =0;
        HashMap<String,Integer> map =new HashMap<>();
        Arrays.sort(words,(a,b)->{
            return a.length()-b.length();
        });
        res =helper(words,0,map);
        int max =0;
        if(!map.isEmpty()){
            return map.values().stream().max(Integer::compare).get();
        }
        return res;
    }

    private static int helper(String[] words, int index, HashMap<String, Integer> map) {
        if(index< words.length){
            int max =0;
            if(!map.containsKey(words[index])){
                map.put(words[index],1);
            }

            for(int j=index;j< words.length;j++){
                String currString = words[j];
                if(!map.containsKey(currString)){
                    map.put(currString,1);
                }

                for(int i=0;i<currString.length();i++){
                    if(i==0 && currString.length()>1){
                        String input = currString.substring(i+1);
                        if(map.containsKey(input)){
                            if(map.containsKey(currString)){
                                map.put(currString, Math.max(1+map.get(input),map.get(currString)));
                            }else{
                                map.put(currString,1+map.get(input));
                            }
                            max = Math.max(max,1+map.get(input)+helper(words, j+1, map));
                        }
                    }else if(i==currString.length()-1){
                        String input = currString.substring(0,i);
                        if(map.containsKey(input)){
                            if(map.containsKey(currString)){
                                map.put(currString, Math.max(1+map.get(input),map.get(currString)));
                            }else{
                                map.put(currString,1+map.get(input));
                            }
                            max = Math.max(max,1+map.get(input)+helper(words, j+1, map));
                        }
                    }else{
                        String input = currString.substring(0,i) + currString.substring(i+1);
                        if(map.containsKey(input)){
                            if(map.containsKey(currString)){
                                map.put(currString, Math.max(1+map.get(input),map.get(currString)));
                            }else{
                                map.put(currString,1+map.get(input));
                            }

                            max = Math.max(max,1+map.get(input)+helper(words, j+1, map));
                        }
                    }
                }

            }


            return max;
        }
        return 0;
    }
}
