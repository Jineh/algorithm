package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                dp[i][j] = dp[i][j-1] + Integer.parseInt(st.nextToken()); ;
            }
        }

        StringBuffer sb = new StringBuffer();
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum=0;
            for(int i=x; i<=x2; i++){
                sum+=dp[i][y2] - dp[i][y-1];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
