package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1937 {
    static int n;
    static int[][] arr, dp;
    static boolean[][] check;
    static int[] dx = { -1, 1, 0, 0};
    static int[] dy = { 0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];
        check = new boolean[n][n];


        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for(int j=0; j<n; j++) {
                if(dp[i][j]==0) {
                    dfs(i,j);
                }
            }
        }


        int res=0;
        for (int i = 0; i < n; i++) {
            for(int j=0; j<n; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }

        System.out.println(res);


    }
    static void dfs(int x, int y){
        check[x][y]=true;

        for(int i=0; i<4; i++){
            int nx = x+ dx[i];
            int ny = y +dy[i];
            if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
            if(check[nx][ny] || arr[nx][ny]<=arr[x][y]) continue;

            if(dp[nx][ny]==0) dfs(nx, ny);
            dp[x][y] = Math.max(dp[x][y], dp[nx][ny]);

        }
        check[x][y]=false;
        dp[x][y]+=1;

    }
}
