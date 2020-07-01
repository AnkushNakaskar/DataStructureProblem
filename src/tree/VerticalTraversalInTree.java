package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversalInTree {
    static class QueueObj {
        public Node node;
        public Integer hd;

        QueueObj(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void verticalView(Node root) {
        Queue<QueueObj> queue = new LinkedList<>();
        TreeMap<Integer, List<Node>> map = new TreeMap<>();
        if (root == null) {
            return;
        } else {
            queue.add(new QueueObj(root, 0));
        }
        while (!queue.isEmpty()) {
            QueueObj queueObj = queue.poll();
            if (map.containsKey(queueObj.hd)) {
                map.get(queueObj.hd).add(queueObj.node);
            } else {
                List<Node> list = new LinkedList<>();
                list.add(queueObj.node);
                map.put(queueObj.hd, list);
            }
            if (queueObj.node.left != null) {
                queue.add(new QueueObj(queueObj.node.left, queueObj.hd - 1));
            }
            if (queueObj.node.right != null) {
                queue.add(new QueueObj(queueObj.node.right, queueObj.hd + 1));
            }

        }
        map.forEach((k, v) -> {
            v.stream().forEach((n) -> {
                System.out.print(n.data + " ");
            });
            System.out.print("||");
        });
    }

    public static void main(String[] args) {
        verticalView(Node.createBinaryTree3());
    }

}
