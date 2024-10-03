package com.example.greedy;

import java.util.Arrays;

/**
 * @author ankush.nakaskar
 */
public class SmallestRange2 {
    public static void main(String[] args) {
        System.out.println(smallestRangeII(new  int[]{1,1,3,6},3));
    }

    public static int smallestRangeII(int[] n, int k) {
        Arrays.sort(n);
        int  l = n.length;
        int min_diff = n[l-1] - n[0];

        if(l == 1)
            return 0;

        for(int i=0;i<l-1;i++)
        {
            int a = Math.min(n[0]+k , n[i+1]-k);
            int b = Math.max(n[l-1]-k , n[i]+k);
            min_diff = Math.min(min_diff,b-a);
        }
        return min_diff;
    }
}
