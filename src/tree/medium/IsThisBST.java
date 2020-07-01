package tree.medium;

import tree.Node;

public class IsThisBST {

    static boolean checkBST(Node root) {
        if(root!=null){
            if(root.left!=null && root.left.data>root.data){
                return false;
            }else if(root.left!=null && root.right.data<root.data){
                return false;
            }
            return checkBST(root.left) && checkBST(root.right);
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(checkBST(Node.createNotBinarySearchTree()));
    }
}
