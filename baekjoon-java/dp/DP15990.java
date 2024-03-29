package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP15990 {
    static final int mod = 1000000009;
    static long[][] dp = new long[100001][4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] =1;

        for(int i=4; i<=100000; i++){
            dp[i][1] = (dp[i-1][2] + dp[i-1][3])%mod;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3])%mod;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2])%mod;
        }

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            long res = (dp[n][1] + dp[n][2] + dp[n][3])%mod;
            System.out.println(res);
        }

    }
}
