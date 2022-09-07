package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int length1 = a.length;
        int length2 = b.length;

        int[][] dp = new int[length1+1][length2+1];

        for(int i=1; i<=length1; i++){
            for(int j=1; j<=length2; j++){
                if(a[i-1]== b[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1; //같은 문자 전 열, 행 값에서 +1
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    // 행 열 방향 상관 없어서 그 중 최댓값 선택
                }
            }
        }
        System.out.println(dp[length1][length2]);
    }
}
