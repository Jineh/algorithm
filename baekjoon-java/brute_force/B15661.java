package brute_force;

import java.io.*;
import java.util.StringTokenizer;

public class B15661 {
    static boolean[] check;
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        check = new boolean[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=1; i<=n/2; i++){
            find(0, 0, i, n, arr);
        }

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

    static void find(int x, int sum, int cnt, int n, int[][] arr){
        if(sum==cnt){
            int res=0, res2=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(check[i] && check[j]) res += arr[i][j];
                    else if(!check[i] && !check[j]) res2 += arr[i][j];
                }
            }
            res = Math.abs(res- res2);
            min = Math.min(res, min);
            return;
        }

        for(int i=x; i<n; i++){
            if(!check[i]){
                check[i] = true;
                find(i+1, sum+1, cnt, n, arr);
                check[i] = false;
            }
        }


    }
}
