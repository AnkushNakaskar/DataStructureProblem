package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class SentenceScreenFitting {

    public static void main(String[] args) {
//        System.out.println(wordsTyping(new String[]{"a", "bcd", "e"},3,6));
//        System.out.println(wordsTyping(new String[]{"hello","world"},2,8));
//        System.out.println(wordsTyping(new String[]{"i","had","apple","pie"},4,5));
//        System.out.println(wordsTyping(new String[]{"f","p","a"},8,7));
        System.out.println(wordsTyping(new String[]{"a","b","c"},3,1));
    }
    public static int wordsTyping(String[] sentence, int rows, int cols) {
        if(sentence==null || sentence.length==0){
            return 0;
        }
        int count=0;
        char[][] charArr =new char[rows][cols];
        int m=0;

        for(int i=0;i<rows;i++){
            if(m>= sentence.length){
                m=0;
                count++;
            }

            String currString = sentence[m];
            int q=0;
            int j=0;
            if (currString.length()>(cols)){
                break;
            }
            while(j<cols ){
                charArr[i][j++]=currString.charAt(q++);

                if(q==currString.length()){
                    m++;
                    q=0;
                    if(j>=cols)break;
                    charArr[i][j++]='-';
                    if(m>= sentence.length){
                        m=0;
                        count++;
                    }
                    currString = sentence[m];
                    if(currString.length()>(cols-j+1)){
                        break;
                    }
                }

            }

        }
        if(m>= sentence.length){
            m=0;
            count++;
        }
        return count;
    }
}
