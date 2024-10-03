package com.example.binarysearchtree;
import java.util.ArrayList;
import java.util.List;
/**
 * @author ankush.nakaskar
 */
public class BinarySearchTree {
    public static void main(String[] args) {
        TreeNode node =TreeNode.getSampleTree();
//        node.left.left =null;
//        node.left.right =null;
//        node.right.left =null;
//        node.right.right =null;
        node.right.left.left =new TreeNode(3);
        System.out.println(isValidBST(node));
        System.out.println(TreeNode.inorderTraversal(node));
    }
    /*
                    12
                  /     \
                 5        18
               /   \      / \
              2     9    14   19
     */
    public static boolean isValidBST(TreeNode node) {
        if(node==null){
            return true;
        }
        return checkBST(node,null,null);
    }

    private static boolean checkBST(TreeNode node, Integer left, Integer right) {
        if(node==null){
            return true;
        }
       if(left!=null){
           if(!(node.val>=left)) return false;
       }
       if(right!=null){
           if(!(node.val<=right))return false;
       }
       return checkBST(node.left, left, node.val) && checkBST(node.right, node.val, right);

    }


}
