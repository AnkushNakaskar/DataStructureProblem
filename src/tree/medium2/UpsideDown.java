package tree.medium2;

import tree.TreeNode;

import java.util.LinkedList;

//https://zhuhan0.blogspot.com/2017/05/leetcode-156-binary-tree-upside-down.html
/*

Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

Thought process:
After the flip, root and root.right will become siblings,
and the left most child will become the new root. The idea is to traverse the tree to the left. As we traverse, we make root.left the new root, root.right the left child of new root, and root itself the right child of new root.


 */
public class UpsideDown {

    public static TreeNode head=null;
    public static TreeNode start=null;
    public static TreeNode upsideDown(TreeNode root){
        upsideDownHelper(root);
        return head;
    }
    public static TreeNode upsideDownHelper(TreeNode root){
        if(root==null){
            return null;
        }
        if(root!=null){
            TreeNode left =upsideDownHelper(root.left);
            TreeNode right =upsideDownHelper(root.right);
            if(left==null && right==null){
                return root;
            }
            TreeNode node= new TreeNode(root.left.val);
            if(head==null)
            {
                head=node;
            }else {
                start.right=node;
            }
            node.left=right==null ?null :new TreeNode(right.val);
            node.right =new TreeNode(root.val);
            start=node;
            return node;
        }

        return null;
    }

    /*
    1
   / \
  2   3
 / \
4   5

     */

    public static void main(String[] args) {
        TreeNode node =new TreeNode(1);
        node.left =new TreeNode(2);
        node.right =new TreeNode(3);
        node.left.left =new TreeNode(4);
        node.left.right =new TreeNode(5);
        TreeNode response =upsideDown(node);
        System.out.println(response);

        LinkedList<Integer> list =new LinkedList<>();
        list.iterator();
    }
}
