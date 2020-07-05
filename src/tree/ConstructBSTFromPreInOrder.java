package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConstructBSTFromPreInOrder {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }

        List<Integer> p = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        List<Integer> q = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        TreeNode root = null;
        TreeNode start = null;
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < p.size() - 1; i++) {
            int data = p.get(i);
            if (root == null) {
                root = new TreeNode(data);
                start = root;
                map.put(data, root);
            } else {
                start = map.get(data);
            }
            if (p.get(i + 1) < data) {
                TreeNode treeNode = new TreeNode(p.get(i + 1));
                map.put(treeNode.val, treeNode);
                start.left = treeNode;
            }
            if (p.get(i + 1) > data && (!map.containsKey(p.get(i + 1)))) {
                TreeNode treeNode = new TreeNode(p.get(i + 1));
                map.put(treeNode.val, treeNode);
                start.right = treeNode;
            } else {
                int inorderIndex = q.indexOf(data);
                if (inorderIndex < q.size() - 1) {
                    if (q.get(inorderIndex + 1) > data && (!map.containsKey(q.get(inorderIndex + 1)))) {
                        TreeNode treeNode = new TreeNode(q.get(inorderIndex + 1));
                        map.put(treeNode.val, treeNode);
                        start.right = treeNode;
                    }
                }

            }
        }


        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{17, 13, 10, 4, 11, 15, 16, 21, 24, 23, 25};
        int[] inorder = new int[]{4, 10, 11, 13, 15, 16, 17, 21, 23, 24, 25};


        TreeNode root = buildTree(preorder, inorder);
        System.out.println(">>>>>");
        System.out.println(root);

    }
}
