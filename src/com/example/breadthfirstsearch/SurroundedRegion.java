package com.example.breadthfirstsearch;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author ankush.nakaskar
 */
public class SurroundedRegion {

    public static void main(String[] args) {
//        char[][] nums = new char[][]{
//                {'X','X','X','X'},
//                {'X','O','O','X'},
//                {'X','X','O','X'},
//                {'X','O','X','X'}
//        };
        char[][] nums = new char[][]{
                {'O','X','X','O','X'},
                {'X','X','X','X','O'},
                {'X','X','X','X','X'},
                {'O','X','X','X','O'},
                {'X','X','O','X','O'}
        };
        solve(nums);
        for(int i=0;i< nums.length;i++){
            for(int j=0;j< nums[i].length;j++){
                System.out.print(" "+nums[i][j]);
            }
            System.out.println();
        }
    }
    public static void solve(char[][] nums) {
        boolean[][] visited = new boolean[nums.length][nums[0].length];
        Queue<int[]> queue =new ArrayDeque<>();
        queue.add(new int[]{1,1});
        int[][] dirs = new int[][]{
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
        };

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            int x=curr[0];
            int y = curr[1];
            for(int i=0;i< dirs.length;i++){
                int m = x+dirs[i][0];
                int n = y+dirs[i][1];
                if(x==1 && y==2){
                    System.out.println();
                }
                if(m<0 || n<0 || m>= nums.length || n>=nums[0].length){
                    continue;
                }
                if(visited[x][y]){
                    continue;
                }
                if(nums[m][n]=='X' && nums[x][y]!='X'){

                    if(nums[x][y]!='X'){
                        nums[x][y]='X';
                    }
                }
                 if(m==0 || n==0 || m== nums.length-1 || n==nums[0].length-1){
                        continue;
                    }
                queue.add(new int[]{m,n});
            }
            visited[x][y]=true;
        }
    }
}
