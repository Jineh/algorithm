public class P12909 {
    static boolean solution(String s) {
        boolean answer = true;
        char[] arr = s.toCharArray();
        int left=0, right=0;
        for(char i: arr){

            if(i=='(') left++;
            else if(i==')') right++;

            if(right>left) return false;

        }
        if(right!=left) answer=false;
        return answer;
    }

    public static void main(String[] args) {

        String s = "()()";
        System.out.println(P12909.solution(s));
    }
}

