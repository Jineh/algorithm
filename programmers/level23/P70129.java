
public class P70129 {
    public static int[] solution(String s) {
        int[] answer = new int[2];

        int cnt=0;
        int zero=0;
        while(!s.equals("1")){
            int one=0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='1') one++;
                else zero++;
            }
            s= Integer.toBinaryString(one);
            //s= change(one);
            cnt++;
        }

        answer[0] = cnt;
        answer[1] = zero;
        System.out.println(cnt+" " +zero);
        return answer;
    }

    public static String change(int n){
        StringBuilder s= new StringBuilder();
        while(n!=0){
            s.append(n % 2);
            n= n/2;
        }
        return s.reverse().toString();
    }

    public static void main(String[] args) {

        String s = "110010101001";
        System.out.println(P70129.solution(s));
    }
}
