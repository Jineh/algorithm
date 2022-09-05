package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < t; j++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int money = Integer.parseInt(br.readLine());

            sb.append(trans(arr, money)).append("\n");
        }

        System.out.println(sb);
    }

    static int trans(int[] arr, int money){
        int[] dp = new int[money+1];
        dp[0]=1;
        for(int i=0; i<arr.length; i++){
            for(int j=arr[i]; j<=money; j++){
                dp[j] +=dp[j-arr[i]];
            }
        }
        return dp[money];
    }
}
