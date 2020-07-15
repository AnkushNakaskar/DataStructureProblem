package array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String s1 = "10";
        String s2 = "11";

        System.out.println(Math.pow(2, 0));
        int first =convertBinaryIntoInteger(s1);
        int second =convertBinaryIntoInteger(s2);
        System.out.println(first + " :: "+second);
        Integer result =first+second;
        System.out.println(result);
        String response =convertIntegerIntoBinary(result);
        System.out.println(response);
    }

    private static String convertIntegerIntoBinary(int result) {
        String s = "";
        while(result>0){
            int y = result % 2;
            s = y + s;
            result=result/2;
        }
        return s;

    }

    private static int convertBinaryIntoInteger(String s1) {
        Double result = 0.0;
        if (s1 != null && !s1.isEmpty()) {
            char[] binary = s1.toCharArray();

            for (int i = binary.length-1,j=0; i >= 0; i--,j++) {
                double pow =Math.pow(2, Double.parseDouble("" + j));
                double value =Double.parseDouble("" + binary[i]);
                result = result + (value *pow);
            }
        }
        return result.intValue();
    }
}
