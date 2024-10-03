package com.example.greedy;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ankush.nakaskar
 */
public class LargestNumber {

    public static void main(String[] args) {


//        int[] arr = new int[]{3,12};
//        String[] nums = new String[arr.length];
//        for(int i=0;i<arr.length;i++){
//            nums[i]=""+arr[i];
//        }
//
//        Arrays.sort(nums,(a,b)->{
//            if(a.length()==b.length()){
//                return b.compareTo(a);
//            }else {
//                StringBuilder sbA = new StringBuilder(a);
//                StringBuilder sbB = new StringBuilder(b);
//                if(a.length()<b.length()){
//                    while(sbA.length()!=b.length()){
//                        sbA.append(a.charAt(a.length()-1));
//                    }
//                }else{
//                    while(sbB.length()!=a.length()){
//                        sbB.append(b.charAt(b.length()-1));
//                    }
//                }
//                String aString = sbA.toString();
//                String bString = sbB.toString();
//                return bString.compareTo(aString);
//            }
//        });
//        for(String val : nums){
//            System.out.print( " " +val);
//        }
        System.out.println(largestNumber(new int[]{111111121, 11111112}));
        System.out.println(largestNumber(new int[]{34323,3432}));
        System.out.println(largestNumber(new int[]{3,30}));
        System.out.println(largestNumber(new int[]{10,2}));
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(largestNumber(new int[]{0,0}));
    }
    public static String largestNumber(int[] arr) {
        String[] nums = new String[arr.length];
        for(int i=0;i<arr.length;i++){
            nums[i]=""+arr[i];
        }
// 10, 2
//
        Arrays.sort(nums,(a,b)->{
            if(a.length()==b.length()){
                return b.compareTo(a);
            }else {
               return (b+a).compareTo(a+b);
            }
        });
        StringBuilder sb = new StringBuilder();


        for(String val : nums){
            sb.append(val);
        }
        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
