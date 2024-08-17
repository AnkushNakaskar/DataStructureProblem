package com.example.heap;

import java.util.PriorityQueue;

/**
 * @author ankush.nakaskar
 */
public class JavaPriorityQueue {
    public static void main(String[] args) {
        System.out.println("Ankush");
        PriorityQueue<Integer> queue =new PriorityQueue<>(Integer::compareTo);
        queue.add(5);
        queue.add(15);
        queue.add(2);
        queue.add(7);
        queue.add(9);
        queue.add(1);
        System.out.println(queue);
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
