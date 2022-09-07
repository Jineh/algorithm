package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] w = new int[n+1];
        int[] v = new int[n+1];
        int[] dp = new int[k+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            for(int j=k; j-w[i]>=0; j--){
                dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
                //k에서 i번째 짐 빼고 남은 값의 누적 가치 더한 것이랑 기존 비교해서 최댓값
            }
        }
        System.out.println(dp[k]);
    }
}
