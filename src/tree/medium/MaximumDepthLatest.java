package tree.medium;

import tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class MaximumDepthLatest {

    public static boolean printPath(TreeNode root, Set<TreeNode> set, boolean isLeft){
        if(root==null){
            return true;
        }
//        if(root.left==null && root.right==null){
//            System.out.println("Sample:: "+root.data);
//            return true;
//        }


        if(root!=null){


            if( isLeft && printPath(root.left,set,isLeft)){
                System.out.println(root.val);
                set.add(root);
                return true;
            }else if ( !isLeft && printPath(root.right,set,isLeft)){
                System.out.println(root.val);
                set.add(root);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        printPath(TreeNode.createBinaryTree3());

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        Set<TreeNode> setLeft =new HashSet<>();
        Set<TreeNode> setRight =new HashSet<>();
        printPath(treeNode,setLeft,true);
        setLeft.forEach(System.out::println);
        System.out.println("<><><>>MM<MM");
        printPath(treeNode,setRight,false);
        setRight.forEach(System.out::println);

        System.out.println("Maximum depth value is the set with largest one :: "+setRight);
    }
}
