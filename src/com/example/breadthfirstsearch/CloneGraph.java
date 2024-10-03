package com.example.breadthfirstsearch;

import java.util.*;

/**
 * @author ankush.nakaskar
 */

class GraphNode {
    public int val;
    public List<GraphNode> neighbors;
    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public GraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneGraph {

    public static void main(String[] args) {
        GraphNode node1 = new GraphNode(1);
        GraphNode node2= new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        GraphNode reference = cloneGraph(node1);
        System.out.println(reference);

    }

    public static GraphNode cloneGraph(GraphNode root) {
        GraphNode reference =null;
        Set<Integer> visited = new HashSet<>();
        Map<Integer,GraphNode> map = new HashMap<>();
        Queue<GraphNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            GraphNode node = queue.poll();
            if(visited.contains(node.val)){
                continue;
            }
            GraphNode newNode = null;
            if(map.containsKey(node.val)){
                newNode = map.get(node.val);
            }else{
                newNode = new GraphNode(node.val);
                map.put(node.val,newNode);
            }
            for(GraphNode neighbor : node.neighbors){
                GraphNode newNeighbor = null;
                if(map.containsKey(neighbor.val)){
                    newNeighbor = map.get(neighbor.val);
                }else{
                    newNeighbor = new GraphNode(neighbor.val);
                    map.put(newNeighbor.val,newNeighbor);
                }
                newNode.neighbors.add(newNeighbor);
                queue.add(neighbor);
            }
            visited.add(node.val);
            reference = newNode;
        }
        return reference;
    }
}
