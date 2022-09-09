package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A2661 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        solve("");
    }

    static void solve(String result){
        if(result.length()==n){ // 1, 2, 3 순서로 조합하니 젤 먼저 완성된 것이 최솟값
            System.out.println(result);
            System.exit(0);
        }
        for(int i=1; i<=3; i++){
            if(good(result+i)){
                solve(result+i);
            }
        }
    }

    static boolean good(String s){
        int length = s.length()/2;

        for(int i=1; i<=length; i++){
            if(s.substring(s.length()-i).equals(s.substring(s.length()-2*i, s.length()-i))){
                return false;
            }
        }
        return true;
    }
}
