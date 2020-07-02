package list;

public class ConvertSortedListIntoBST {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode sort(ListNode root) {
        if (root == null) {
            return null;
        }
        if (root.next == null) {
            return new TreeNode(root.val);
        }

        ListNode hare = root;
        ListNode tortoise = root;
        ListNode previous = null;
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            previous = tortoise;
            tortoise = tortoise.next;
        }
        ListNode middle = null;
        if (previous != null) {
            middle = previous.next;
            previous.next = null;
        }
        TreeNode node = new TreeNode(middle.val);
        node.left = sort(root);
        node.right = sort(middle.next);
        return node;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);

        TreeNode node = sort(root);
        System.out.println(node);

    }


}
