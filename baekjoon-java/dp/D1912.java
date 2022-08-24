package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1912 {
    static int[] seq;
    static Integer[] dp;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        seq = new int[n];
        dp = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        dp[0]=seq[0];
        max = seq[0];
        LIS(n-1);

        System.out.println(max);
    }

    static int LIS(int n){

        if(dp[n]==null){
            dp[n] = Math.max(LIS(n-1)+seq[n], seq[n]);

            max = Math.max(dp[n], max);
        }
        return dp[n];
    }
}
