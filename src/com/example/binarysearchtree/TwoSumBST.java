package com.example.binarysearchtree;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ankush.nakaskar
 */
public class TwoSumBST {

    public static Set<Integer> set ;

    public static void main(String[] args) {
        TreeNode node =TreeNode.getSampleTree();

        System.out.println(findTarget(node,21));
        System.out.println(findTarget(node,24));
        System.out.println(findTarget(node,25));
        System.out.println(findTarget(node,11));
    }
    public static boolean findTarget(TreeNode root, int k) {
        set =new HashSet<>();
        return extracted(root, k);

    }

    /*
                12
              /     \
             5        18
           /   \      / \
          2     9    14   19
 */
    private static boolean extracted(TreeNode root, int k) {
        if(root !=null){
            if(set.contains(Math.abs(k - root.val))){
                return true;
            }else{
                set.add(root.val);
            }
            return extracted(root.left, k) || extracted(root.right, k);
        }


        return false;
    }
}
