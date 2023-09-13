package brute_force;

import java.io.*;

/**
 * 처음 문자열에서 하나씩 더해서 찾으면 최대 2^50 경우의 수가 나온다
 * -> 결과 문자열 t에서 s 문자열로 가는 방식으로 해야 시간 초과 x
 */
public class B12919 {
    static int res=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String t = br.readLine();

        find(s, t);

        bw.write(String.valueOf(res));
        bw.close();
        br.close();
    }

    public static void find(String s, String t){
        if(s.length()==t.length()){
            if(s.equals(t)) res=1;
            return;
        }

        // 맨 앞과 맨 뒤 값을 통해 경우의 수 줄일 수 있다.
        if(t.charAt(0) =='B'){
            find(s, new StringBuilder(t.substring(1)).reverse().toString());
        }
        if(t.charAt(t.length()-1) =='A'){
            find(s, t.substring(0, t.length()-1));
        }
    }
}
