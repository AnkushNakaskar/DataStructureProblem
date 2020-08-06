import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AmIntQuestionTest {

    public int totalScore(int num, List<String> blocks){
        int currScore =0;
        if(blocks==null || blocks.isEmpty()){
            return 0;
        }
        Stack<Integer> stack =new Stack<>();
        int total =0;
        for(int i=0;i<blocks.size();i++){
            String curr =blocks.get(i);
            if(isNumber(curr)){
                currScore=Integer.parseInt(curr);
                stack.push(currScore);
            }else if(curr.equals("Z")){
                stack.pop();
            }else if(curr.equals("X")){
                currScore=stack.peek()*2;
                stack.push(currScore);
            }else if(curr.equals("+")){
                int first=stack.pop();
                int second =stack.pop();
                stack.push(second);
                stack.push(first);
                stack.push(first+second);
            }

        }
        System.out.println("Total :: "+stack);
        while(!stack.isEmpty()){
            total+=stack.pop();
        }
        return total;
    }

    public boolean isNumber(String input){
        try {
            Integer val =Integer.parseInt(input);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(new AmIntQuestionTest().totalScore(5, Arrays.asList("5","-2","4","Z","X","9","+","+")));
        System.out.println(new AmIntQuestionTest().totalScore(5, Arrays.asList("1","2","+","Z")));

    }

}
