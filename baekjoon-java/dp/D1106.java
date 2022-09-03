package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()); //고객
        int n = Integer.parseInt(st.nextToken()); //도시 개수
        int[] dp = new int[c+101]; //적어도 c이상
        Arrays.fill(dp, 987654321);
        dp[0] =0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());

            for(int j=customer; j< c+101; j++){ //초기값은 사람 수부터
                dp[j] = Math.min(dp[j], cost+dp[j-customer]); //j가 증가해도 사람 배수일때만 값 바뀜
                                                             //다음 도시의 사람 배수가 증가하며 채울 수 있음
                }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=c; i<c+101; i++){ //원하는 증가 고객부터 시작하며 최솟값 찾기
            ans = Math.min(ans, dp[i]);
        }
        System.out.println(ans);
    }

}
