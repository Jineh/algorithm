package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2169 {
    static int n, m;
    static int[][] arr, dp;
    static int[][] tmp;
    static int[] dx = {  1, 0, 0};
    static int[] dy = {  0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dp = new int[n][m];
        tmp = new int[2][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];
        for(int i=1; i<m; i++){
            dp[0][i] = dp[0][i-1] + arr[0][i];
        }

        for(int i=1; i<n; i++){

            tmp[0][0] = dp[i-1][0] + arr[i][0];
            for(int j=1; j<m; j++){
                tmp[0][j] = Math.max(tmp[0][j-1], dp[i-1][j]) + arr[i][j];
            }

            tmp[1][m-1] = dp[i-1][m-1] + arr[i][m-1];
            for(int j=m-2; j>=0; j--){
                tmp[1][j] = Math.max(tmp[1][j+1], dp[i-1][j]) + arr[i][j];
            }

            for(int j=0; j<m; j++){
                dp[i][j] = Math.max(tmp[0][j], tmp[1][j]);
            }
        }


        System.out.println(dp[n-1][m-1]);


    }
}
