package tree.medium;

import tree.Node;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumDepthLatest {

    public static boolean printPath(Node root, Set<Node> set,boolean isLeft){
        if(root==null){
            return true;
        }
//        if(root.left==null && root.right==null){
//            System.out.println("Sample:: "+root.data);
//            return true;
//        }


        if(root!=null){


            if( isLeft && printPath(root.left,set,isLeft)){
                System.out.println(root.data);
                set.add(root);
                return true;
            }else if ( !isLeft && printPath(root.right,set,isLeft)){
                System.out.println(root.data);
                set.add(root);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        printPath(Node.createBinaryTree3());

        Node node = new Node(3);
        node.left = new Node(9);
        node.right = new Node(20);
        node.right.left = new Node(15);
        node.right.right = new Node(7);
        Set<Node> setLeft =new HashSet<>();
        Set<Node> setRight =new HashSet<>();
        printPath(node,setLeft,true);
        setLeft.forEach(System.out::println);
        System.out.println("<><><>>MM<MM");
        printPath(node,setRight,false);
        setRight.forEach(System.out::println);

        System.out.println("Maximum depth value is the set with largest one :: "+setRight);
    }
}
