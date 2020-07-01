import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = new int[]{3, 8, 5, 1, 7, 4};

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j > 0 & j < a.length; j--) {
                if (a[j] > a[j - 1]) {
                    break;
                } else {
                    swap(a, j - 1, j);
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
