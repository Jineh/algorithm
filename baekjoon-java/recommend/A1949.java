package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A1949 {
    static int n;
    static int[] arr;
    static boolean[] check;
    static List<Integer>[] graph;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        graph = new ArrayList[n+1];
        check = new boolean[n+1];
        dp = new int[n+1][2];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int start){
        check[start]= true;
        dp[start][0] = 0;
        dp[start][1] = arr[start];

        for(int child: graph[start]){
            if(!check[child]){
                dfs(child);
                dp[start][0] += Math.max(dp[child][1], dp[child][0]);
                dp[start][1] += dp[child][0];
            }
        }


    }
}
