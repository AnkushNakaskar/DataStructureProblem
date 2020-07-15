package array.hard;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        for (int i = 1; i < heights.length; i++) {
            int curr =heights[i];
            if(curr>=heights[stack.peek()]){
                stack.add(i);
            }else{
                while(!stack.isEmpty() && curr<=heights[stack.peek()]){
                    int top =stack.pop();
                    if(stack.isEmpty() ){
                        int area =heights[top]*i;
                        max =Math.max(area,max);
                    }else{
                        int area =heights[top]*(i-stack.peek()-1);
                        max =Math.max(max,area);
                    }
                }
                stack.add(i);
            }

        }
        if(!stack.isEmpty()){
            int i=heights.length;
            while(!stack.isEmpty()){
                int top =stack.pop();
                if(stack.isEmpty() ){
                    int area =heights[top]*i;
                    max =Math.max(area,max);
                }else{
                    int area =heights[top]*(i-stack.peek()-1);
                    max =Math.max(max,area);
                }
            }
        }




        System.out.println("MAX :::: "+max);
        return max;
    }

    public static void main(String[] args) {
        int[]a =new int[]{2,1,5,6,2,3};
//        int[]a =new int[]{1,2,4};
        new LargestRectangleInHistogram().largestRectangleArea(a);
    }
}
