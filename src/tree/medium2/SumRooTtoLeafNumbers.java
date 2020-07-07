package tree.medium2;

import tree.TreeNode;

public class SumRooTtoLeafNumbers {

    static int sum;
    public static int sumNumbers(TreeNode root) {
        sum =0;
        String s =new String();
        leafSum(root,s);
        return sum;
    }
    public static void  leafSum(TreeNode root,String value) {
        if(root==null){
            return ;
        }

        leafSum(root.left, value+root.val);
        leafSum(root.right, value+root.val);
        if(root.left==null && root.right==null){
            System.out.println("Value ::"+root.val + ":: " +(value+root.val));
            sum=sum+Integer.parseInt(value+root.val);
            System.out.println("Sum :: "+sum);
        }
    }

    public static void main(String[] args) {
        /*
   -10
   / \
  9  20
    /  \
   15   7

   */
//        TreeNode node = new TreeNode(-10);
//        node.left = new TreeNode(9);
//        node.right = new TreeNode(20);
//        node.right.right = new TreeNode(7);
//        node.right.left = new TreeNode(15);
//        System.out.println(sumNumbers(node));




        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        System.out.println(sumNumbers(node1));

    }
}
