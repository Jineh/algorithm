package dp;

import java.io.*;

public class B2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int[] dp = new int[str.length()+1];
        int[] arr = new int[str.length()+1];
        for(int i=0; i<str.length(); i++) arr[i+1]= str.charAt(i) -'0';
        dp[0]=1;

        for(int i=1; i<=str.length(); i++){
            if(arr[i]!=0){
                dp[i] = (dp[i-1] + dp[i]) % 1000000;
            }

            int x = arr[i] + arr[i-1]*10;

            if(10<=x && x<=26){
                dp[i] = (dp[i-2] + dp[i]) % 1000000;
            }
        }
        String res = String.valueOf(dp[str.length()]);
        bw.write(res);
        bw.flush();
        bw.close();
    }
}
