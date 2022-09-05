package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][10];
        int sum=0;

        for(int i=1;i<=n;i++){
            for(int j=0; j<10; j++){
                if(i==1) dp[i][j]=1;
                else{
                    for(int k=0; k<=j; k++){
                        dp[i][j] += dp[i-1][k]; //j일 때 전의 자리수에서 맨 뒤에 k=j까지 붙여도 오름차순
                        dp[i][j] %= 10007;
                    }
                }
            }

        }

        for(int i=0; i<10; i++){
            sum+=dp[n][i];
        }
        System.out.println(sum%10007);
    }
}
