package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[16];
        int[] p = new int[16];
        int[] dp = new int[16];

        StringTokenizer st;

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int day;
        for(int i=n; i>0; i--){
            day = i+t[i];
            if(day > n+1) dp[i] = dp[i+1];
            else{
                dp[i] = Math.max(dp[i+1], dp[day] + p[i]);
            }
        }

        System.out.println(dp[1]);
    }
}
