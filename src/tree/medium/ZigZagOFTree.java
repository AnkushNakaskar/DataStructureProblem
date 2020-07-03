package tree.medium;

import tree.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagOFTree {


    private static void zigZagOfTree(Node root) {
        LinkedList<Node> q1 = new LinkedList<>();
        LinkedList<Node> q2 = new LinkedList<>();
        if (root == null) {
            return;
        }
        q1.add(root);
        while (true) {
            if (q1.isEmpty() && q2.isEmpty()) {
                break;
            }
            while (!q1.isEmpty()) {
                Node node = q1.removeLast();
                System.out.println(node.data);
                if (node.right != null)
                    q2.add(node.right);
                if (node.left != null)
                    q2.add(node.left);
            }
            while(!q2.isEmpty()){
                Node node = q2.removeLast();
                System.out.println(node.data);
                if (node.left != null)
                    q1.add(node.left);
                if (node.right != null)
                    q1.add(node.right);
            }
        }

    }

    public static void main(String[] args) {
        zigZagOfTree(Node.createBinaryTree2());
    }
}
