import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S2930 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue;
        StringBuffer sb = new StringBuffer();
        StringBuffer ans;
        StringTokenizer st;
        int cnt = 0;
        int n, m, x;
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            queue = new PriorityQueue<>(Collections.reverseOrder());
            ans = new StringBuffer();
            while(n-->0){
                st = new StringTokenizer(br.readLine());
                m = Integer.parseInt(st.nextToken());
                if(m==1) {
                    x= Integer.parseInt(st.nextToken());
                    queue.offer(x);
                }
                else{
                    if(queue.isEmpty()) ans.append("-1 ");
                    else ans.append(queue.poll()).append(" ");
                }
            }
            sb.append('#').append(++cnt).append(" ").append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
