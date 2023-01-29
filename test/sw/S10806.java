import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class S10806 {
    static ArrayList<Integer> arr;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int cnt = 0, ans;
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new ArrayList();
            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int k = Integer.parseInt(br.readLine());
            ans = find(k);
            sb.append('#').append(++cnt).append(" ").append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static int find(int k){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(k,0));
        while(!queue.isEmpty()){
                Node cur= queue.poll();
                int tmp = cur.data;
                if(tmp==0) return cur.cnt;
                queue.offer(new Node(0, tmp+cur.cnt));  //data 전부를 1로만 표현
                for(int a: arr){
                    queue.offer(new Node(tmp/a, tmp%a + cur.cnt));  //나머지를 1로 표현
                }
        }
        return 0;
    }

    static class Node implements Comparable<Node>{
        int data;
        int cnt;

        public Node(int data, int cnt){
            this.data = data;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node node) {
            if(this.cnt > node.cnt) return 1;
            else if(this.cnt < node.cnt) return -1;
            return 0;
        }
    }
}
