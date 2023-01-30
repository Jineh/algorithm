import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1251 {
    static int n;
    static int[] parent;
    static int[][] dist;
    static ArrayList<Node> nodes;
    static class Node implements Comparable<Node>{
        int x;
        int y;
        long data;

        public Node(int x, int y, long data){
            this.x = x;
            this.y = y;
            this.data = data;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.data, o.data);
        }
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int cnt = 0;

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            nodes = new ArrayList<>();
            parent = new int[n];
            dist = new int[n][2];
            for(int i=0; i<2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    dist[j][i] =Integer.parseInt(st.nextToken());
                }
            }
            double e = Double.parseDouble(br.readLine());
            init();
            nodes.sort(null);
            long ans = find();
            sb.append('#').append(++cnt).append(" ").append(Math.round(ans*e)).append('\n');
        }
        System.out.println(sb);
    }

    static void init(){
        for(int i=0; i<n; i++){
            parent[i] = i;
            for(int j=i+1; j<n; j++){
                long a = Math.abs(dist[i][0] - dist[j][0]);
                long b = Math.abs(dist[i][1] - dist[j][1]);
                long cal = (a*a+b*b);
                nodes.add(new Node(i, j, cal));
            }
        }
    }

    static long find(){
        long res=0;
        int cnt=0;
        for(int i=0; i<nodes.size(); i++){
            Node node = nodes.get(i);

            int a = getParent(node.x);
            int b = getParent(node.y);

            if(a==b) continue;
            else {
                res+=node.data;
                parent[b]=a;
            }

            if(++cnt==n-1) break;
        }
        return res;
    }

    static int getParent(int x){
        if(x==parent[x]) return x;
        else return parent[x] = getParent(parent[x]);
    }
}
