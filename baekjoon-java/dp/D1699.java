package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] d = new int[n+1];

        for(int i=1; i<=n; i++){
            d[i] = i;
            for(int j=1; j*j <=i; j++){ //제곱수가 포함되어야 최소 개수
                if(d[i] > d[i-j*j] + 1){
                    d[i] = d[i-j*j] + 1;
                }
            }
        }
        System.out.println(d[n]);

    }
}
