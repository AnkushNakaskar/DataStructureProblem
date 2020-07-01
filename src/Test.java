import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        String yourValue = "1"; // This is what you get from json.

        Boolean param = Boolean.parseBoolean((String)yourValue);

        if(param == true)
            System.out.println("Value is true");
        else
            System.out.println("Value is false");
        System.out.println(param);
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
