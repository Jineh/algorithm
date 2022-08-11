package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T13565 {
    static int m, n;
    static char [][] map;
    static boolean [][] check;
    static String res = "NO";
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = { 0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new char[m][n];
        check = new boolean[m][n];

        for(int i=0; i<m; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<n; i++){
            if(map[0][i] =='0'){
                dfs(0,i);
            }
        }
        System.out.println(res);
    }

    static void dfs(int y, int x){
        if(y == m-1) {
            res = "YES";
            return;
        }
        check[y][x] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 & ny >= 0 & nx<n & ny <m){
                if(!check[ny][nx] & map[ny][nx] == '0') dfs(ny, nx);
            }
        }
    }
}
