package com.example.greedy;

/**
 * @author ankush.nakaskar
 */
public class ValidPalindrome2 {

    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("ab"));
        System.out.println(validPalindrome("deeee"));
        System.out.println(validPalindrome("eeeed"));
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abc"));

    }
    public static boolean validPalindrome(String input){
        String reverseString = new StringBuilder(input).reverse().toString();
        if(input.equals(reverseString)){
            return true;
        }
        int left=0;
        int right = input.length()-1;
//      left index skip
        int count=1;
        for(int i=left,j=right;i<=j;){
            if(input.charAt(i)==input.charAt(j)){
                i++;
                j--;
                continue;
            }else if(count>0){
                count--;
                i++;
            }else{
                count--;
                break;
            }
        }
        boolean leftPass = count>=0;
         left=0;
         right = input.length()-1;
//      left index skip
         count=1;
        for(int i=left,j=right;i<=j;){
            if(input.charAt(i)==input.charAt(j)){
                i++;
                j--;
                continue;
            }else if(count>0){
                count--;
                j--;
            }else{
                count--;
                break;
            }
        }
        boolean rightPass = count>=0;
        return leftPass||rightPass;

    }
    public static boolean validPalindromeOld(String input) {
        String reverseString = new StringBuilder(input).reverse().toString();
        if(input.equals(reverseString)){
            return true;
        }
//        abca
//        acba
        int count=0;
        for(int i =0;i<input.length();i++){
            if(input.charAt(i)!=reverseString.charAt(i)){
                String remainingStr ="";
                if(i==0){
                    remainingStr = input.substring(i+1);
                }else if(i==input.length()-1){
                    remainingStr = input.substring(0,input.length()-1);
                }else{
                    remainingStr = input.substring(0,i) + input.substring(i+1);
                }
                String rightSub = new StringBuilder(remainingStr).reverse().toString();
                if(remainingStr.equals(rightSub)){
                    return true;
                }
            }
        }
        return false;
    }
}
