package dp;

import java.io.*;
import java.util.StringTokenizer;

public class B10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean[][] dp = new boolean[n][n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i][i] = true;
        }
        solution(dp, arr);

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String res = (dp[x-1][y-1]) ? "1" : "0";
            bw.write(res + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void solution(boolean[][] dp, int[] arr) {
        for(int i=0; i<dp.length-1; i++) {
            if(arr[i]==arr[i+1]) dp[i][i+1] = true;
        }

        for(int i=2; i<dp.length; i++) {
            for(int j=0; j<dp.length-i; j++) {
                if(arr[j] == arr[i+j] && dp[j+1][i+j-1])
                    dp[j][i+j] = true;
            }
        }
    }
}
