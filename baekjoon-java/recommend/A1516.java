package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n+1];
        int [] check = new int[n+1];
        int [] dp = new int[n+1];
        ArrayList<Integer>[] dist = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            dist[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp!=-1) {
                    dist[tmp].add(i);
                    check[i]++;
                }
            }


        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(check[i]==0) {
                q.offer(i);
                dp[i] = arr[i];
            }
        }

        while(!q.isEmpty()){
            int tmp = q.poll();

            for(int next: dist[tmp]){
                check[next]--;
                dp[next] = Math.max(dp[next], dp[tmp]+arr[next]);
                if(check[next]==0) q.offer(next);
            }
        }

        for(int i=1; i<=n; i++){
            System.out.println(dp[i]);
        }

    }
}
