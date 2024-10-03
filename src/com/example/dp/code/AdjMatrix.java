package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class AdjMatrix {

    public static int min;
    public static void main(String[] args) {
        System.out.println(updateMatrix(new int[][]{
                {0,0,0},
                {0,1,0},
                {1,1,1}
        }));
    }

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] arr = new int[m][n];

        // Initialize arr with large values for cells containing 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = mat[i][j] == 0 ? 0 : Integer.MAX_VALUE - 10000; // Avoid integer overflow
            }
        }

        // Iterate through each cell and find the minimum distance to a 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    for (int x = 0; x < m; x++) {
                        for (int y = 0; y < n; y++) {
                            if (mat[x][y] == 0) {
                                arr[i][j] = Math.min(arr[i][j], Math.abs(x - i) + Math.abs(y - j));
                            }
                        }
                    }
                }
            }
        }

        return arr;
    }

    public static int[][] updateMatrixOld(int[][] nums) {
        if(nums==null || nums.length==0){
            return nums;
        }
        int[][] res =new int[nums.length][nums[0].length];
        for(int i=0;i< nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                if(nums[i][j]!=0){
                    min =Integer.MAX_VALUE;
                    boolean[][] visited =new boolean[nums.length][nums.length];
                    dfsRecursive(nums,i,j,visited,0);
                    res[i][j]=min;
                }

            }
        }
        return res;
    }


    public static void dfsRecursive(int[][] nums,int row, int col, boolean[][] visited,int currDist) {
        if (row < 0 || col < 0 || row >= nums.length || col >= nums[0].length || visited[row][col]) {
            return;
        }
        if(nums[row][col]==0){
            min = Math.min(min,currDist);
            return;
        }
        visited[row][col] = true;
//        System.out.print(nums[row][col] + " ");
        dfsRecursive(nums,row - 1, col, visited,currDist+1); // Up
        dfsRecursive(nums,row + 1, col, visited,currDist+1); // Down
        dfsRecursive(nums,row, col - 1, visited,currDist+1); // Left
        dfsRecursive(nums,row, col + 1, visited,currDist+1); // Right


    }

    private static int help(int[][] nums, int i, int j,int currDist,boolean[][] visited) {
        if(i>=0 && i<nums[0].length && j>=0 && j<nums[0].length){
            if(nums[i][j]==0){
                return currDist+1;
            }

            int[][] dir =new int[][]{
                    {1,0},
                    {0,1},
                    {-1,0},
                    {0,-1}
            };

            for(int[] currDir : dir){
                visited[i][j]=true;
                int x = i+currDir[0];
                int y = j+currDir[1];
                if(!visited[x][y])
                    help(nums, x, y, currDist+1, visited);
            }
        }
        return currDist;
    }
}
