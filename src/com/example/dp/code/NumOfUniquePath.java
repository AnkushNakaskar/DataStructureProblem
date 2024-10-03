package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class NumOfUniquePath {
    public static void main(String[] args) {
//        System.out.println(uniquePaths(3,2));
//        System.out.println(uniquePaths(3,7));
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        }));
        System.out.println(uniquePathsWithObstacles(new int[][]{

                {0,1},
                {0,0}
        }));
    }
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    dp[i][j]=1;
                }else{
                    dp[i][j] =dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static int uniquePathsWithObstacles(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    if(nums[i][j]==1){
                        dp[i][j]=-1;
                    }else if(i==0 && j>0 && dp[i][j-1]==-1){
                        dp[i][j]=-1;
                    }else if(j==0 && i>0 && dp[i-1][j]==-1){
                        dp[i][j]=-1;
                    }else{
                        dp[i][j]=1;
                    }
                }else{
                    if(nums[i][j]==1){
                        dp[i][j] =-1;
                    }else{
                        int above = dp[i-1][j] == -1 ? 0: dp[i-1][j];
                        int down = dp[i][j-1] == -1 ? 0: dp[i][j-1];
                        dp[i][j] =above + down;
                    }

                }
            }
        }
        return dp[m-1][n-1] ==-1 ? 0 : dp[m-1][n-1];
    }
}
