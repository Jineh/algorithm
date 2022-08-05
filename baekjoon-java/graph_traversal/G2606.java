package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2606 {
    static int [] check;
    static int[][] arr;
    static int cnt =0;
    static int n;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());

        arr = new int[n+1][n+1];
        check = new int[n+1];

        StringTokenizer st;
        for(int i=0; i<c; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] =1;


        }

        dfs(1);
        System.out.println(cnt-1);

    }
    public static void dfs(int start){
        check[start] = 1;
        cnt++;

        for(int i=1; i<=n;i++){
            if(arr[start][i] ==1 && check[i]==0) dfs(i);
        }
    }
}
