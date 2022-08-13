package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T2468 {
    static int n, h;
    static int res = 0;
    static int[][] arr;
    static boolean[][] check;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int tmp=0;
        h=0;
        while(h<100){
            tmp=0;
            check = new boolean[n][n];
            for(int i=0; i<n;i++){
                for(int j=0;j<n;j++){
                    if(!check[i][j] && arr[i][j]>h){
                        dfs(i,j);
                        tmp++;
                    }
                }
            }
            res = Math.max(tmp, res);
            h++;
        }

        System.out.println(res);
    }

    static void dfs(int y, int x){
        check[y][x] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && ny >= 0 && nx<n && ny <n){
                if(arr[ny][nx]>h && !check[ny][nx]) dfs(ny, nx);
            }
        }
    }

}
