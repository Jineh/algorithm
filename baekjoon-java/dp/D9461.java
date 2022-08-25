package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[t];

        int max=0;
        for(int i=0; i<t; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(max<arr[i]) max = arr[i];
        }
        long[] dp = new long[max];

        for(int i=0; i<max; i++){
            if(i==0 || i==1 || i==2) dp[i] =1;
            else if(i==3 || i==4) dp[i] =2;
            else{
                dp[i] = dp[i-1]+ dp[i-5];
            }
        }

        for(int i=0; i<t; i++){
            System.out.println(dp[arr[i]-1]);
        }

    }
}
