package tree.medium;

import tree.TreeNode;

public class ConvertSortedArrayIntoBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null)
            return null;
        return sortedArrayToBST(0,nums.length-1,nums);
    }
    public static TreeNode sortedArrayToBST(int start,int end,int[] nums) {
        if(start>end){
            return null;
        }
        int mid=(end+start)/2;
        TreeNode root =new TreeNode(nums[mid]);
        root.left =sortedArrayToBST(start,mid-1,nums);
        root.right =sortedArrayToBST(mid+1,end,nums);
        return root;
    }

    public static TreeNode sortedArrayToBST(int arr[], int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }

    public static void main(String[] args) {
        int[] a =new int[]{-10,-3,0,5,9};
//        int a[] = new int[]{1, 2, 3, 4, 5, 6, 7};


        TreeNode node =sortedArrayToBST(a);
//        TreeNode node =sortedArrayToBST(a,0,a.length-1);
        System.out.println(node);
    }
}
