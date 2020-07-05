package tree.medium;

import tree.TreeNode;
//https://www.hackerrank.com/challenges/tree-huffman-decoding/problem
public class HuffmanCoding {
    public static void decode(String s, TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode start = root;
        for (String value : s.split("")) {
            if ("1".equals(value)) {
                start = start.right;
            } else {
                start = start.left;
            }
            if (start.left == null && start.right == null) {
                System.out.print(" " + start.val);
                start = root;
            }
        }
    }

    public static void main(String[] args) {
        decode("1001011", TreeNode.createBinaryTree3());
    }
}
