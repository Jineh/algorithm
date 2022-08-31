package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D17175 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[51];

        for(int i=0; i<=n; i++){
            if(i<2) dp[i] =1;
            else dp[i] = (dp[i-2] + dp[i-1] +1)%1000000007;
        }

        System.out.println(dp[n]);
    }

}
