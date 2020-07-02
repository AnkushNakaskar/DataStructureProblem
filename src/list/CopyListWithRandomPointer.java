package list;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int data) {
            this.val = data;
            next = null;
            random = null;
        }

        public static Node createRandomLinkedList() {
            Node node = new Node(7);
            node.next = new Node(13);
            node.next.random = node;
            node.next.next = new Node(11);

            node.next.next.next = new Node(10);
            node.next.next.next.random = node.next.next;
            node.next.next.next.next = new Node(1);
            node.next.next.random = node.next.next.next.next;
            return node;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> nodeMap = new HashMap<>();
        Node start = head;
        while (start != null) {
            nodeMap.put(start, new Node(start.val));
            start = start.next;
        }
        Node root = null;
        while (head != null) {
            Node trav = nodeMap.get(head);
            if (root == null) {
                root = trav;
            }
            if (head.next != null)
                trav.next = nodeMap.get(head.next);
            if (head.random != null) {
                trav.random = nodeMap.get(head.random);
            }
            head=head.next;
        }
        return root;
    }

    public static void main(String[] args) {
        Node sample = copyRandomList(Node.createRandomLinkedList());
        System.out.println(sample);
    }

}
