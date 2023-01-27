import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S3000 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        PriorityQueue<Integer> max;
        PriorityQueue<Integer> min;
        int cnt = 0;
        long ans;

        while (T-- > 0) {
            ans=0;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int mid = Integer.parseInt(st.nextToken());
            max = new PriorityQueue<>(Collections.reverseOrder());
            min = new PriorityQueue<>();
            max.offer(mid);

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                max.offer(x);
                min.offer(y);

                if(max.peek()>min.peek()) {
                    int h = max.poll(), l = min.poll();
                    min.offer(h);
                    max.offer(l);
                }
                ans= (ans + max.peek())%20171109;
            }
            sb.append('#').append(++cnt).append(" ").append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
