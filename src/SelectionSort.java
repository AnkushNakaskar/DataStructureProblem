import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 5, 1, 7, 4};
        for (int i = 0; i < a.length; i++) {
            int m = findMinIndex(a, i + 1);
            if (m != -1 && a[i] > a[m]) {
                swap(a, i, m);
            }
            System.out.println(" ");
        }
        Arrays.stream(a).forEach(System.out::println);

    }

    private static int findMinIndex(int[] a, int i) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        while (i < a.length) {
            if (min > a[i]) {
                min = a[i];
                index = i;
            }
            i++;
        }
        return index;
    }

    private static void swap(int[] a, int j, int i) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
