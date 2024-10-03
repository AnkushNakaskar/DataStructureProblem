package com.example.breadthfirstsearch;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class CourseSchedule2 {

    public static void main(String[] args) {
        System.out.println(findOrder(4,new int[][]{
                {0, 1},
                {1, 2}
        }));
    }
    public static int[] findOrder(int numCourses, int[][] nums) {
        List<Integer> processed = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int[] curr = nums[i];
            if(!map.containsKey(curr[0])){
                map.put(curr[0],new ArrayList<>());
            }
            map.get(curr[0]).add(curr[1]);
        }
        for(int i=0;i<numCourses;i++){
            Set<Integer> visited = new HashSet<>();
            if(processed.contains(i)){
                continue;
            }
            if(!map.containsKey(i)){
                processed.add(i);
                continue;
            }
            Stack<Integer> stack =new Stack<>();
            stack.push(i);
            while(!stack.isEmpty()){
                int currCourseToProcess = stack.pop();
                if(processed.contains(currCourseToProcess)){
                    continue;
                }
                if(!map.containsKey(currCourseToProcess)){
                    processed.add(currCourseToProcess);
                    visited.remove(currCourseToProcess);
                    continue;
                }
                visited.add(currCourseToProcess);
                List<Integer> list =new ArrayList<>();
                for(int j=0;j<map.get(currCourseToProcess).size();j++){
                    int course = map.get(currCourseToProcess).get(j);
                    if(processed.contains(course)){
                        continue;
                    }
                    if(visited.contains(course)){
                        return new int[0];
                    }
                    list.add(course);
                }
                if(!list.isEmpty()){
                    stack.push(currCourseToProcess);
                    stack.addAll(list);
                }else {
                    visited.remove(currCourseToProcess);
                    processed.add(currCourseToProcess);
                }
            }
        }
        int[] res = new int[processed.size()];
        for(int i=0;i<processed.size();i++){
            res[i]= processed.get(i);
        }
        return res;
    }
}
