package tree.medium;

import tree.Node;

public class SwapNodes {
    public static void swapNodes(Node root,Node start){
        if(root!=null){
            swapNodes(root.left,start);
            swapNodes(root.right,start);
            Node tmp =root.left;
            root.left=root.right;
            root.right=tmp;
        }
    }

    public static void main(String[] args) {
        Node start=Node.createBinaryTree2();
        Node root=Node.createBinaryTree2();
        System.out.println(root);
        swapNodes(start,start);
        System.out.println(start);
    }
}
