package com.example.dp.book.dpbook;

/**
 * @author ankush.nakaskar
 */
public class NumberOfWayToReachScore {

    public static void main(String[] args) {
//        System.out.println(waysToScore(13));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
    }
    public static int waysToScore(int n){
        if(n < 0) { return 0; }
        if(n == 0) { return 1; }

        return waysToScore(n-3) +
                waysToScore(n-5) +
                waysToScore(n-10);

    }

    public static int climbStairs(int n) {
        if(n < 0) { return 0; }
        if(n == 0) { return 1; }

        return climbStairs(n-1) +
                climbStairs(n-2);
    }


}
