package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D11053 {
    static int[] seq;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        seq = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        dp[0]=1;
        for(int i=1; i<n; i++){
            LIS(i);
        }

        Arrays.sort(dp);
        System.out.println(dp[n-1]);

    }

    static int LIS(int n){
        if(dp[n]==0) {
            dp[n] = 1;

            for(int i=n-1; i>=0; i--){
                if(seq[i]<seq[n]){
                    dp[n] = Math.max(dp[n], LIS(i)+1);
                }
            }
        }
        return dp[n];
    }
}
