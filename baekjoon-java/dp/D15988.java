package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] dp;
        int[] seq = new int[t];
        int max=0;
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            seq[i] = n;
            if(max<seq[i]) max = seq[i];
        }
        dp = new long[max+1];

        dp[1]= dp[0] =1;


        for(int i=2; i<=max; i++){
            if(i==2) dp[i] = 2;
            else{
                dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])%1000000009;
            }
        }

        for(int i=0; i<t; i++){
            System.out.println(dp[seq[i]]);
        }

    }
}
