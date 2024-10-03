package com.example.dp.code;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author ankush.nakaskar
 */
public class CountDigitWithUnique {

    public static int numberCount(int a, int b) {
        int count=0;
        for(int i=a;i<=b;i++){
            HashSet<Character> set =new HashSet<>();
            String input =""+i;
            for(char ch : input.toCharArray()){
                set.add(ch);
            }
            if(set.size()==input.length())count++;
        }
        return count;
    }
}
