package com.example.heap;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class UglyNumber2 {
    public static void main(String[] args) {

//        Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
        int res = nthUglyNumber(11);
        System.out.println(res);
    }

    public static int nthUglyNumber(int n) {
        if(n<=0){
            return n;
        }
        Long min=1L;
        TreeSet<Long> queue =new TreeSet<>(Long::compareTo);
        queue.add(min);
        for(int i=0;i<n;i++){
            min = queue.pollFirst();
            queue.add(min * 2L);
            queue.add(min * 3L);
            queue.add(min * 5L);
        }
        return min.intValue();
    }
}
