import java.util.Arrays;

public class QuickSortLatest {
    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 5, 1, 7, 4};
        sort(a, 0, a.length - 1);
        Arrays.stream(a).forEach(System.out::print);

    }

    private static void sort(int[] a, int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);
            sort(a, low, pi - 1);
            sort(a, pi + 1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int i = (low - 1);
        int pivot = a[high];
        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] a, int j, int i) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
