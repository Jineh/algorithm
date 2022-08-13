package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T21938 {
    static int n, m, t;
    static int res = 0;
    static int[][] arr;
    static boolean[][] check;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        check = new boolean[n][m];

        int r, g, b, avg;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                r = Integer.parseInt(st.nextToken());
                g = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                avg = (r+g+b)/3;
                arr[i][j] = avg;
            }
        }
        t = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(arr[i][j] >= t && !check[i][j]){
                    dfs(i, j);
                    res++;
                }
            }
        }
        System.out.println(res);
    }


    static void dfs(int y, int x){
        check[y][x] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && ny >=0 && nx<m && ny <n){
                if(!check[ny][nx] && arr[ny][nx] >= t) dfs(ny, nx);
            }
        }
    }

}
