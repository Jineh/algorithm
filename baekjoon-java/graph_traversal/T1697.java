package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T1697 {
    static int n, k;
    static boolean[] check;
    static Queue<Integer> q = new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        check = new boolean[100000+1];
        q.offer(n);

        int cnt=0;
        while(!q.isEmpty()) {
            int t = q.size();
            while(t-- >0) {
                int x = q.poll();
                if (x == k) {
                    System.out.println(cnt);
                    return;
                }
                check[x] = true;

                if (x + 1 <= k && !check[x + 1]) {
                    check[x + 1] = true;
                    q.offer(x + 1);
                }
                if (x - 1 >= 0 && !check[x - 1]) {
                    check[x - 1] = true;
                    q.offer(x - 1);
                }
                if (x * 2 <= 100000 ){
                    if(!check[x*2]) {
                        check[x * 2] = true;
                        q.offer(x * 2);
                    }
                }
            }
            cnt++;
        }
    }
}
