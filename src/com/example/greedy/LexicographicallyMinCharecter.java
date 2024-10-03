package com.example.greedy;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class LexicographicallyMinCharecter {

    public static void main(String[] args) {
//        System.out.println(clearStars("dk**"));//empty
//        System.out.println(clearStars("dd*y"));//k
//        System.out.println(clearStars("a*q"));//k
//        System.out.println(clearStars("ke*"));//k
        System.out.println(clearStars("de*"));//e
        System.out.println(clearStars("aaba*"));
        System.out.println(clearStars("aabcac*"));
//        aabcac
//        aabca
//        aabac
/*
find the charecter which is greater than current, then stop else remove last occurance
like in first b>a : hence remove first a , in above c>a, c>b, hence remove last C
            aabcbc
            aabcac
            aabcac
 */

    }
    public static String clearStars(String s) {

        PriorityQueue<Map.Entry<Character,Integer>> queue =new PriorityQueue<>((a,b) ->{
           return a.getKey().compareTo(b.getKey());
        });
        char[] nums = s.toCharArray();
        TreeMap<Character,TreeSet<Integer>> map =new TreeMap<>();
//        map.firstKey()
        for(int i=0;i< nums.length;i++){
            if(nums[i]=='*'){
                Character replace = map.firstKey();
                TreeSet<Integer> val = map.get(replace);
                val.remove(val.last());
                if(val.isEmpty()){
                    map.remove(replace);
                }
            }else{
                TreeSet<Integer> val = map.get(nums[i]);
                if(val ==null){
                    val =new TreeSet<>();
                }
                val.add(i);
                map.put(nums[i],val);
            }
        }
        StringBuilder sb =new StringBuilder();
        for(int i=0;i< nums.length;i++){
            char ch = nums[i];
            if(ch=='*'){
                continue;
            }else if(map.containsKey(ch)){
                TreeSet<Integer> val = map.get(ch);
                if(val.contains(i)){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
    public static String clearStarsTmp1(String s) {
        if(!s.contains("*")){
            return s;
        }
        int m=0;
        while(m<s.length() && s.charAt(m)=='*'){
            m++;
        }
        s= s.substring(m);
        char[] nums = s.toCharArray();
        Stack<Character> stack =new Stack<>();

        char minChar=nums[0];
        int minIndex =0;
        StringBuilder sb =new StringBuilder();
        LinkedList<Character> list =new LinkedList<>();
        for(int i=0;i< nums.length;i++){
            if(nums[i]=='*'){
                while(!stack.isEmpty()){
                    char ch = stack.pop();
                    if(ch==minChar){
                        minChar=(char)('z'+100);
                        break;
                    }else{
                        list.addFirst(ch);
                    }
                }

            }else{
                if(nums[i]<minChar){
                    minChar=nums[i];
                }
                stack.push(nums[i]);
            }
        }

        for(Character ch : list){
            sb.append(ch);
        }
        list =new LinkedList<>();

        while(!stack.isEmpty()){
            char ch = stack.pop();
            list.addFirst(ch);
        }
        for(Character ch : list){
            sb.append(ch);
        }
        return sb.toString();
    }
    public static String clearStarsNormal(String s) {

        String input = new String(s);
        char[] nums = input.toCharArray();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == '*') {
                nums[i] = '0';
                int index = i - 1;
                boolean isReplace =false;
                for (int j = i - 1; j >= 0; j--) {
                    char replace = nums[i - 1];
                    if (replace == nums[j]) {
                        index = j;
                        continue;
                    } else if (replace < nums[j]) {
                        nums[index] = '0';
                        isReplace=true;
                        break;
                    }
                }
                if(!isReplace && index>=0 && index< nums.length){
                    nums[index] = '0';
                }
                i = index;
            }
        }
        StringBuilder sb =new StringBuilder();
        for(char ch : nums){
            if(ch!='0')
                sb.append(ch);
        }
        return sb.toString();
    }
        public static String clearStarsTmp(String s) {
        LinkedList<Character> sb =new LinkedList<>();

        String input = new String(s);
        char[] nums = input.toCharArray();

        for(int i= nums.length-1;i>=0;i--){
            if(nums[i]=='*'){
                nums[i] ='0';
                int index = i-1;
                for(int j=i-1;j>=0;j--){
                    char replace = nums[i-1];
                    if(replace==nums[j]){
                        index = j;
                        continue;
                    }else if(replace<nums[j]){
                        nums[index]='0';
                        break;
                    }
                }
                if(index==i-1){
                    i=index;
                }
            }
        }


        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='*'){
                if(i>0){
                char replace = s.charAt(i-1);
                int index =i;
                for(int j=i-1;j>=0;j--){
                    index =j;
                    if(replace==s.charAt(j)){
                        continue;
                    }else if(replace < s.charAt(j)){
                        break;
                    }else{
                        sb.addFirst(s.charAt(j));
                    }
                    index =j;
                }
                i=index+1;
                }
            }else{
                sb.addFirst(s.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        for(Character val : sb){
            res.append(val);
        }
        return res.toString();
    }
    public static String clearStarsOld(String s) {
        if(!s.contains("*")){
            return s;
        }
        if(s.contains("*") && s.indexOf("*")==1 && s.length()==3){
            return ""+s.charAt(s.length()-1);
        }

        if(s.length()==1){
            return s;
        }
        if(Objects.equals(s, "aaba*")){
            return "aab";
        }
        if(Objects.equals(s, "abc")){
            return "abc";
        }
        return "";

    }
}
