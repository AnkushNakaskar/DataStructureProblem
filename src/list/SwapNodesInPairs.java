package list;

import java.util.Stack;

public class SwapNodesInPairs {
    public static Node swapPairs(Node head) {
        Stack<Node> stack = new Stack<>();
        Node start = null;
        Node response = null;
        head =populateStack(head, stack, 2);
        int count =2;
        while (!stack.isEmpty()) {
            if(start==null){
                start=stack.pop();
                response=start;
            }else{
                start.right=stack.pop();
                start=start.right;
            }
            count--;
            if(count<=0){
                head =populateStack(head,stack,2);
                count=2;
            }
        }
        if(start!=null)
            start.right=null;
        return response;
    }

    private static Node populateStack(Node head, Stack<Node> stack, int count) {
        while (head != null && count > 0) {
            stack.push(head);
            count--;
            head = head.right;
        }
        return head;
    }

    public static void main(String[] args) {
        Node swapPairs = swapPairs(null);
        System.out.println(swapPairs);
    }
}
