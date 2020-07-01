import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 5, 1, 7, 4};
        int l = a.length;
        for (int i = l - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
        Arrays.stream(a).forEach(System.out::println);
    }

    private static void swap(int[] a, int j, int i) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
