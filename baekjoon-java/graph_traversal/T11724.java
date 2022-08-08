package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T11724 {
    static int[][] arr;
    static boolean[] check;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        check = new boolean[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] =1;
        }

        int cnt =0;
        for(int i=1; i<=n; i++){
            if(check[i]==false){
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    static void dfs(int start){
        check[start] = true;
        for(int i=1; i<=n; i++){
            if(!check[i] && arr[start][i] ==1) dfs(i);
        }
    }
}
