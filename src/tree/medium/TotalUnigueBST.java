package tree.medium;

import java.util.Arrays;

public class TotalUnigueBST {

    /*Calculate for n=4
    initial array [] =[1,1,2,5,0]
    we have to fill 0= for 4
    when i=4,j=1
    0+(5*1) = (a[4]+(a[4-1]*a[1-1]) =5
    5+(2*1) =(a[4]+(a[4-2]*a[2-1]) =5+2=7
    Its like i *j, where i travel from last and j travel from begin.
    like (5*1) -> (2*1)->(1*2)->(1*5)
     */

    static int numberOfBST(int n)
    {


        int dp[] = new int[n + 1];//Notice here n+1;
        Arrays.fill(dp, 0);


        dp[0] = 1;
        dp[1] = 1;


        for (int i = 2; i <= n; i++)
        {
            System.out.println(dp);
            for (int j = 1; j <= i; j++)
            {

                // n-i in right * i-1 in left
                dp[i] = dp[i] + (dp[i - j] *
                        dp[j - 1]);

            }
        }

        return dp[n];
    }

    /*
    1
2
5
14
42
     */

    public static void main(String[] args) {
        System.out.println(numberOfBST(4));

    }
}
