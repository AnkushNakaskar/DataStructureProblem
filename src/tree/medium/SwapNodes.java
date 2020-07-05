package tree.medium;

import tree.TreeNode;

public class SwapNodes {
    public static void swapNodes(TreeNode root, TreeNode start){
        if(root!=null){
            swapNodes(root.left,start);
            swapNodes(root.right,start);
            TreeNode tmp =root.left;
            root.left=root.right;
            root.right=tmp;
        }
    }

    public static void main(String[] args) {
        TreeNode start= TreeNode.createBinaryTree2();
        TreeNode root= TreeNode.createBinaryTree2();
        System.out.println(root);
        swapNodes(start,start);
        System.out.println(start);
    }
}
