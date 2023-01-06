import java.util.*;

public class P72413 {
    static class Node implements Comparable<Node>{
        int p;
        int cost;

        public Node(int p, int cost) {
            this.p = p;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static ArrayList<ArrayList<Node>> graph;
    static int MAX = 20000001;
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] i :fares){
            graph.get(i[0]).add(new Node(i[1], i[2]));
            graph.get(i[1]).add(new Node(i[0], i[2]));
        }

        int[] startA = new int[n + 1];
        int[] startB = new int[n + 1];
        int[] start = new int[n + 1];

        Arrays.fill(startA, MAX);
        Arrays.fill(startB, MAX);
        Arrays.fill(start, MAX);

        startA = dijkstra(a, startA);
        startB = dijkstra(b, startB);
        start = dijkstra(s, start);

        for(int i = 1; i <= n ; i ++) answer = Math.min(answer, startA[i] + startB[i] + start[i]);
        return answer;
    }

    static int[] dijkstra (int start, int[] costs){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        costs[start] = 0;

        while(!pq.isEmpty()){
            Node tmp = pq.poll();

            if(tmp.cost > costs[tmp.p]) continue;

            ArrayList<Node> nodes = graph.get(tmp.p);
            for(Node node: nodes){
                int cost = node.cost + costs[tmp.p];

                if(cost < costs[node.p]){
                    costs[node.p] = cost;
                    pq.offer(new Node(node.p, cost));
                }
            }
        }
        return costs;
    }

    public static void main(String[] args) {
        int[][] a = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(P72413.solution(6, 4, 6, 2, a));
    }
}
