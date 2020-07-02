package list;

import java.util.HashMap;
import java.util.Map;

public class LinkedListMatrix {

    static class Node {
        int data;
        Node right, down;

        Node(int data) {
            this.data = data;
            right = null;
            down = null;
        }
    }

    static Node construct(int arr[][], int n) {
        Map<String, Node> mapOfLocationAndNode = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                Node node = mapOfLocationAndNode.get("" + i + j);
                if (node == null) {
                    node = new Node(arr[i][j]);
                    mapOfLocationAndNode.put("" + i + j, node);
                }
                if (mapOfLocationAndNode.get("" + (i) + (j - 1)) != null) {
                    mapOfLocationAndNode.get("" + (i) + (j - 1)).right = node;
                } else if (mapOfLocationAndNode.get("" + (i - 1) + (j)) != null) {
                    mapOfLocationAndNode.get("" + (i - 1) + (j)).down = node;
                }

            }
        }
        return mapOfLocationAndNode.get("00");
    }

    /*
    Input : 2D matrix
1 2 3
4 5 6
7 8 9

Output :
1 -> 2 -> 3 -> NULL
|    |    |
v    v    v
4 -> 5 -> 6 -> NULL
|    |    |
v    v    v
7 -> 8 -> 9 -> NULL
|    |    |
v    v    v
NULL NULL NULL

     */
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        int value = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = ++value;
            }
        }
        construct(arr, 3);
        System.out.println(arr);
    }

}
