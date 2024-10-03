package com.example.breadthfirstsearch;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class MinHeightTree {

    public static void main(String[] args) {
        System.out.println(findMinHeightTrees(6,new int[][]{
                {0,1},{0,2},{0,3},{3,4},{4,5}
        }));
        System.out.println(findMinHeightTrees(1,new int[][]{
        }));
        System.out.println(findMinHeightTrees(2,new int[][]{
                {0,1}
        }));
//        System.out.println(findMinHeightTrees(6,new int[][]{
//                {3,0},
//                {3,1},
//                {3,2},
//                {3,4},
//                {4,5}
//        }));
//        System.out.println(findMinHeightTrees(6,new int[][]{
//                {1,0},
//                {1,2},
//                {1,3}
//        }));
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] nums) {
        List<Integer> minHeightTrees =new ArrayList<>();
        Set<Integer> startToEndSet = new HashSet<>();
        for(int i=0;i< nums.length;i++){
            int[] curr = nums[i];
            startToEndSet.add(curr[1]);
        }
        Set<Integer> endToStartSet = new HashSet<>();
        for(int i=0;i< nums.length;i++){
            int[] curr = nums[i];
            endToStartSet.add(curr[0]);
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new HashSet<>());
        for (int[] edge : nums) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        int min =Integer.MAX_VALUE;
        Map<Integer,List<Integer>> resVertexMap = new HashMap<>();
        for(int i=0;i< n;i++) {
            Map<Integer, Set<Integer>> newMap = new HashMap<>();
            map.forEach((key,val)->newMap.put(key,new HashSet<>(val)));
            int height = getHeight(newMap,i);
            minHeightTrees.add(height);
            min = Math.min(min,height);
            List<Integer> list = resVertexMap.getOrDefault(height,new ArrayList<>());
            list.add(i);
            resVertexMap.put(height,list);
        }
        return resVertexMap.get(min);
    }

    private static int getHeight(Map<Integer, Set<Integer>> map, int vertex) {
        int height =0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++){
                int top = queue.remove();
                if(!map.containsKey(top) || (map.containsKey(top) && map.get(top).isEmpty())){
                    return height;
                }
                for (int node : map.get(top)) {
                    queue.add(node);
                    map.get(node).remove(top);
                }
            }
            height++;
        }

        return height;
    }

    public static List<Integer> findMinHeightTreesOld(int n, int[][] nums) {
        List<Integer> minHeightTrees =new ArrayList<>();
        Map<Integer,List<Integer>> startToEndMap = new HashMap<>();
        Set<Integer> startToEndSet = new HashSet<>();
        for(int i=0;i< nums.length;i++){
            int[] curr = nums[i];
            if(!startToEndMap.containsKey(curr[0])){
                startToEndMap.put(curr[0],new ArrayList<>());
            }
            startToEndMap.get(curr[0]).add(curr[1]);
            startToEndSet.add(curr[1]);
        }

        Map<Integer,List<Integer>> endToStartMap = new HashMap<>();
        Set<Integer> endToStartSet = new HashSet<>();
        for(int i=0;i< nums.length;i++){
            int[] curr = nums[i];
            if(!endToStartMap.containsKey(curr[1])){
                endToStartMap.put(curr[1],new ArrayList<>());
            }
            endToStartMap.get(curr[1]).add(curr[0]);
            endToStartSet.add(curr[0]);
        }
        int min =Integer.MAX_VALUE;
        Map<Integer,List<Integer>> resVertexMap = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            if(!startToEndSet.contains(i)){
                int height = getHeight(new HashMap<>(),i);
                minHeightTrees.add(height);
                min = Math.min(min,height);
                List<Integer> list = resVertexMap.getOrDefault(height,new ArrayList<>());
                list.add(i);
                resVertexMap.put(height,list);

            }else if(!endToStartSet.contains(i)){
                int height = getHeight(new HashMap<>(),i);
                minHeightTrees.add(height);
                min = Math.min(min,height);
                List<Integer> list = resVertexMap.getOrDefault(height,new ArrayList<>());
                list.add(i);
                resVertexMap.put(height,list);
            }
        }
        if(!resVertexMap.containsKey(min)){
            List<Integer> list =new ArrayList<>();
            list.add(0);
            return list;
        }
       return resVertexMap.get(min);
    }


}
