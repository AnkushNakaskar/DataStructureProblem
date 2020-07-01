import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        String yourValue = "10101"; // This is what you get from json.
        String[] splits =yourValue.split("");
        System.out.println(splits);
    }

    public static int Fibo(int n){
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        else {
         return    Fibo(n - 1) + Fibo(n - 2);
        }
    }
}
