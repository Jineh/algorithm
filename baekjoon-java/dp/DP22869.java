package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP22869 {
    static int n,k;
    static int[] arr;
    static boolean[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        dp = new boolean[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1);

        System.out.println(dp[n]?"YES":"NO");

    }

    static void dfs(int index){
        if(dp[index]) return;

        if(index == n){
            dp[index]=true;
            return;
        }

        dp[index] = true;
        for(int i=index+1; i<=n; i++){
            if((i-index)*(1+Math.abs(arr[index]-arr[i]))<=k) dfs(i);
        }

    }
}
