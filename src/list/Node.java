package list;

public class Node {
    int data;
    Node right;

    Node(int data) {
        this.data = data;
        right = null;
    }

    public static Node createRandomLinkedList() {
        Node node = new Node(7);
        node.right = new Node(13);
        node.right.right = new Node(11);
        node.right.right.right = new Node(10);
        node.right.right.right.right = new Node(1);
        return node;
    }
}
