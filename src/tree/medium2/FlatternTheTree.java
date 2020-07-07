package tree.medium2;

import tree.TreeNode;

public class FlatternTheTree {

    static TreeNode head = new TreeNode(-1);
    static TreeNode start=head;
    public static void flatten(TreeNode root) {
        if(root!=null) {
            preOrder(root);
            if (root.right != null || root.left != null) {
                root.right = head.right.right;
                root.left = null;
            }
        }

    }
    public static void preOrder(TreeNode root){
        if(root!=null){
            start.right =new TreeNode(root.val);
            start=start.right;
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
/*

    1
   / \
  2   5
 / \   \
3   4   6
 */
    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        root.left =new TreeNode(2);
        root.right =new TreeNode(5);
        root.left.left =new TreeNode(3);
        root.left.right =new TreeNode(4);
        root.right.right =new TreeNode(6);
        flatten(root);
        System.out.println(head);

        preOrder(root);
    }
}
