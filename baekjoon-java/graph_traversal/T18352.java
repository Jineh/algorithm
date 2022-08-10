package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T18352 {
    static int n,m,k,x;
    static ArrayList<Integer>[] arr;
    static int [] loc;
    static int res=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        loc = new int[n+1];

        for(int i =1; i<=n; i++){
            loc[i] = -1;
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
        }

        loc[x] =0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        while(!q.isEmpty()){
            int now = q.poll();

            for(int i : arr[now]){
                if(loc[i]==-1){
                    loc[i] = loc[now]+1;
                    q.offer(i);
                }
            }

        }

        for(int i=1; i<=n; i++){
            if(loc[i]==k){
                res++;
                System.out.println(i);
            }
        }

        if(res==0) System.out.println(-1);
    }

}
