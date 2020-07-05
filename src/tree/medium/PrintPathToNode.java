package tree.medium;

import tree.TreeNode;

public class PrintPathToNode {

    public static boolean printPath(TreeNode root, int data){
        if(root==null){
            return false;
        }
        if(root.val ==data){
            System.out.println("Sample:: "+root.val);
            return true;
        }


        if(root!=null){
            if( printPath(root.left,data) || printPath(root.right,data) ){
                System.out.println(root.val);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        printPath(TreeNode.createBinaryTree3(),6);
    }
}
