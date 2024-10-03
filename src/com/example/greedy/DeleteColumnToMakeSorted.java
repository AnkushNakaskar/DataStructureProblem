package com.example.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ankush.nakaskar
 */
public class DeleteColumnToMakeSorted {

    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{
                "jwkwdc","etukoz"
        }));
        System.out.println(minDeletionSize(new String[]{
                "xga","xfb","yfa"
        }));
        System.out.println(minDeletionSize(new String[]{
                "ca","bb","ac"
        }));
        System.out.println(minDeletionSize(new String[]{
                "xc","yb","za"
        }));

        System.out.println(minDeletionSize(new String[]{
                "zyx","wvu","tsr"
        }));
    }
    public static int minDeletionSize(String[] nums) {
       int min=0;
       boolean[] deleted =new boolean[nums[0].length()];
       for(int i=1;i<nums.length;i++){
           for(int j=0;j<nums[i].length();j++){
               if(deleted[j] || nums[i-1].charAt(j)==nums[i].charAt(j)){
                   continue;
               }
               if(nums[i-1].charAt(j)>nums[i].charAt(j)){
                   min++;
                   deleted[j]=true;
                   i=0;//To start from start since for loop has the increment
               }
               break;
           }
       }
        return min;
    }








public static int minDeletionSizeOld(String[] nums) {
    int min=0;

    for(int i=0;i<nums[0].length();i++){
        boolean isAllSorted =true;
        boolean isDuplicateFound =false;
        for(int j= 1;j< nums.length;j++){
            char prevCh = nums[j-1].charAt(i);
            char currCh = nums[j].charAt(i);
            if(prevCh>currCh){
                isAllSorted =false;
                min = min+1;
                break;
            }else if(prevCh==currCh){
                isDuplicateFound=true;
            }
        }
        if(isAllSorted && !isDuplicateFound){
            return min;
        }

    }
    return min;
}
////    "xga","xfb","yfa"



}
