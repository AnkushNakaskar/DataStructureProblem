package com.example.dp.code;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class NumMatchingSubseq {

    public static Set<String> totalSet;
    public static void main(String[] args) {
        System.out.println(numMatchingSubseq("abcde",new String[]{
                "a","bb","acd","ace"
        }));
        System.out.println(numMatchingSubseq("qlhxagxdqh",new String[]{
                "qlhxagxdq","qlhxagxdq","lhyiftwtut","yfzwraahab"
        }));
        System.out.println(numMatchingSubseq("rwpddkvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvjubjgloeofnpjqlkdsqvruvabjrikfwronbrdyyjnakstqjac",new String[]{
                "wpddkvbnn","lnagtva","kvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvju","rwpddkvbnnugln","gloeofnpjqlkdsqvruvabjrikfwronbrdyyj","vbgeinupkvgmgxeaaiuiyojmoqkahwvbpwugdainxciedbdkos","mspuhbykmmumtveoighlcgpcapzczomshiblnvhjzqjlfkpina","rgmliajkiknongrofpugfgajedxicdhxinzjakwnifvxwlokip","fhepktaipapyrbylskxddypwmuuxyoivcewzrdwwlrlhqwzikq","qatithxifaaiwyszlkgoljzkkweqkjjzvymedvclfxwcezqebx"
        }));
    }
    public static int numMatchingSubseq(String input, String[] words) {

        HashMap<Character,TreeSet<Integer>> map =new HashMap<>();
        for(int i=0;i<input.length();i++){
            char ch = input.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,new TreeSet<>());
            }
            map.get(ch).add(i);
        }
        int count =0;
        for(int i=0;i< words.length;i++){
            String inputword = words[i];
            if(verifySubSequence(inputword,map)){
                 count++;
            }
        }
        return count;

    }

    private static boolean verifySubSequence(String inputword, HashMap<Character, TreeSet<Integer>> map) {
        if(inputword==null || inputword.isEmpty()){
            return false;
        }
        int prevIndex =-1;
        for(int i=0;i<inputword.length();i++){
            char ch = inputword.charAt(i);

            if(prevIndex==-1 ){
                if(map.containsKey(ch)){
                    prevIndex=map.get(ch).first();
                }else{
                    return false;
                }
            }else{
                if(map.containsKey(ch)){
                    Integer nextIndex = map.get(ch).ceiling(prevIndex+1);
                    if(nextIndex==null){
                        return false;
                    }else{
                        prevIndex =nextIndex;
                    }
                }else {
                    return false;
                }

            }
        }
        return true;
    }

    public static int numMatchingSubseqOld(String input, String[] words) {
        int count =0;
        totalSet =new HashSet<>();
        helper(input,0,"");
        for(int i=0;i< words.length;i++){
            if(totalSet.contains(words[i])) count++;
        }

        return count;
    }

    private static void helper(String input, int index, String curr) {
        if(!curr.isEmpty()){
            totalSet.add(curr);
        }
        for(int i=index;i<input.length();i++){
            curr = curr + input.charAt(i);
            helper(input, i+1, curr);
            curr = curr.substring(0,curr.length()-1);
        }
    }
}
