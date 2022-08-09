package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class T11725 {
    static int n;
    static ArrayList<Integer>[] arr;
    static boolean [] check;
    static int [] parent;
    static int res=-1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n+1];
        check = new boolean[n+1];
        parent = new int [n+1];

        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<Integer>();
        }

        StringTokenizer st;
        int x,y;
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }

        dfs(1, 0);

        for(int i=2; i<=n; i++){
            System.out.println(parent[i]);
        }
    }
    static void dfs(int s, int p){
        parent[s] = p;
        for(int i : arr[s]){
            if(i != p) dfs(i, s);
        }
    }

}
