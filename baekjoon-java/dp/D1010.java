package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1010 {
    static int [][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        while(t-- >0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(combi(m, n)).append('\n');
        }
        System.out.println(sb);
    }

    static int combi(int n, int r){
        if(n==r || r==0) return 1;
        if(dp[n][r]>0) return dp[n][r];

        return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }
}
