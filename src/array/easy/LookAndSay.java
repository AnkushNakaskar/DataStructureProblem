package array.easy;

public class LookAndSay {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String result = "1";
        int i = 1;
        while (i < n) {
            int count = 1;
            StringBuilder sb =new StringBuilder();
            for (int j = 1; j < result.length(); j++) {
                if(result.charAt(j)==result.charAt(j-1)){
                    count++;
                }else{
                    sb.append(count);
                    sb.append(result.charAt(j-1));
                    count=1;
                }
            }
            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }
        return result;
    }
}
