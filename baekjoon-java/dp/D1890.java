package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1890 {
    static int[][] map;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new long[n][n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==n-1&&j==n-1) continue;
                int next = map[i][j];
                if(i+next<n) dp[i+next][j] += dp[i][j];
                if(j+next<n) dp[i][j+next] += dp[i][j];
            }
        }


        System.out.println(dp[n-1][n-1]);
    }
}
