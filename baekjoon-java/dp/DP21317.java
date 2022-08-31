package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP21317 {
    static int n, k;
    static int[][] arr;
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][2];
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        k = Integer.parseInt(br.readLine());

        find(0, 1, false);

        System.out.println(answer);

    }

    static void find(int sum, int to, boolean use){
        if(to == n){
            answer = Math.min(answer, sum);
            return;
        }

        if(to>n) return;

        find(sum+arr[to][0], to +1 , use);
        find(sum+arr[to][1], to +2 , use);

        if(!use) find(sum+k, to +3 , true);
    }
}
