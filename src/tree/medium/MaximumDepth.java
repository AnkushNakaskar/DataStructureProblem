package tree.medium;

import tree.TreeNode;

public class MaximumDepth {

    private static Integer finalValue=0;

    public static void maxDepth(TreeNode root, int depth) {

        if (root != null) {
            maxDepth(root.left, depth++);
//            System.out.println(" max>>>>>>" + depth);
            maxDepth(root.right, depth++);
            if(depth>finalValue){
                finalValue=depth;
            }
//            System.out.println(" >>>>>>>>>max>>>>>>" + depth);

        }else{
            return ;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
//        System.out.println(maxDepth(treeNode,0));
        System.out.println();
        maxDepth(treeNode,0);
        System.out.println("final value ::: "+finalValue);
        maxDepth(TreeNode.createBinaryTree3(), 0);
        System.out.println("final value ::: "+finalValue);
        maxDepth(TreeNode.createBinaryTree3(), 0);
        System.out.println("final value ::: "+finalValue);

    }
}
