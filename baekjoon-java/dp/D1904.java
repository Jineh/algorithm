package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[1]=1;

        for(int i=2; i<=n; i++){
            if(i==2) dp[2] =2;
            else dp[i] = (dp[i-1]+dp[i-2])%15746;
        }
        System.out.println(dp[n]%15746);
    }
}
