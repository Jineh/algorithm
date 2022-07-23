package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G21758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] honey = new int[n+1];
        int[] sum = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <=n; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
            sum[i] = honey[i] + sum[i-1];
        }

        int ans =0;

        //벌통 오른쪽
        for(int i=2; i<=n-1; i++){
            int tmp = sum[n] - honey[1] - honey[i] +sum[n] - sum[i];
            ans = Math.max(ans, tmp);
        }
        //벌통 가운데
        for(int i=2; i<=n-1; i++){
            int tmp = sum[n-1] - sum[i-1] + sum[i] -sum[1];
            ans = Math.max(ans, tmp);
        }
        //벌통 왼쪽
        for(int i=2; i<=n-1; i++){
            int tmp = sum[n-1] -honey[i] + sum[i-1];
            ans = Math.max(ans, tmp);
        }

        System.out.println(ans);
    }
}
