package tree;

/*
Image method1 file


/* Let us construct below tree
             17
            /   \
           11     21
             \       \
              15       24
               \       /   \
               16      23   25
                             \
                             26

 */
public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

     /*
        17
      /       \
    11           21
      \            \
       15         24
        \        /    \
       16      23    25
                            \
                            26

 */

    public static Node createBinaryTree() {
        Node root = new Node(17);
        Node elev = new Node(11);
        root.left = elev;
        elev.right = new Node(15);
        elev.right.right = new Node(16);

        root.right = new Node(21);
        root.right.right = new Node(24);
        root.right.right.left = new Node(23);
        root.right.right.right = new Node(25);
        root.right.right.right.right = new Node(26);

        return root;
    }


    /*
        17
      /       \
    13           21
    /  \            \
   10    15         24
   / \     \        /    \
  4  11     16      23    25
                            \
                            26

 */


    public static Node createBinaryTree2() {
        Node root = new Node(17);
        root.left = new Node(13);
        root.left.right = new Node(15);
        root.left.right.right = new Node(16);
        root.left.left = new Node(10);
        root.left.left.left = new Node(4);
        root.left.left.right = new Node(11);

        root.right = new Node(21);
        root.right.right = new Node(24);
        root.right.right.left = new Node(23);
        root.right.right.right = new Node(25);
        root.right.right.right.right = new Node(26);

        return root;
    }


/*
        7
      /   \
    2       9
      \
        4
          \
            5
             \
               6
 */

    public static Node createBinaryTree3() {
        Node root = new Node(7);
        root.left = new Node(2);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        root.right = new Node(9);
        root.right.right=new Node(10);

        return root;
    }

    public static Node createNotBinarySearchTree() {
        Node root = new Node(3);
        root.left = new Node(5);
        root.left.right = new Node(4);
        root.left.left = new Node(1);

        root.right = new Node(2);
        root.right.left = new Node(6);

        return root;
    }

    /*
     1
   / \
  2   2
 / \ / \
3  4 4  3

     */

    public static Node createNotBinarySearchTreeMirror() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(4);
        root.left.left = new Node(3);

        root.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        return root;
    }

    /*

     1
   / \
  2   2
   \   \
   3    3

     */
    public static Node createNotBinarySearchTreeNotMirror() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(3);

        root.right = new Node(2);
        root.right.right = new Node(3);

        return root;
    }
}

