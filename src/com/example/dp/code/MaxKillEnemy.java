package com.example.dp.code;

import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class MaxKillEnemy {

    public static void main(String[] args) {

        System.out.println(maxKilledEnemies(new char[][]{
                {'W','E','E','E','E','0','E','E','E','E','E','W'}
        }));
        System.out.println(maxKilledEnemies(new char[][]{
                {'W'},
                {'E'},
                {'E'},
                {'E'},{'E'},{'0'},{'E'},{'E'},{'E'},{'E'},{'E'},{'W'}
        }));

        System.out.println(maxKilledEnemies(new char[][]{
                {'E'}
        }));

        System.out.println(maxKilledEnemies(new char[][]{
                {'0','E','0','0'},
                {'E','0','W','E'},
                {'0','E','0','0'}
        }));

        System.out.println(maxKilledEnemies(new char[][]{
                {'W','W','W','W'},
                {'0','0','0','0'},
                {'E','E','E','E'}
        }));

    }
    public static int maxKilledEnemies(char[][] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int max =0;
        PriorityQueue<int[]> queue =new PriorityQueue<>((a,b)->{
            return (b[2]+b[3])-(a[2]+a[3]);
        });
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                if(nums[i][j]=='0'){
//                    traverseRow
                    int rowCount = traverseRow(nums,i,j);
                    int columnCount = traverseColumn(nums,i,j);
                    queue.add(new int[]{i,j,rowCount,columnCount});

                }
            }
        }
        if(queue.isEmpty()) return 0;
        int[] maxValue = queue.poll();
        return maxValue[2]+maxValue[3];
    }

    private static int traverseColumn(char[][] nums, int rowIndex,int columnIndex) {
        int count =0;
      for(int j=rowIndex;rowIndex<nums.length && j<nums.length && columnIndex<nums[j].length;j++){
          if(nums[j][columnIndex]=='0'){
              continue;
          }
          if(nums[j][columnIndex]=='E'){
              count++;
              continue;
          }
          if(nums[j][columnIndex]=='W')break;
      }
        for(int j=rowIndex;rowIndex<nums.length && j>=0 && columnIndex<nums[j].length;j--){
            if(nums[j][columnIndex]=='0'){
                continue;
            }
            if(nums[j][columnIndex]=='E'){
                count++;
                continue;
            }
            if(nums[j][columnIndex]=='W')break;
        }
        return count;
    }
//                {'W','E','E','E','E','0','E','E','E','E','E','W'}
    private static int traverseRow(char[][] nums, int rowIndex,int columnIndex) {
        int count =0;
        for(int j=columnIndex;rowIndex<nums.length && j<nums[rowIndex].length;j++){
            if(nums[rowIndex][j]=='0'){
                continue;
            }
            if(nums[rowIndex][j]=='E'){
                count++;
                continue;
            }
            if(nums[rowIndex][j]=='W')break;
        }
        for(int j=columnIndex;rowIndex<nums.length && columnIndex<nums[rowIndex].length && j>=0;j--){
            if(nums[rowIndex][j]=='0'){
                continue;
            }
            if(nums[rowIndex][j]=='E'){
                count++;
                continue;
            }
            if(nums[rowIndex][j]=='W')break;
        }
        return count;
    }
}
