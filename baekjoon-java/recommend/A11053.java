package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0]=1;
        int res=1;
        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(arr[j]<arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]+=1;
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }
}
