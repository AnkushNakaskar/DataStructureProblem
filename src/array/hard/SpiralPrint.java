package array.hard;

import java.util.LinkedList;
import java.util.List;

public class SpiralPrint {
    public List<Integer> spiralOrder(int[][] a) {
        int rs = 0; //Staring of row index
        int re = 3;//ending of row index
        int cs = 0; // starting of column index
        int ce = 3;//ending of column index

        /*
        condition says, row index is less than re  and column index is less than column end
         */
        List<Integer> list =new LinkedList<>();
        while (rs < re && cs < ce) {
            //print the first row
            for(int i=cs;i<ce;i++){
                System.out.print(a[rs][i] + " ");
                list.add(a[rs][i]);
            }
            rs++;
            //print the last column
            for(int i=rs;i<re;i++){
                System.out.print(a[i][ce-1] + " ");
                list.add(a[i][ce-1]);
            }
            ce--;

            //print last row
            if(rs<re){
                for(int i=ce-1;i>=cs;i--){
                    System.out.print(a[re-1][i] + " ");
                    list.add(a[re-1][i]);
                }
                re--;
            }

            //print the first column
            if(cs<ce){
                for(int i=re-1;i>=rs;i--){
                    System.out.print(a[i][cs] + " ");
                    list.add(a[i][cs]);
                }
                cs++;
            }
        }
        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {

        int[][] a = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
//        new SpiralPrint().spiralOrder(a);
        new SpiralPrint().rotate(a);
    }

    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
        System.out.println(matrix);
    }
}
