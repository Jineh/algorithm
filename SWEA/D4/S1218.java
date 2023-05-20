import java.util.*;
import java.io.*;

public class S1218 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=10; t++){
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int res = find(str)? 1 : 0;
            sb.append('#').append(t).append(" ").append(res).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean find(String str){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '(' || c== '{' || c== '[' || c== '<'){
                stack.push(c);
            }
            else{
                if(c==')' && stack.peek()=='(') stack.pop();
                else if(c==']' && stack.peek()=='[') stack.pop();
                else if(c=='}' && stack.peek()=='{') stack.pop();
                else if(c=='>' && stack.peek()=='<') stack.pop();
                else return false;
            }
        }
        return true;
    }
}
