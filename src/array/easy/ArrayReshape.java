package array.easy;

public class ArrayReshape {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int cc =nums.length;
        int cr=nums[0].length;
        if((cc*cr) !=(c*r)){
            return nums;
        }
        int p=0;//row in new
        int q=0;//column in new
        int[][] result =new int[r][c];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                if(q>=c){
                    p++;
                    q=0;
                }
                result[p][q++] =nums[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a =new int[][]{{1,2},{3,4}};

        new ArrayReshape().matrixReshape(a,4,1);
    }
}
