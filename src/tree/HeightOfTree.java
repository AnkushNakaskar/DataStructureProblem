package tree;

import java.util.LinkedList;

public class HeightOfTree {

    public static int height(Node root) {
        // Write your code here.
        int height=0;
        boolean isProcessingDone=false;
        LinkedList<Node> stack= new LinkedList<>();
        LinkedList<Node> queue= new LinkedList<>();

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
                Node node =queue.removeFirst();
                System.out.print(node.data + " ");
                if(node!=null){
                    if(node.left!=null)
                        stack.addLast(node.left);
                    if(node.right!=null)
                        stack.addLast(node.right);

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
        int height =height(Node.createBinaryTree());
        System.out.println(height);
    }
}
