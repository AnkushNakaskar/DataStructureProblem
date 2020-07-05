package tree;

import java.util.LinkedList;

public class HeightOfTree {

    public static int height(TreeNode root) {
        // Write your code here.
        int height=0;
        boolean isProcessingDone=false;
        LinkedList<TreeNode> stack= new LinkedList<>();
        LinkedList<TreeNode> queue= new LinkedList<>();

        if(root!=null){
            stack.addLast(root);
        }else{
            return 0;
        }
        while(!isProcessingDone){
            while(!stack.isEmpty()){
                queue.addLast(stack.removeLast());
            }
            while(!queue.isEmpty()){
                TreeNode treeNode =queue.removeFirst();
                System.out.print(treeNode.val + " ");
                if(treeNode !=null){
                    if(treeNode.left!=null)
                        stack.addLast(treeNode.left);
                    if(treeNode.right!=null)
                        stack.addLast(treeNode.right);

                }

            }
            System.out.println();
            if(!stack.isEmpty()){
                height++;
            }else{
                isProcessingDone=true;
            }
        }
        return height;
    }

    public static void main(String[] args) {
        int height =height(TreeNode.createBinaryTree());
        System.out.println(height);
    }
}
