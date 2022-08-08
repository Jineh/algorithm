package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T1260 {

    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static boolean[] check;
    static int n, m, v;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        check = new boolean[n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }
        dfs(v);
        sb.append("\n");
        check = new boolean[n+1];

        bfs(v);
        System.out.println(sb);
    }

    static void dfs(int start){
        check[start] = true;
        sb.append(start+ " ");

        for(int i=1; i<=n; i++){
            if(arr[start][i] == 1 && !check[i]) dfs(i);
        }
    }

    static void bfs(int start){
        q.offer(start);
        check[start] = true;

        while(!q.isEmpty()){

            start = q.poll();
            sb.append(start + " ");

            for(int i=1; i<=n; i++){
                if(arr[start][i] == 1 && !check[i]){
                    q.offer(i);
                    check[i] = true;
                }
            }

        }
    }
}
