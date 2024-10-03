package com.example.binarysearchtree;

/**
 * @author ankush.nakaskar
 */
public class InOrderSuccessBST {

    static class Node {
        public int val;
        public Node(int val){
            this.val=val;
        }
        public Node left;
        public Node right;
        public Node parent;
    }
    public static void main(String[] args) {

        Node node =new Node(5);
        node.left =new Node(3);
        node.left.parent =node;

        node.right =new Node(6);
        node.right.parent=node;

        node.left.right =new Node(4);
        node.left.right.parent =node.left;

        node.left.left =new Node(2);
        node.left.left.parent =node.left;
        node.left.left.left =new Node(1);
        node.left.left.left.parent =node.left.left;

        System.out.println(inorderSuccessor(node.right));
        System.out.println(inorderSuccessor(node).val);
        System.out.println(inorderSuccessor(node.left).val);
        System.out.println(inorderSuccessor(node.left.right).val);
        System.out.println(inorderSuccessor(node.left.left).val);
        System.out.println(inorderSuccessor(node.left.left.left).val);

    }

    public static Node inorderSuccessor(Node node) {
        if(node==null){
            return null;
        }
        Node curr = node;
        if(node.right==null){
            if(node.left==null){
                if(node.parent==null){
                    return null;
                }
              while(node.parent!=null && node.parent.val< curr.val){
                  node =node.parent;
              }
              if(node.parent!=null && node.parent.val> curr.val){
                node = node.parent;
                if(node.right==null){
                    return node;
                }
                if(node.right.left==null){
                    return node;
                }
                node =node.right;
                while(node.left!=null){
                    node = node.left;
                }
                return node;
              }
              if(node.val>curr.val && node.right==null){
                  return node;
              }
              if(node.val>curr.val && node.right.left==null){
                  return node;
              }
              Node rightNode = node.right.left;
              while(rightNode!=null){
                  rightNode =rightNode.left;
              }
              return rightNode;


            }else {
                if(node.parent!=null){
                    return node.parent;
                }
            }
        }else{
            Node rightNode = node.right;
            while(rightNode.left!=null){
                rightNode = rightNode.left;
            }
            return rightNode;
        }
        return null;
    }


}
