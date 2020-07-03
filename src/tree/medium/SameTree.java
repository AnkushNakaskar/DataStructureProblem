package tree.medium;

import tree.Node;

public class SameTree {

    public static boolean isSameTree(Node p, Node q) {
        if (p == null & q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p != null && q != null) {
            if (p.data != q.data) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return true;
    }

    public static void main(String[] args) {
        Node t1 = Node.createBinaryTree();
        Node t2 = Node.createBinaryTree();
        System.out.println(isSameTree(t1, t2));
    }

}
