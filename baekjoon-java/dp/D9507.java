package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D9507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] arr = new long[68];

        for(int i=0; i<=67; i++){
            if(i<2) arr[i] = 1;
            else if(i==2) arr[i] =2;
            else if(i==3) arr[i] = 4;
            else{
                arr[i] = arr[i-1] + arr[i-2] + arr[i-3] + arr[i-4];
            }
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr[n]);
        }
    }
}
