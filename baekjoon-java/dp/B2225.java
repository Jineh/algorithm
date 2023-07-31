package dp;

import java.io.*;
import java.util.StringTokenizer;

public class B2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[k+1][n+1];


        for(int i=1; i<=k; i++){
            for(int j=0; j<=n; j++){
                if(i==1 || j==0) dp[i][j] = 1;
                else dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
            }
        }

        bw.write(String.valueOf(dp[k][n]));
        bw.flush();
        bw.close();
        br.close();
    }
}
