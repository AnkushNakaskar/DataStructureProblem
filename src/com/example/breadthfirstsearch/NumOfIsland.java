package com.example.breadthfirstsearch;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author ankush.nakaskar
 */
public class NumOfIsland {
    //    Any 1 surrounded by O & 1 both : mark it T , If any 1 surrounded by all either O & T, count this as island use the visited graph
    public static void main(String[] args) {
        char[][] nums = new char[][]{
                {'1','1','1','1','1'},
                {'1','1','1','1','1'},
                {'1','1','1','1','1'},
                {'1','1','1','1','1'},
        };
        System.out.println(numIslands(nums));
    }
    public static int numIslands(char[][] nums) {
        int res = 0;
        boolean[][] visisted = new boolean[nums.length][nums[0].length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                if(!visisted[i][j] && nums[i][j]=='1'){
                    helper(i,j,visisted,nums);
                    res++;
                    visisted[i][j]=true;
                }
            }
        }
        return res;
    }

    private static void helper(int i, int j, boolean[][] visisted, char[][] nums) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dirs = new int[][]{
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            if (visisted[x][y] || nums[x][y]!='1') {
                continue;
            }
            for (int p = 0; p < dirs.length; p++) {
                int m = x + dirs[p][0];
                int n = y + dirs[p][1];
                if (m < 0 || n < 0 || m >= nums.length || n >= nums[0].length) {
                    continue;
                }
                if(nums[m][n]=='1' && !visisted[m][n]){
                    queue.add(new int[]{m,n});
                }
            }
            visisted[x][y]=true;
        }
    }

    public static int numIslandsOld(char[][] nums) {
        int res = 0;
        boolean[][] visisted = new boolean[nums.length][nums[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dirs = new int[][]{
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            if (visisted[x][y]) {
                continue;
            }
            boolean isZero = false;
            boolean isT = false;
            boolean isOne = false;
            for (int i = 0; i < dirs.length; i++) {
                int m = x + dirs[i][0];
                int n = y + dirs[i][1];
                if (m < 0 || n < 0 || m >= nums.length || n >= nums[0].length) {
                    continue;
                }
                if (nums[m][n] == 'O' && !isZero) {
                    isZero = true;
                } else if (nums[m][n] == '1' && !isOne) {
                    isOne = true;
                } else if (nums[m][n] == 'T' && !isT) {
                    isT = true;
                }

                queue.add(new int[]{m, n});
            }
            if (nums[x][y] == '1') {
                if (x == 0 || y == 0 || x == nums.length - 1 || y == nums[0].length - 1) {
                    isZero = true;
                }
                if ((isZero && isOne && isT) || (isZero && isOne)) {
                    nums[x][y] = 'T';
                } else if ((isZero && isT) || (isZero && !isT && !isOne)) {
                    res++;
                }

            }
            visisted[x][y] = true;
        }
        return res;
    }
}
