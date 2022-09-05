package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                dp[i] = Math.max(dp[i], dp[i-j]+arr[j]); //현재 카드 수에서 돈만큼 빼고 그 돈 더함
            }                                         // 기존 것과 비교하여 최댓값
        }

        System.out.println(dp[n]);
    }
}
