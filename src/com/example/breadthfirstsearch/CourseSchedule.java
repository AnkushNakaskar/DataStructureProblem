package com.example.breadthfirstsearch;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class CourseSchedule {

    public static void main(String[] args) {

        System.out.println(canFinish(5, new int[][]{
                {1,4},
                {2,4},
                {3,1},
                {3,2}
        }));

        System.out.println(canFinish(3, new int[][]{
                {1,0},
                {0,2},
                {2,1}
        }));

        System.out.println(canFinish(2, new int[][]{
                {0, 1}
        }));
        System.out.println(canFinish(2, new int[][]{
                {0, 1},
                {1,0}
        }));
        System.out.println(canFinish(4, new int[][]{
                {0, 1},
                {1, 2}
        }));

        System.out.println(canFinish(4, new int[][]{
                {0, 1},
                {1, 2},
                {2, 0}
        }));
    }

    public static boolean canFinish(int numCourses, int[][] nums) {
        Set<Integer> processed = new HashSet<>();

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
                        return false;
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
        return processed.size()==numCourses;
    }
}
