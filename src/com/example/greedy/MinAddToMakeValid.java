package com.example.greedy;

/**
 * @author ankush.nakaskar
 */
public class MinAddToMakeValid {

    public static void main(String[] args) {

        System.out.println(minAddToMakeValid(")())((()"));
        System.out.println(minAddToMakeValid(")()))"));
        System.out.println(minAddToMakeValid("()))"));
        System.out.println(minAddToMakeValid("()))((("));

    }
    public static int minAddToMakeValid(String input) {
        int left =0;
        int right=0;
        int count=0;
        int i=0;
        while(i<input.length() && input.charAt(i)==')'){
            count++;
            i++;
        }
        int j=input.length()-1;
        while(j>=i && input.charAt(j)=='('){
            count++;
            j--;
        }
//        System.out.println(minAddToMakeValid("())((()"));
        for(int m=i;m<=j;m++){
            if(input.charAt(m)=='('){
                left++;
            }else{
                if(left==0){
                    count=count+1;
                }else{
                    left--;
                }
            }
        }

        return count+Math.abs(left-right);
    }
}
