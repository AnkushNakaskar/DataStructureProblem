package tree.medium;

import tree.Node;
//https://www.hackerrank.com/challenges/tree-huffman-decoding/problem
public class HuffmanCoding {
    public static void decode(String s, Node root) {
        if (root == null) {
            return;
        }
        Node start = root;
        for (String value : s.split("")) {
            if ("1".equals(value)) {
                start = start.right;
            } else {
                start = start.left;
            }
            if (start.left == null && start.right == null) {
                System.out.print(" " + start.data);
                start = root;
            }
        }
    }

    public static void main(String[] args) {
        decode("1001011", Node.createBinaryTree3());
    }
}
