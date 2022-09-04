package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dp = new int[k+1];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1; //초기에는 한 가지 경우만 있음
        for(int i=0; i<n; i++){
            for(int j=1; j<=k; j++){ //동전 크기
                if(j>=arr[i]) dp[j]+=dp[j-arr[i]]; //j의 동전 사용할 때,
                //n-j 해서 j동전을 만들 수 있는 경우의 수를 더함
            }
        }
        System.out.println(dp[k]);
    }
}
