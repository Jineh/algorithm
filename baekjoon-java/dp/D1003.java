package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1003 {
    static long[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        arr = new long[41][2];
        arr[0][0] = 1;
        arr[1][1] =1;

        for(int i=2; i<=40; i++){
            arr[i][0] = arr[i-2][0] + arr[i-1][0];
            arr[i][1] = arr[i-2][1] + arr[i-1][1];
        }

        StringBuffer sb = new StringBuffer();
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n][0] + " " + arr[n][1]).append("\n");
        }
        System.out.println(sb);
    }

}
