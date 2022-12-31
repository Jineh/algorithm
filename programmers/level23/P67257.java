import java.util.ArrayList;

public class P67257 {
    static long answer = Long.MIN_VALUE;
    static ArrayList<Long> numList = new ArrayList<>();
    static ArrayList<String> operList = new ArrayList<>();
    static String[] oper = {"+", "-", "*"};
    static String[] output = new String[3];
    static boolean[] check = new boolean[3];

    public static long solution(String expression) {
        String n ="";
        for(int i=0; i<expression.length(); i++){
            char exp = expression.charAt(i);
            if(exp =='+' || exp=='-' || exp=='*'){
                operList.add(exp + "");
                numList.add(Long.parseLong(n));
                n="";
            }
            else n+=exp;
        }
        numList.add(Long.parseLong(n));

        per(0, 3);

        return answer;
    }

    static void per(int depth, int r){
        if(depth == r) {
            solve();
            return;
        }

        for(int i=0; i<3; i++){
            if(!check[i]){
                check[i] = true;
                output[depth] = oper[i];
                per(depth+1, r);
                check[i] = false;
            }
        }
    }

    static void solve(){
        ArrayList<String> oper = new ArrayList<String>();
        oper.addAll(operList);

        ArrayList<Long> num = new ArrayList<Long>();
        num.addAll(numList);

        for(int i=0; i< output.length; i++){
            String tmp = output[i];
            for(int j=0; j<oper.size(); j++) {
                if (oper.get(j).equals(tmp)) {
                    long n1 = num.get(j);
                    long n2 = num.get(j+1);
                    long res = cal(n1, n2, tmp);

                    num.remove(j+1);
                    num.remove(j);
                    oper.remove(j);

                    num.add(j, res); //원래 위치에 삽입
                    j--;
                }
            }
        }

        answer = Math.max(answer, Math.abs(num.get(0)));
    }

    static long cal(long n1, long n2, String tmp ){
        long res =0;
        switch (tmp){
            case "+":
                res= n1+n2;
                break;
            case"-":
                res = n1-n2;
                break;
            case"*":
                res = n1*n2;
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "100-200*300-500+20";
        System.out.println(P67257.solution(a));
    }
}
