package com.example.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class SplitArrayInToConsecutive {

    public static void main(String[] args) {
        System.out.println(isPossible(new int[]{
                1,2,3,5,5,6,7
        }));
        System.out.println(isPossible(new int[]{
                1,2,3,4,4,5
        }));
        System.out.println(isPossible(new int[]{
                1,2,3,3,4,5
        }));
        System.out.println(isPossible(new int[]{
                1,2,3,3,4,4,5,5
        }));
    }
    public static boolean isPossible(int[] nums) {
        Map<Integer,Integer> map =new HashMap<>();
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        while(!map.isEmpty()){
            PriorityQueue<Integer> queue =new PriorityQueue<>((a,b)-> a.compareTo(b));
            queue.addAll(map.keySet());
            int count=1;
            int prevCount = map.get(queue.peek());
            int currKey = queue.poll();
            map.put(currKey,map.get(currKey)-1);
            if(map.get(currKey)<=0){
                map.remove(currKey);
            }
            while(!queue.isEmpty() && prevCount<=map.get(queue.peek()) && (currKey+1 == queue.peek())){
                prevCount = map.get(queue.peek());
                currKey = queue.poll();
                map.put(currKey,map.get(currKey)-1);
                if(map.get(currKey)<=0){
                    map.remove(currKey);
                }
                count++;
            }
            if(count<3){
                return false;
            }
        }
        return true;
    }
}
