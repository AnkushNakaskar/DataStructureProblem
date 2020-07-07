package tree.medium2;

import java.util.Stack;

public class VerifyPreOrderSequence {

    //int[] preorder = new int[]{17, 13, 10, 4, 11, 15, 16, 21, 24, 23, 25};
    public static boolean verifyPre(int[] pre) {
        if (pre == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MIN_VALUE);
        int root =Integer.MIN_VALUE;
        for (int i = 0; i < pre.length; i++) {
            if(pre[i]<root){
                return false;
            }
            while(!stack.isEmpty() && pre[i]> stack.peek()){
                root =stack.pop();
            }
            stack.push(pre[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{17, 13, 19, 4, 11, 15, 16, 21, 24, 23, 25};
        System.out.println(verifyPre(preorder));
    }
}
