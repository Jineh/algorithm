package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class T1325 {
    static int n, m;
    static ArrayList<Integer>[] arr;
    static int[] my;
    static boolean[] check;
    static int res=0;
    static int max=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        StringBuffer sb = new StringBuffer();
        my = new int[n+1];

        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
        }


        for(int i =1; i<=n; i++){
            check = new boolean[n + 1];
            dfs(i);
        }

        int max =0;
        for(int i=1; i<=n; i++){
            max = Math.max(max, my[i]);
        }

        for(int i=1; i<=n; i++){
            if(max == my[i]) System.out.print(i + " ");
        }

    }

    static void dfs(int s){
        check[s] = true;
        for(int item : arr[s]){
            if(!check[item]){
                dfs(item);
                my[item]++;
            }
        }
    }
}
