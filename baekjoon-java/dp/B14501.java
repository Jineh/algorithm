package dp;

import java.io.*;
import java.util.*;

public class B14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][2];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int res = find(n, arr);
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }

    public static int find(int n, int[][] arr){
        int[] dp = new int[n+1];
        dp[0]= 0;

        for(int i=1; i<=n; i++){
            int day = i+arr[i][0]-1;
            if(day<=n) dp[day] = Math.max(dp[day], dp[i-1]+arr[i][1]);
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        return dp[n];
    }
}
