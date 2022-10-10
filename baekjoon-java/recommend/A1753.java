package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A1753 {
    static int n,m, start;
    static final int INF = 100_000_000;
    static ArrayList<Node>[] list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        Arrays.fill(dist, INF);

        start = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[x].add(new Node(y, cost));
        }

        solve(start);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            if(dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i]+"\n");
        }


        System.out.println(sb);

    }

    public static void solve(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        boolean[] check = new boolean[n+1];
        dist[start]=0;

        while(!q.isEmpty()){
            Node tmp = q.poll();

            if(check[tmp.n]) continue;
            check[tmp.n] = true;

            for(Node next : list[tmp.n]){
                if(dist[next.n] > tmp.cost + next.cost){
                    dist[next.n] = tmp.cost + next.cost;
                    q.add(new Node(next.n, dist[next.n]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node>{
        int n;
        int cost;

        public Node(int n, int cost){
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
