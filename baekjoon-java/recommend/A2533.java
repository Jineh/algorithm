package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A2533 {
    static int n;
    static boolean[] check;
    static List<Integer>[] graph;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        check = new boolean[n+1];
        dp = new int[n+1][2];

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int start){
        check[start]= true;
        dp[start][0] = 0;
        dp[start][1] = 1;

        for(int child: graph[start]){
            if(!check[child]){
                dfs(child);
                dp[start][0] += dp[child][1];
                dp[start][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }


    }
}

