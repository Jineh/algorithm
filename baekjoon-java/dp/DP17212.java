package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP17212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+1];
        int[] coin = {1,2,5,7};
        dp[0]=0;

        for(int i=1; i<=n; i++){
            if(i==1 || i==2 || i==5 || i==7) dp[i] = 1;
            else{
                dp[i] = i;
                for(int j=0; j<4; j++){
                    if(i-coin[j]>0){
                        dp[i] = Math.min(dp[i-coin[j]], dp[i]);
                    }
                }
                dp[i]++;
            }
        }
        System.out.println(dp[n]);
    }
}
