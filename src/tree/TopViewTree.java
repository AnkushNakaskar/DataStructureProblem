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
        public TreeNode treeNode;
        public Integer hd;

        QueueObj(TreeNode treeNode, int hd) {
            this.treeNode = treeNode;
            this.hd = hd;
        }
    }

    public static void topView(TreeNode root) {
        Queue<QueueObj> queue = new LinkedList<>();
        TreeMap<Integer, TreeNode> map = new TreeMap<>();
        if (root == null) {
            return;
        } else {
            queue.add(new QueueObj(root, 0));
        }
        while (!queue.isEmpty()) {
            QueueObj object = queue.poll();
            if (!map.containsKey(object.hd)) {
                map.put(object.hd, object.treeNode);
            }
            if (object.treeNode.left != null) {
                queue.add(new QueueObj(object.treeNode.left, object.hd - 1));
            }
            if (object.treeNode.right != null) {
                queue.add(new QueueObj(object.treeNode.right, object.hd + 1));
            }
        }
        map.forEach((k,y)->{
            System.out.print(y.val);
        });
    }
    public static void levelOrder(TreeNode root) {
        if(root==null){
            return;
        }else{
            Queue<TreeNode> queue =new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                TreeNode treeNode =queue.poll();
                System.out.print(treeNode.val +" ");
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        levelOrder(TreeNode.createBinaryTree3());
    }

}
