import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3282 {
    static int[][] arr;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int cnt = 0;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[n][2];
            for(int i=0; i<arr.length; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            int ans = find(k);
            sb.append('#').append(++cnt).append(" ").append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static int find(int k){
        int[][] dp = new int[arr.length+1][k+1];
        for(int i=0; i<=arr.length; i++){
            for(int j=0; j<=k; j++){
                if(i==0 || j==0) continue;
                if(arr[i-1][0] <=j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i-1][0]] + arr[i-1][1]);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[arr.length][k];
    }
}
