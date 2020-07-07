package tree.medium2;

import tree.TreeNode;

import java.util.TreeSet;

public class LongestConsecutivePath {

    static int longestPath = 1;
    static TreeSet<Integer> set = new TreeSet<>();

    public static void longLatest(TreeNode root, int value) {
        if (root != null) {
            longLatest(root.left, root.val+1);
            longLatest(root.right, root.val+1);
            if(root.val==value){
                longestPath++;
            }else{
                set.add(longestPath);
                longestPath=1;
            }
        }

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(10);
        root.right.right.right = new TreeNode(11);
        root.right.right.right.right = new TreeNode(17);
        longLatest(root,6);
        System.out.println(set);
    }
}
