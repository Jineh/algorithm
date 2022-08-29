package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr= new int[n+2][2];
        int[] dp = new int[n+2];

        StringTokenizer st;
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = -1;
        for(int i=1; i<=n+1; i++){
            if(max < dp[i]) max = dp[i]; // max값 전 날까지는 누적 안 됨
            int id = i+ arr[i][0];
            if(id < n+2) dp[id] = Math.max(dp[id], max + arr[i][1]); // 이미 더해질 수 있음, 누적에서 그날의 상담비
        }

        System.out.println(max);
    }
}
