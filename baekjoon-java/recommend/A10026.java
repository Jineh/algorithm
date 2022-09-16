package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A10026 {
    static int n;
    static char[][] map;
    static boolean[][] check;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        check = new boolean[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int a=0,b=0, c=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!check[i][j]) {
                    dfs(i, j, map[i][j]);
                    a++;
                    if(map[i][j]=='B') c++;
                }
            }
        }


        check = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!check[i][j]) {
                    if(map[i][j]=='R'|| map[i][j]=='G') {
                        rgdfs(i, j);
                        b++;
                    }
                }
            }
        }
        b+=c;
        System.out.println(a+" "+b);
    }

    static void dfs(int x, int y, char s){
        check[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (!check[nx][ny] && map[nx][ny]==s )dfs(nx, ny, s);

        }

    }


    static void rgdfs(int x, int y){
        check[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (!check[nx][ny]){
                if(map[nx][ny]=='R'|| map[nx][ny]=='G') {
                    rgdfs(nx, ny);
                }
            }
        }

    }
}
