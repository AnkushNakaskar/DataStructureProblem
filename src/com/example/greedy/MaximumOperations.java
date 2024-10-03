package com.example.greedy;

/**
 * @author ankush.nakaskar
 */
public class MaximumOperations {
    public static void main(String[] args) {
        System.out.println(maxOperations("10"));
        System.out.println(maxOperations("110"));
        System.out.println(maxOperations("101"));
        System.out.println(maxOperations("1001101"));
        System.out.println(maxOperations("00111"));
    }
    public static int maxOperations(String s) {
        int ans =0;
        int count =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='1'){
                ans+=count;
                while(i<s.length() && s.charAt(i)=='0')i++;
            }
            count++;
        }
        return ans;
    }
    public static int maxOperationsOld(String s) {
        char[] input = s.toCharArray();
        int res =0;

            //1001101
        for(int i=0;i<input.length-1;i++){
            boolean isFound =false;
            for(int j=i+1;j< input.length;j++){
                char next = input[j];
                char curr = input[j-1];
                if(isFound && next=='1'){
                    input[j-1] ='1';
                    isFound=false;
                    i =-1;
                    break;
                }
                if(curr=='1' && next=='0'){
                    res++;
                    isFound=true;
                    input[j-1]='0';
                }
            }
            if(isFound && input[input.length-1]=='0'){
                input[input.length-1]='1';
                i =-1;
//                res++;
            }
//            System.out.println("Index : "+i + " isFound : "+isFound);
        }

       return res;

    }
}
