import java.util.Stack;

public class P60058 {
    public static String solution(String p) {
        return divide(p);
    }

    static String divide(String s){
        if(s.length()==0) return"";

        String u="";
        String v="";
        int left=0;
        int right=0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(') left++;
            else right++;
            u+=c;

            if(left==right) {
                v+=s.substring(i+1);
                break;
            }
        }

        if(correctStr(u)) return u+=divide(v);
        else{
            String tmp = "(";
            tmp+=divide(v);
            tmp+=")";

            u=u.substring(1, u.length()-1);
            for(int i=0; i<u.length(); i++){
                if(u.charAt(i)=='(') tmp+=')';
                else tmp+='(';
            }
            return tmp;
        }
    }

    static boolean correctStr(String str){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='(') stack.push('(');
            else if (stack.isEmpty() || stack.peek()==')') return false;
            else stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "()))((()";
        System.out.println(P60058.solution(a));
    }
}
