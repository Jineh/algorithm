package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D11055 {
    static int[] seq;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        seq = new int[n];
        dp = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = seq[0];
        int max=dp[0];
        for(int i=1; i<n; i++){
            dp[i] = seq[i];
            for(int j=0; j<i; j++){
                if(seq[i]>seq[j]){
                    dp[i] = Math.max(dp[j]+seq[i], dp[i]);
                }
            }
            if(max<dp[i]) max = dp[i];
        }

        System.out.println(max);
    }
}
