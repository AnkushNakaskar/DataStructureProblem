package tree.medium;

import tree.Node;

public class PrintPathToNode {

    public static boolean printPath(Node root,int data){
        if(root==null){
            return false;
        }
        if(root.data==data){
            System.out.println("Sample:: "+root.data);
            return true;
        }


        if(root!=null){
            if( printPath(root.left,data) || printPath(root.right,data) ){
                System.out.println(root.data);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        printPath(Node.createBinaryTree3(),6);
    }
}
