package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D10211 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int[] x = new int[n];
            int[] dp = new int [n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) x[i] = Integer.parseInt(st.nextToken());

            dp[0] = x[0];
            int max=x[0];
            for(int i=1; i<n; i++){
                if(dp[i-1] <0) dp[i-1] =0;
                dp[i] = dp[i-1] + x[i];
                max = Math.max(max, dp[i]);

            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
