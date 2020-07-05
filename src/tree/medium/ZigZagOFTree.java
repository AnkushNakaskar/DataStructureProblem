package tree.medium;

import tree.TreeNode;

import java.util.LinkedList;

public class ZigZagOFTree {


    private static void zigZagOfTree(TreeNode root) {
        LinkedList<TreeNode> q1 = new LinkedList<>();
        LinkedList<TreeNode> q2 = new LinkedList<>();
        if (root == null) {
            return;
        }
        q1.add(root);
        while (true) {
            if (q1.isEmpty() && q2.isEmpty()) {
                break;
            }
            while (!q1.isEmpty()) {
                TreeNode treeNode = q1.removeLast();
                System.out.println(treeNode.val);
                if (treeNode.right != null)
                    q2.add(treeNode.right);
                if (treeNode.left != null)
                    q2.add(treeNode.left);
            }
            while(!q2.isEmpty()){
                TreeNode treeNode = q2.removeLast();
                System.out.println(treeNode.val);
                if (treeNode.left != null)
                    q1.add(treeNode.left);
                if (treeNode.right != null)
                    q1.add(treeNode.right);
            }
        }

    }

    public static void main(String[] args) {
        zigZagOfTree(TreeNode.createBinaryTree2());
    }
}
