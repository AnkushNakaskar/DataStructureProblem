package tree.medium;

import tree.Node;

public class MaximumDepth {

    private static Integer finalValue=0;

    public static void maxDepth(Node root, int depth) {

        if (root != null) {
            maxDepth(root.left, depth++);
//            System.out.println(" max>>>>>>" + depth);
            maxDepth(root.right, depth++);
            if(depth>finalValue){
                finalValue=depth;
            }
//            System.out.println(" >>>>>>>>>max>>>>>>" + depth);

        }else{
            return ;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(9);
        node.right = new Node(20);
        node.right.left = new Node(15);
        node.right.right = new Node(7);
//        System.out.println(maxDepth(node,0));
        System.out.println();
        maxDepth(node,0);
        System.out.println("final value ::: "+finalValue);
        maxDepth(Node.createBinaryTree3(), 0);
        System.out.println("final value ::: "+finalValue);
        maxDepth(Node.createBinaryTree3(), 0);
        System.out.println("final value ::: "+finalValue);

    }
}
