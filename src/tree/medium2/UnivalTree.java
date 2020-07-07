package tree.medium2;

import tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class UnivalTree {

    static int uniVal = 0;
/*
This question was asked in Google
       https://www.dailycodingproblem.com/blog/unival-trees/
 */

    public static void unival(TreeNode root) {

        if (root != null) {
            unival(root.left);
            unival(root.right);
            Set<Integer> nodes = new HashSet<>();
            helper(root, nodes);
            if (nodes.size() == 1) {
                uniVal = uniVal + 1;
            }
        }
    }

    public static void helper(TreeNode root, Set<Integer> nodes) {
        if (root == null) {
            return;
        }
        helper(root.left, nodes);
        helper(root.right, nodes);
        nodes.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(1);
        node.left = new TreeNode(1);
        node.right.right = new TreeNode(1);
        node.right.left = new TreeNode(1);
        node.right.right.right = new TreeNode(2);
        unival(node);
        System.out.println(uniVal);
        uniVal = 0;


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right.right = new TreeNode(2);
        unival(root);
        System.out.println(uniVal);

    }
}
