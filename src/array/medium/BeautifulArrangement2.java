package array.medium;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BeautifulArrangement2 {

    public int[] constructArray(int n, int k) {
      /*
      There are tow conditions
      1. When k==1, just return in ascending order
      2. when k=n-1 , then try sort and [1,last,2,last-1....]
      3. else -> try first array [1..,n-k-1] and second with (second condition where n=n-(n-k-1))
       */
        //First condition
        if (k == 1) {

            return conditionOne(n);
        } else if (k == (n - 1)) {
            return condition2(n);
        } else {
            int[] cond1 = conditionOne(n - k - 1);

            int[] resInt = new int[n];
            int i = 0;
            for (; i < cond1.length; i++) {
                resInt[i] = cond1[i];
            }
            resInt =condition2(resInt,i,n,k);
            return resInt;
        }
    }

    private int[] condition2(int n) {
        int[] resInt = new int[n];
        int m = 1;
        for (int i = 0, j = n; i < resInt.length; i = i + 2) {
            resInt[i] = m++;
            if(i>=resInt.length-1){
                break;
            }
            resInt[i + 1] = j--;
        }
        return resInt;
    }
    private int[] condition2(int[] resInt,int start,int n,int k) {

        int j=0;
        for (int i = start; i<resInt.length;i++,j++) {
            resInt[i]=n-k+j;
        }
        return resInt;
    }

    private int[] conditionOne(int n) {
        Integer[] array = IntStream.range(1, n + 1).boxed().collect(Collectors.toList()).toArray(new Integer[]{});
        int[] resInt = new int[array.length];
        for (int i = 0; i < resInt.length; i++) resInt[i] = array[i];
        return resInt;
    }

    public static void main(String[] args) {
//        int[] arr =new BeautifulArrangement2().constructArray(5, 3);
//
//        Arrays.stream(arr).boxed().forEach(System.out::println);
        new BeautifulArrangement2().maximumSwap(120);
    }

    public int maximumSwap(int num) {
        if(num<=9){
            return num;
        }
        String[] s =(""+num).split("");
        int min=Integer.MAX_VALUE;
        int minIndex=-1;
        int max=Integer.MIN_VALUE;
        int maxIndex =s.length;
        for(int i=0,j=s.length-1;i<s.length && j>=0;i++,j--){
            if(Integer.parseInt(s[i])<min){
                min=Integer.parseInt(s[i]);
                minIndex=i;
            }
            if(Integer.parseInt(s[j])>max){
                max=Integer.parseInt(s[j]);
                maxIndex=j;
            }
            if(i>=j){
                break;
            }
        }
        if(min<max && minIndex<=maxIndex){
            String tmp =s[minIndex];
            s[minIndex]=s[maxIndex];
            s[maxIndex]=tmp;
        }
        String str = String.join("", s);

        System.out.println("String out :: "+str);
        return Integer.parseInt(str);

    }
}
