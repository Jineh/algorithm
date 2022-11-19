import java.util.Stack;

public class P76502 {
    public static int solution(String s) {
        int answer=0;
        Stack<Character> stack = new Stack<>();

        for(int j=0; j<s.length(); j++){
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(stack.isEmpty()) stack.push(c);
                else if(c=='(' || c=='{' || c=='[') stack.push(c);
                else if(c==')' && stack.peek() == '(') stack.pop();
                else if(c==']' && stack.peek() == '[') stack.pop();
                else if(c=='}' && stack.peek() == '{') stack.pop();
                else break;
            }
            if(stack.isEmpty()) answer++;
            else stack = new Stack<>();
            s= s.substring(1)+s.substring(0,1);
        }
        return answer;
    }

    public static void main(String[] args) {

        System.out.println(P76502.solution("}]()[{"));
    }
}
