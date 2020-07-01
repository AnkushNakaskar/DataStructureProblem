import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 5, 1, 7, 4};
        Arrays.stream(a).forEach(System.out::print);
        System.out.println();

        mergeSort(a, 0, a.length - 1);
        System.out.println(">>>>");
        Arrays.stream(a).forEach(System.out::print);
        System.out.println();
    }

    private static void mergeSort(int[] a, int p, int r) {
        int q;
        if (p < r) {
            q = (p + r) / 2;

            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    private static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = a[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = a[q + 1 + j];
        }
        int i=0,j=0;
        int k=p;
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                a[k]=L[i];
                i++;
                k++;
            }else{
                a[k]=R[j];
                j++;
                k++;
            }
        }
        while(i<n1){
            a[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            a[k]=R[j];
            j++;
            k++;
        }

    }
}
