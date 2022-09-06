package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int [] dp = new int[n+1];
        StringTokenizer st =  new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] =0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=arr[i]; j++){
                if(i+j>n) break;
                if(dp[i]==Integer.MAX_VALUE) break;
                dp[j+i] = Math.min(dp[i+j], dp[i]+1);
            }
        }

        if(dp[n]==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[n]);

    }
}
