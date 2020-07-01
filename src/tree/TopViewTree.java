package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/* Let us construct below tree
             17
            /   \
           11     21
             \       \
              15       24
               \       /   \
               16      23   25
                             \
                             26

 */
public class TopViewTree {

    static class QueueObj {
        public Node node;
        public Integer hd;

        QueueObj(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        Queue<QueueObj> queue = new LinkedList<>();
        TreeMap<Integer, Node> map = new TreeMap<>();
        if (root == null) {
            return;
        } else {
            queue.add(new QueueObj(root, 0));
        }
        while (!queue.isEmpty()) {
            QueueObj object = queue.poll();
            if (!map.containsKey(object.hd)) {
                map.put(object.hd, object.node);
            }
            if (object.node.left != null) {
                queue.add(new QueueObj(object.node.left, object.hd - 1));
            }
            if (object.node.right != null) {
                queue.add(new QueueObj(object.node.right, object.hd + 1));
            }
        }
        map.forEach((k,y)->{
            System.out.print(y.data);
        });
    }
    public static void levelOrder(Node root) {
        if(root==null){
            return;
        }else{
            Queue<Node> queue =new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                Node node =queue.poll();
                System.out.print(node.data+" ");
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        levelOrder(Node.createBinaryTree3());
    }

}
