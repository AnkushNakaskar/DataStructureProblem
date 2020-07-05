package tree;



public class ConstructBinayFromPreInOrder {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return buildTree(0,0,inorder.length-1,preorder,inorder);
    }

    public static TreeNode buildTree(int preStart,int inStart,int inEnd,int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if(preStart>preorder.length-1 || inStart>inEnd){
            return null;
        }
        TreeNode root =new TreeNode(preorder[preStart]);
        int inIndex=0;
        for(int i=inStart;i<=inEnd;i++){
            if(preorder[preStart]==inorder[i]){
                inIndex=i;
                break;
            }
        }
        root.left=buildTree(preStart+1,inStart,inIndex-1,preorder,inorder);
        root.right=buildTree(preStart+inIndex-inStart+1,inIndex+1,inEnd,preorder,inorder);
        //preStart+inIndex-inStart+1 : Focus on this formula, Get pen and paper , try how inIndex will be useful to find out right child in pre-order
        return root;
    }
    public static void main(String[] args) {
        int[] preorder = new int[]{17, 13, 10, 4, 11, 15, 16, 21, 24, 23, 25};
        int[] inorder = new int[]{4, 10, 11, 13, 15, 16, 17, 21, 23, 24, 25};


        TreeNode root = buildTree(preorder, inorder);
        System.out.println(">>>>>");
        System.out.println(root);
    }
}
