package com.example.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankush.nakaskar
 */
public class PanCackeSort {

    /*
   This example basically, array contain values from 0---N-1.
   So we have to find the index of largest if its not already in the last.
   Then check if its not the first, if it not, then we flip & make it to first
   Then flip again with from start(0th index) to make it last.
   */
    public static int findMax(int[] arr,int s,int e){
        int max=0;
        int idx=0;
        for(int i=s;i<=e;i++){
            if(max<arr[i]){
                max=arr[i];
                idx=i;
            }
        }
        return idx;
    }
    public static void reverse(int[] arr,int s,int e){
        for(int i=s;i<=e;i++){
            int temp=arr[i];
            arr[i]=arr[e];
            arr[e]=temp;
            e--;
        }
    }

    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer>list=new ArrayList<>();
        int i=0;
        int j=arr.length-1;
        while(i<=j){
            int maxidx=findMax(arr,i,j);
            reverse(arr,i,maxidx);
            list.add(maxidx+1);
            reverse(arr,i,j);
            list.add(j+1);
            j--;

        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(pancakeSort(new int[]{3,2,4,1}));
    }
}
