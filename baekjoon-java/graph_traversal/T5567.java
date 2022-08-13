package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T5567 {
    static int n, m;
    static int res=0;
    static int[][] arr;
    static boolean[] check;
    static Queue<Integer> q = new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        check = new boolean[n+1];
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] =1;
            if(a==1){
                res++;
                q.offer(b);
            }
            if(b==1){
                res++;
                q.offer(a);
            }
        }

        bfs();
        System.out.println(res);
    }

    static void bfs(){
        while(!q.isEmpty()){
            int next = q.poll();
            check[next] = true;
            for(int i=2; i<=n; i++){
                if(arr[next][i]==1 && !check[i] && !q.contains(i)){
                    check[i] = true;
                    res++;
                }
            }

        }
    }

}
