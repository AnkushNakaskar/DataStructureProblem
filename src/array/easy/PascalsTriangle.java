package array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) {
            return res;
        }
        List<Integer> start = new ArrayList<>();
        start.add(1);
        res.add(start);
        for (int i = 1; i < numRows; i++) {
            List<Integer> curr = init(i+1);
            res.add(curr);
            List<Integer> prev =res.get(i-1);
            for (int j = 1; j < i; j++) {
                curr.set(j,prev.get(j-1)+prev.get(j));
            }
        }
        System.out.println(res);
        return res;


    }

    private List<Integer> init(int i) {
        int[] array =new int[i];
        array[0]=1;
        array[i-1]=1;
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        return list;
    }

    public static void main(String[] args) {
        new PascalsTriangle().generate(5);
    }
}
