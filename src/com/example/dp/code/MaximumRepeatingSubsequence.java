package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class MaximumRepeatingSubsequence {

    public static void main(String[] args) {
        System.out.println(maxRepeating("ababc","ab"));
        System.out.println(maxRepeating("a","a"));
        System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba","aaaba"));
    }

    public static int maxRepeating(String sequence, String word) {
//"ababc"
        int count=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<sequence.length();i++){
            sb.append(word);
            if(sequence.contains(sb.toString())){
                count++;
            }
        }
        return count;
    }
}
