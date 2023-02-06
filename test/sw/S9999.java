import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S9999{
    static class Node {
        int begin, end;
        int sum;

        public Node(int begin, int end, int sum){
            this.begin = begin;
            this.end = end;
            this.sum = sum;
        }
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            int l = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            Node[] nodes = new Node[n];
            int s1, e1 , sum=0;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                s1 = Integer.parseInt(st.nextToken());
                e1 = Integer.parseInt(st.nextToken());
                sum +=e1 - s1;
                nodes[j] = new Node(s1, e1, sum);
            }

            int ans=0;
            for(int i=0; i<n; i++){
                int begin = nodes[i].begin, end = begin + l;
                Node cur = nodes[find(nodes, end)];
                sum = cur.sum - nodes[i].sum + nodes[i].end - nodes[i].begin;
                if(end <cur.end && end > cur.begin){
                    sum -= cur.end - end;
                }
                else if(end < cur.end){
                    sum -= cur.end - cur.begin;
                }
                ans = Math.max(ans, sum);
            }

            sb.append('#').append(tc).append(" ").append(ans).append('\n');
        }
        System.out.print(sb);
    }

    static int find(Node[] nodes, int l) {
        int begin = 0, end = nodes.length-1, mid;
        while(begin != end){
            mid = begin + ((end-begin)>>1);
            if(nodes[mid].end>=l) end = mid;
            else begin= mid+1;
        }
        return end;
    }
}