package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T2644 {
    static int n;
    static int a,b,c;
    static int [][] arr;
    static boolean [] check;
    static int res=-1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c= Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        check = new boolean[n+1];
        int x,y;

        for(int i=1; i<=c;i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] =1;
        }

        dfs(a,0);
        System.out.println(res);
    }

    static void dfs(int x, int cnt){
        if(x == b) {
            res = cnt;
            return;
        }
        check[x] = true;
        for(int i=1; i<=n; i++){
            if(!check[i] && arr[x][i] == 1) dfs(i,cnt+1);
        }
    }


}
