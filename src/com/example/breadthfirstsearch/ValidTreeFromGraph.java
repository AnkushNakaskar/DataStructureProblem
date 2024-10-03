package com.example.breadthfirstsearch;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class ValidTreeFromGraph {
    public static void main(String[] args) {

        System.out.println(validTree(5,new int[][]{
                {1,0},
                {2,0},
                {3,4}
        }));

//        System.out.println(validTree(5,new int[][]{
//                {0,1},
//                {1,2},
//                {2,3},
//                {1,3},
//                {1,4}
//        }));
//
//        System.out.println(validTree(5,new int[][]{
//                {0,1},
//                {0,2},
//                {0,3},
//                {1,4}
//        }));
    }
    public static boolean validTree(int n, int[][] edges) {
        // n must be at least 1
        if (n < 1) return false;

        // create hashmap to store info of edges
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new HashSet<>());
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        // bfs starts with node in label "0"
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int top = queue.remove();
            // if set already contains top, then the graph has cycle
            // hence return false
            if (set.contains(top)) return false;

            for (int node : map.get(top)) {
                queue.add(node);
                // we should remove the edge: node -> top
                // after adding a node into set to avoid duplicate
                // since we already consider top -> node
                map.get(node).remove(top);
            }
            set.add(top);
        }
        return set.size() == n;
    }
    public static boolean validTreeOld1(int vertex, int[][] nums) {
//        if(nums.length>=vertex){
//            return false;
//        }
        Map<Integer, List<Integer>> mapOfIndegree =new HashMap<>();
        for(int i=0;i< nums.length;i++){
            int[] curr = nums[i];
            if(!mapOfIndegree.containsKey(curr[0])){
                mapOfIndegree.put(curr[0],new ArrayList<>());
            }
            mapOfIndegree.get(curr[0]).add(curr[1]);
        }
        int[] inDegree =new int[vertex];
        for(int i=0;i<vertex;i++){
            if(mapOfIndegree.containsKey(i)){
                List<Integer> list = mapOfIndegree.get(i);
                for(int val : list){
                    inDegree[val]++;
                }
            }
        }

        Map<Integer, List<Integer>> mapOfOutdegree =new HashMap<>();
        for(int i=0;i< nums.length;i++){
            int[] curr = nums[i];
            if(!mapOfOutdegree.containsKey(curr[1])){
                mapOfOutdegree.put(curr[1],new ArrayList<>());
            }
            mapOfOutdegree.get(curr[1]).add(curr[0]);
        }
        int[] outDegree =new int[vertex];
        for(int i=0;i<vertex;i++){
            if(mapOfOutdegree.containsKey(i)){
                List<Integer> list = mapOfOutdegree.get(i);
                for(int val : list){
                    outDegree[val]++;
                }
            }
        }
        int inDegreeZeroCount =0;
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                inDegreeZeroCount++;
            }
        }
        int outDegreeZeroCount =0;
        for(int i=0;i<outDegree.length;i++){
            if(outDegree[i]==0){
                outDegreeZeroCount++;
            }
        }

        return outDegreeZeroCount<=1 || inDegreeZeroCount<=1;
    }
    public static boolean validTreeOld(int vertex, int[][] nums) {
        Map<Integer, List<Integer>> mapOfIndegree =new HashMap<>();
        for(int i=0;i< nums.length;i++){
            int[] curr = nums[i];
            if(!mapOfIndegree.containsKey(curr[0])){
                mapOfIndegree.put(curr[0],new ArrayList<>());
            }
            mapOfIndegree.get(curr[0]).add(curr[1]);
        }
        int[] inDegree =new int[vertex];
        int countIndependant=0;
        for(int i=0;i<vertex;i++){
            if(mapOfIndegree.containsKey(i)){
                List<Integer> list = mapOfIndegree.get(i);
                for(int val : list){
                    inDegree[val]++;
                }
            }
        }
        Queue<Integer> queue =new ArrayDeque<>();
        int inDegreeCountZero=0;
        for(int i=0;i< inDegree.length;i++){
            if(inDegree[i]>1){
                return false;
            }
           if(inDegree[i]==0){
               inDegreeCountZero++;
           }
        }
        if(inDegreeCountZero>1){
            return false;
        }
        return true;
    }
}
