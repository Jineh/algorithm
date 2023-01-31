import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S4006 {

    static class Node implements Comparable<Node>{
        int x, y;
        int data;

        public Node(int x, int y, int data){
            this.x = x;
            this.y = y;
            this.data = data;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.data, o.data);
        }
    }
    static ArrayList<Node> nodes;
    static int n;
    static int[] parent;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int cnt = 0;

        while (T-- > 0) {
            nodes = new ArrayList<>();
            n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            parent = new int[n+1];
            while(m-->0){
                st = new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                int data = Integer.parseInt(st.nextToken());
                nodes.add(new Node(x,y,data));
            }
            nodes.sort(null);
            setParent();
            long ans = find();

            sb.append('#').append(++cnt).append(" ").append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static void setParent(){
        for(int i=0; i<=n; i++) parent[i] = i;
    }

    static long find(){
        long res=0;
        int cnt=0;
        for(Node node : nodes){
            int a = getParent(node.x);
            int b = getParent(node.y);

            if(a==b) continue;
            else{
                parent[b] =a;
                res+=node.data;
                if(++cnt==n-1) break;
            }
        }
        return res;
    }

    static int getParent(int x){
        if(x==parent[x]) return x;
        else return parent[x] = getParent(parent[x]);
    }
}

