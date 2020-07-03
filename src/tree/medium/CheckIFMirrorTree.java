package tree.medium;

import tree.Node;

import javax.swing.tree.TreeNode;

public class CheckIFMirrorTree {

    public static boolean checkMirror(Node p, Node q) {
        if (p == null && q != null) {
            return false;
        }
        if(p!=null && q==null){
            return false;
        }
        if(p!=null && q!=null){
            if(p.data!=q.data){
                return false;
            }
            return checkMirror(p.left,q.right) && checkMirror(p.right,q.left);
        }
        return true;
    }

    public boolean isSymmetric(Node root) {
        if(root!=null){
            return checkMirror(root.left,root.right);
        }
        return true;
    }

    public static void main(String[] args) {
        Node node =Node.createNotBinarySearchTreeNotMirror();
        System.out.println(checkMirror(node.left,node.right));


    }
}
