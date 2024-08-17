package com.example.heap;

import java.util.*;

/**
 * @author ankush.nakaskar
 */
public class FindKPairWithSmallestSum {

    public static void main(String[] args) {
        System.out.println(kSmallestPairs(new int[]{
                1,7,11
        },new int[]{
                2,4,6
        },3));

        System.out.println(kSmallestPairs(new int[]{
                1,1,2
        },new int[]{
                1,2,3
        },3));

        System.out.println(kSmallestPairs(new int[]{
                1,2,3,3,3
        },new int[]{
                -3,22,35,56,70,100,123,200
        },10));
    }
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res =new ArrayList<>();
        if(nums1==null || nums2==null){
            return res;
        }
        PriorityQueue<int[]> queue =new PriorityQueue<>((a,b) ->{
            return (a[0]-b[0]);
        });
        HashSet<Pair<Integer,Integer>>hashSet = new HashSet<>();
        int N = nums1.length;
        int M = nums2.length;
        int i=0;
        int j=0;
        queue.add(new int[]{nums1[i],nums2[j],0,0});
        while(!queue.isEmpty() && k-->0){
            int[] curr = queue.poll();
            i = curr[1];
            j = curr[2];
            res.add(Arrays.asList(nums1[i],nums2[j]));
            if(i<N-1 && !hashSet.contains(new Pair<Integer,Integer>(i+1,j))){
                queue.add(new int[]{nums1[i+1]+nums2[j],i+1,j});
                hashSet.add(new Pair<Integer,Integer>(i+1,j));
            }
            if(j<M-1 && !hashSet.contains(new Pair<Integer,Integer>(i,j+1))){
                queue.add(new int[]{nums1[i]+nums2[j+1],i,j+1});
                hashSet.add(new Pair<Integer,Integer>(i,j+1));
            }
        }

        return res;
    }

    static class Pair<T ,S>{


        private T a;
        private S b;

        public Pair(T a, S b){
            this.a=a;
            this.b=b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(a, pair.a) && Objects.equals(b, pair.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
//    [[1, -3], [2, -3], [3, -3], [3, -3], [3, -3], [-3, 22], [22, 35], [35, 56], [56, 70], [70, 100]]
//    [[1,-3],[2,-3],[3,-3],[3,-3],[3,-3],[1,22],[2,22],[3,22],[3,22],[3,22]]
}
