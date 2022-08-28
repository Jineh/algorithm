package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D15624 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n+2];
        arr[0]=0;
        arr[1]=1;

        for(int i=2; i<=n; i++){
            arr[i] = (arr[i-1] + arr[i-2])%1000000007;
        }
        System.out.println(arr[n]);
    }
}
