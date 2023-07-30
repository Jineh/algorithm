package graph_traversal;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1916 {
    static int[] des;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>>arr = new ArrayList<>();
        des = new int[n+1];

        for(int i=0; i<=n; i++) {
            arr.add(new ArrayList<Node>());
            des[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            int z= Integer.parseInt(st.nextToken());
            arr.get(x).add(new Node(y, z));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        des[start] = 0;
        find(start, arr);
        System.out.println(des[end]);

    }

    public static void find(int start, ArrayList<ArrayList<Node>> arr) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        while(!queue.isEmpty()) {
            Node tmp = queue.poll();


            if(tmp.cost > des[tmp.x]) continue;

            for(Node node : arr.get(tmp.x)) {
                if(des[node.x] > node.cost + des[tmp.x]) {
                    des[node.x] = node.cost + des[tmp.x];
                    queue.offer(new Node(node.x, des[node.x]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        private int x;
        private int cost;

        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.x - o.x;
        }
    }
}
