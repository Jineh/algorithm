package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        int[] sum = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum[i] = sum[i-1]+arr[i];
        }

        dp[m] = sum[m];
        for(int i=m+1; i<=n; i++){
            dp[i] = Math.max(dp[i-1]+arr[i], sum[i]-sum[i-m]);
        }

        int res = Integer.MIN_VALUE;
        for(int i=m; i<=n; i++){
            res = Math.max(res, dp[i]);
        }

        if(res<0) res=0;

        System.out.println(res);
    }
}
