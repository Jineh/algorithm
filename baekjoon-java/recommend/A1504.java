package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class A1504 {
    static int n,e, v1, v2, c=-1;
    static final int INF = 200_000_000;
    static ArrayList<Node>[] list;
    static boolean[] check;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        check = new boolean[n+1];

        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[x].add(new Node(y, cost));
            list[y].add(new Node(x, cost));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int res1=0;
        res1 += solve(1, v1);
        res1 += solve(v2, v1);
        res1 += solve(v2, n);

        int res2=0;
        res2 += solve(1, v2);
        res2 += solve(v2, v1);
        res2 += solve(v1, n);

        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

        System.out.println(ans);

    }

    public static int solve(int start, int end){
        Arrays.fill(dist, INF);
        Arrays.fill(check, false);

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start,0));
        dist[start] = 0;

        while(!q.isEmpty()){
            Node tmp = q.poll();

            if(!check[tmp.n]) check[tmp.n] = true;

            for(Node next : list[tmp.n]){

                if(!check[next.n] && dist[next.n] >next.cost + tmp.cost){
                    dist[next.n] = next.cost + tmp.cost;
                    q.add(new Node(next.n, dist[next.n]));
                }
            }
        }
        return dist[end];
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
