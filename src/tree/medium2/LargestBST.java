package tree.medium2;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.TreeSet;

public class LargestBST {

    static int largetBst = 0;
    static LinkedList<Integer> list = new LinkedList<>();
    static TreeSet<Integer> set = new TreeSet<>();

    /*
    Check for in-order traversal if previous value is not less,
    then it is not BST and Mark largest til yet and init with 0
     */
    public static void largestBST(TreeNode root) {
        if (root != null) {
            largestBST(root.left);
            if (root.val > list.getLast()) {
                largetBst++;
            } else {
                set.add(largetBst);
                largetBst = 0;
            }
            list.add(root.val);
            largestBST(root.right);

        }
    }

    public static void main(String[] args) {
        list.add(Integer.MIN_VALUE);

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(4);
        largestBST(node);
        System.out.println(list);
        System.out.println(set);
    }
}
