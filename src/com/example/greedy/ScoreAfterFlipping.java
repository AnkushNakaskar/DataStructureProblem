package com.example.greedy;

/**
 * @author ankush.nakaskar
 */
public class ScoreAfterFlipping {
    public static void main(String[] args) {
        System.out.println(matrixScore(new int[][]{
                {0,0,1,1},
                {1,0,1,0},
                {1,1,0,0}
        }));
    }
    public static int matrixScore(int[][] grid) {
        int noOfRow = grid.length;
        for(int i=0;i<noOfRow;i++){
            if(grid[i][0]==0){
                int noOfCol = grid[i].length;
                for(int j=0;j<noOfCol;j++){
                    grid[i][j]=grid[i][j]==1 ? 0:1;
                }
            }
        }
        int noOfCol = grid[0].length;
        for(int j=1;j<noOfCol;j++){
            int noOfZero =0;
            int noOfOnes =0;
            for(int i=0;i<noOfRow;i++){
                if(grid[i][j]==1){
                    noOfOnes++;
                }else{
                    noOfZero++;
                }
            }
            if(noOfZero>noOfOnes){
                for(int i=0;i<noOfRow;i++){
                    grid[i][j]=grid[i][j]==1 ? 0:1;
                }
            }

        }
        int sum=0;
        for(int i=0;i<noOfRow;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<noOfCol;j++){
                sb.append(grid[i][j]);
            }
            sum+=Integer.parseInt(sb.toString(), 2);
        }

        return sum;
    }
}
