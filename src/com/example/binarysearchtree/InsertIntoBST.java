package com.example.binarysearchtree;

/**
 * @author ankush.nakaskar
 */
public class InsertIntoBST {

    public static void main(String[] args) {
        TreeNode node = TreeNode.getSampleTree();
        System.out.println(TreeNode.inorderTraversal(node));
        TreeNode resNode = insertIntoBST(node,17);
        System.out.println(TreeNode.inorderTraversal(resNode));
    }
    public static TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode node =root;
        if(node==null){
            return new TreeNode(val);
        }
        insertInBST(node,val);
        return root;
    }
    /*
                    12
                  /     \
                 5        18
               /   \      / \
              2     9    14   19
     */
    private static TreeNode insertInBST(TreeNode node, int val) {
        if(node==null){
            return new TreeNode(val);
        }
        if(val<node.val){
            node.left = insertInBST(node.left,val);
        }else{
            node.right =insertInBST(node.right,val);
        }
        return node;
    }
}
