package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int[n+1];

        ArrayList<Integer> dist[] = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            dist[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[b]++;
            dist[a].add(b);
        }

        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int j=1; j<=n; j++) {
            if (arr[j] == 0) {
                q.offer(j);
            }
        }

        while(!q.isEmpty()){
            int x = q.poll();
            sb.append(x +" ");

            for(int tmp: dist[x]){
                arr[tmp]--;
                if(arr[tmp]==0) q.offer(tmp);
            }

        }


        System.out.println(sb);
    }
}
