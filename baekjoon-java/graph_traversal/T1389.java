package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T1389 {
    static int n, m;
    static int[][] arr;
    static boolean[] check;
    static int tmp = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        int cnt, res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    check = new boolean[n + 1];
                    dfs(i, j, 1);
                    cnt += tmp;
                    tmp = 0;
                }
            }
            if (cnt < min) {
                min = cnt;
                res = i;
            }
        }


        System.out.println(res);
    }



    static void dfs(int s, int end, int cnt) {
        check[s] = true;
        for(int i =1; i<=n; i++){
            if(!check[i]){
                if( arr[s][i]==1 && i == end) {
                    tmp = cnt;
                    return;
                }
                else if (arr[s][i] == 1) dfs(i, end, cnt+1);
            }

        }
    }

}
