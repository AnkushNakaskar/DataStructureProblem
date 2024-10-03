package com.example.dp.book.dpbook;

/**
 * @author ankush.nakaskar
 */
public class LongestRightLeftSum {


    public static void main(String[] args) {
        String input  = "142241";
        System.out.println(maxSubStringLengthWithDP(input));
    }
    public static int maxSubStringLength (String input) {

        int n = input.length();
        int maxLength = 0;
        for(int i=0;i<input.length();i++){
            for(int j=i+1;j<n;j=j+2){
                int len = j - i + 1;
                if (maxLength >= len)
                    continue;
                int lSum = 0, rSum = 0;
                for (int k =0; k < len/2; k++){
                    lSum +=(input.charAt(i+k) - '0');
                    rSum += (input.charAt((i+k+len/2)) - '0');
                    if (lSum == rSum)
                        maxLength = len;
                }
            }
        }
        return maxLength;
    }

    public static int maxSubStringLengthWithDP(String input) {
        int n = input.length();
        int maxLength = 0;
        int[][] sum = new int[n][n];
        for(int i=0;i<n;i++){
            sum[i][i] = input.charAt(i)-'0';
        }
        for(int len=2;len<=n;len++){
            for (int i=0; i<n-len+1; i++){
                int j = i+len-1;
                int k = len/2;
                int p = j-k;
                int q = j-k+1;
                sum[i][j] =sum[i][p]+sum[q][j];
                if(len%2==0 && sum[i][p]==sum[q][j] && len > maxLength){
                    maxLength=len;
                }
            }
        }
        return maxLength;
    }
}
