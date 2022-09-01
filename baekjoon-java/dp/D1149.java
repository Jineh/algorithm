package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        int[][] dp = new int[n][3];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for(int i=1; i<n; i++){
            for(int j=0; j<3; j++){
                if(j==0) dp[i][0] = arr[i][j] + Math.min(dp[i-1][1], dp[i-1][2]);
                else if(j==1) dp[i][1] = arr[i][j] + Math.min(dp[i-1][0], dp[i-1][2]);
                else if(j==2) dp[i][2] = arr[i][j] + Math.min(dp[i-1][0], dp[i-1][1]);
            }
        }

        System.out.println(Math.min(dp[n-1][2], Math.min(dp[n-1][0], dp[n-1][1])));


    }
}
