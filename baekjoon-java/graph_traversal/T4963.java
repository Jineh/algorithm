package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T4963 {
    static int w,h;
    static int [][] arr;
    static boolean [][] check;
    static int [] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int [] dy = { 0, 0, -1, 1, 1, -1, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 & h == 0) break;
            arr = new int[h][w];
            check = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt =0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(arr[i][j]==1 & !check[i][j]){
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt);
            sb.append("\n");
        }
        System.out.println(sb);
    }


    static void dfs(int y, int x){
            check[y][x] = true;
            for(int i=0; i<8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 & ny>=0 & nx<w & ny<h){
                    if(arr[ny][nx] == 1 & !check[ny][nx]) dfs(ny, nx);
                }
            }
    }
}
