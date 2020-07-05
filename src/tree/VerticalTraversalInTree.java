package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversalInTree {
    static class QueueObj {
        public TreeNode treeNode;
        public Integer hd;

        QueueObj(TreeNode treeNode, int hd) {
            this.treeNode = treeNode;
            this.hd = hd;
        }
    }

    public static void verticalView(TreeNode root) {
        Queue<QueueObj> queue = new LinkedList<>();
        TreeMap<Integer, List<TreeNode>> map = new TreeMap<>();
        if (root == null) {
            return;
        } else {
            queue.add(new QueueObj(root, 0));
        }
        while (!queue.isEmpty()) {
            QueueObj queueObj = queue.poll();
            if (map.containsKey(queueObj.hd)) {
                map.get(queueObj.hd).add(queueObj.treeNode);
            } else {
                List<TreeNode> list = new LinkedList<>();
                list.add(queueObj.treeNode);
                map.put(queueObj.hd, list);
            }
            if (queueObj.treeNode.left != null) {
                queue.add(new QueueObj(queueObj.treeNode.left, queueObj.hd - 1));
            }
            if (queueObj.treeNode.right != null) {
                queue.add(new QueueObj(queueObj.treeNode.right, queueObj.hd + 1));
            }

        }
        map.forEach((k, v) -> {
            v.stream().forEach((n) -> {
                System.out.print(n.val + " ");
            });
            System.out.print("||");
        });
    }

    public static void main(String[] args) {
        verticalView(TreeNode.createBinaryTree3());
    }

}
