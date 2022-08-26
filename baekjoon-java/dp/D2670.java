package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];

        for(int i=0; i<n; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }

        double res =arr[0];
        for(int i=1; i<n; i++){
            arr[i] = Math.max(arr[i-1]*arr[i], arr[i]);

            if(res < arr[i]) res = arr[i];
        }
        System.out.println(String.format("%.3f", res));
    }
}
