package tree.medium;


import tree.TreeNode;

public class ConstructBinayFromPostInOrder {
    public static TreeNode buildTree(int[] postorder, int[] inorder) {
        if (postorder == null || inorder == null) {
            return null;
        }
        return buildTree(postorder.length-1,inorder.length-1,0,postorder,inorder);
    }

    public static TreeNode buildTree(int postEnd,int inEnd,int inStart,int[] postorder, int[] inorder) {
        if (postorder == null || inorder == null) {
            return null;
        }
        if(postEnd<0 || inStart>inEnd){
            return null;
        }
        TreeNode root =new TreeNode(postorder[postEnd]);
        int inIndex=0;
        for(int i=inStart;i<=inEnd;i++){
            if(postorder[postEnd]==inorder[i]){
                inIndex=i;
                break;
            }
        }
        root.right =buildTree(postEnd-1,inEnd,inIndex+1,postorder,inorder);
        root.left =buildTree(postEnd-inEnd+inIndex-1,inIndex-1,inStart,postorder,inorder);
        return root;
    }
    public static void main(String[] args) {
        int[] postorder = new int[]{4, 11, 10, 16, 15, 13, 23, 25, 24, 21, 17};
        int[] inorder = new int[]{4, 10, 11, 13, 15, 16, 17, 21, 23, 24, 25};


        TreeNode root = buildTree(postorder, inorder);
        System.out.println(">>>>>");
        System.out.println(root);
    }
}
